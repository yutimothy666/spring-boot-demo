package com.timothy.lean1.config;

import com.timothy.common.bean.BlogInfo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @Description: ok
 * @Author: timothyyu
 * @Date: 2021/1/26 14:32
 */
public class AllConfig {
    @Bean
    public BlogInfo blogInfo() {
        return BlogInfo.builder().blogContent("name").build();
    }
}
