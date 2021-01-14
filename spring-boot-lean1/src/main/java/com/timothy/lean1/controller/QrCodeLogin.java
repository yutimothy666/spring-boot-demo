package com.timothy.lean1.controller;

import com.timothy.common.config.AjaxResults;
import com.timothy.lean1.config.QrCodeStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description: qrcodeLogin
 * @Author: timothyyu
 * @Date: 2021/1/14 10:51
 */
@RequestMapping("/qrCode")
@Controller
public class QrCodeLogin {

    @Resource
    QrCodeStatus qrCodeStatus;

    public static final String prefix = "/qrCode/";

    @RequestMapping(value = {"", "/"})
    public String qrCode(ModelMap modelMap) {
        String qrId = UUID.randomUUID().toString().substring(0, 10);
        modelMap.put("qrId", qrId);
        return prefix + "index";
    }

    @ResponseBody
    @PostMapping(value = "status")
    public AjaxResults<Integer> status() {
        return AjaxResults.success(qrCodeStatus.getStatus());
    }
}
