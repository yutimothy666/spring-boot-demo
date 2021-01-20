package com.timothy.lean1.config;

import com.timothy.common.bean.BlogInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/26 14:33
 */
@Configuration
public class Myconfig extends AllConfig implements WebMvcConfigurer {

    @Bean
    @Override
    public BlogInfo blogInfo() {
        return super.blogInfo();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return false;
            }
        });
    }
}
