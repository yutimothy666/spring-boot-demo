package com.timothy.common.component;

import com.timothy.common.config.AjaxResults;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/8 14:10
 */
@RestController
@Profile("dev")
@RequestMapping(value = "/ping")
public class PingController {
    @RequestMapping(value = {"", "/"})
    @ResponseBody
    public AjaxResults<String> ping(@RequestParam(value = "ping", required = false, defaultValue = "") String ping) {
        return AjaxResults.success(ping);
    }
}
