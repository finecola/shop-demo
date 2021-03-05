package com.choco.manager.service;

import com.choco.common.result.FileResult;

import java.io.InputStream;

/**
 * Created by choco on 2020/12/30 19:11
 */
public interface UploadService {
    FileResult upload(InputStream inputStream, String fileName);
}
