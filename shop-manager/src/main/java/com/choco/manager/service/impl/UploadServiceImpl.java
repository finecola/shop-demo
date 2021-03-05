package com.choco.manager.service.impl;

import com.choco.common.result.FileResult;
import com.choco.manager.service.UploadService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by choco on 2020/12/30 19:13
 */
@Service
@SuppressWarnings("all")
public class UploadServiceImpl implements UploadService {
    @Override
    public FileResult upload(InputStream inputStream, String fileName) {
        FileResult fileResult = new FileResult();
        //构造一个带指定 Region 对象的配置类. region0代表 华东
        Configuration cfg = new Configuration(Region.region0());

        //UploadManager 上传工具类
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "_NNNFeFmqojAKT6iCvnQv-qM5I83abqwqiWWtAuV";
        String secretKey = "uOIxEhYzwvrxHJhcdkebHj3cpd4a5duUb5c1tlX8";
        String bucket = "finecola";
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        //鉴权
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(inputStream, key, upToken, null, null);
            if (response.statusCode == 200) {
                fileResult.setSuccess("success");
                fileResult.setMessage("上传成功");
                fileResult.setFileUrl("http://qm5ac53bz.hd-bkt.clouddn.com/" + fileName);
                return fileResult;
            } else {
                fileResult.setError("error");
                fileResult.setMessage("上传失败");
                return null;
            }
        } catch (QiniuException ex) {
            Response r = ex.response;
            fileResult.setError("error");
            fileResult.setMessage("发生异常");
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return fileResult;
    }
}
