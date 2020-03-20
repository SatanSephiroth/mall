package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author YZO
 * @date 2020/1/26 12:12
 */
@SpringBootApplication
@EnableEurekaServer
public class MallRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallRegistryApplication.class);
    }
}
