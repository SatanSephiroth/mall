package com.mall.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author YZO
 * @date 2020/1/26 12:15
 */
public interface UploadService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    String uploadImage(MultipartFile file);
}
