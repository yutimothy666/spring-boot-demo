package com.timothy.lean1.controller;

import com.timothy.common.config.AjaxResults;
import com.timothy.lean1.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author yutimothy
 * @Date 2020/12/25 12:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;

    @RequestMapping(value = {"", "/"})
    public AjaxResults<String> test() {
        return AjaxResults.success("test");
    }

    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "redirect")
    public void redirect(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        request.getRequestDispatcher("/test").forward(request, response);
        response.sendRedirect("https://www.baidu.com");
    }
}
