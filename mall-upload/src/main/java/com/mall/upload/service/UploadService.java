package com.mall.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @auther YZO
 * @date 2020/1/26 12:15
 */
public interface UploadService {
    String uploadImage(MultipartFile file);
}
