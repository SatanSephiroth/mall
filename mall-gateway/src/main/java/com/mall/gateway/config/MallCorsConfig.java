package com.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author XiaoJack
 * @date 2020/1/23
 */
@Configuration
public class MallCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        //初始化cors配置
        CorsConfiguration configuration = new CorsConfiguration();
        //允许跨域的域名,如果要携带cookie,不能写*,*代表所有域名都可以访问
        configuration.addAllowedOrigin("http://manage.leyou.com");
        //允许携带cookie
        configuration.setAllowCredentials(true);
        //代表所有的请求方法:get post put delete...
        configuration.addAllowedMethod("*");
        //允许携带任何头信息
        configuration.addAllowedHeader("*");

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);

        //返回corsFilter实例
        return new CorsFilter(configurationSource);
    }

}
