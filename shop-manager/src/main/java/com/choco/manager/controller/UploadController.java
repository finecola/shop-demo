package com.choco.manager.controller;

import com.choco.common.result.FileResult;
import com.choco.manager.service.impl.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by choco on 2020/12/30 19:11
 */
@Controller
@RequestMapping("fileUpload")
public class UploadController {
    @Autowired
    private UploadServiceImpl uploadService;

    @ResponseBody
    @RequestMapping("save")
    public FileResult fileUpload(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        //防止filename重复
        filename = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now())+System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."));
        return uploadService.upload(file.getInputStream(), filename);
    }
}
