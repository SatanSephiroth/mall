package com.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author XiaoJack
 * @date 2020/1/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.mall.item.mapper")
public class MallItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallItemApplication.class);
    }
}
