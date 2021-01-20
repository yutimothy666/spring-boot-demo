package com.timothy.common.bean;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/26 15:03
 */
@Data
public class InitTestBean implements InitializingBean {
    private BlogInfo blogInfo;
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        this.name = "ok";
    }
}
