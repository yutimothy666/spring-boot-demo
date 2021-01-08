package com.timothy.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/6 16:11
 */
@Component
@Order(value = 1)
public class ShowIPPortRunner implements ApplicationRunner {
    @Value("${server.port}")
    private String port;

    private static final Logger logger = LoggerFactory.getLogger(ShowIPPortRunner.class);

    public void run(ApplicationArguments args) throws Exception {
        logger.info("server start success!!");
        System.out.println("server start on http://" + IPAddressConverter.getIpAddress() + ":" + port);
    }
}
