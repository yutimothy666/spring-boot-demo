package com.timothy.lean1.config;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/14 11:18
 */
@Component
public class QrCodeStatus {
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
