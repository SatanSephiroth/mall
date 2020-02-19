package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther YZO
 * @date 2020/1/26 12:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MallUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallUploadApplication.class);
    }
}
