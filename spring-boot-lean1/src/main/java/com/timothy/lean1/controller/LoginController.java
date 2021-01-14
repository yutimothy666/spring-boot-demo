package com.timothy.lean1.controller;

import com.timothy.lean1.config.QrCodeStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Description: login
 * @Author: timothyyu
 * @Date: 2021/1/14 10:56
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    public static final String prefix = "/login/";
    @Resource
    QrCodeStatus qrCodeStatus;

    @RequestMapping(value = {"", "/"})
    public String index(String qrId, ModelMap modelMap) {
        modelMap.put("qrId", qrId);
        if (Objects.nonNull(qrId)) {
            qrCodeStatus.setStatus(1);
        }
        return prefix + "index";
    }
}
