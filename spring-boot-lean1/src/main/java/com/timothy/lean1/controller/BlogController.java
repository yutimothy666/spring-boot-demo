package com.timothy.lean1.controller;

import com.timothy.common.bean.BlogInfo;
import com.timothy.common.config.AjaxResults;
import com.timothy.common.config.BlogStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author yutimothy
 * @Date 2020/12/28 18:28
 * @Version 1.0
 */
@CrossOrigin
@RequestMapping("/blog")
@RestController
public class BlogController {

    @RequestMapping(value = {"", "/"})
    public AjaxResults<List<BlogInfo>> list() {
        ArrayList<BlogInfo> blogInfos = new ArrayList<>();
        IntStream.range(0, 20).forEach(item -> {
            blogInfos.add(BlogInfo.builder().blogTitle("" + item).blogContent("content" + item).userID((long) item).status(BlogStatus.AWAIT).numberOfVisits(0L).build());
        });
        return AjaxResults.success(blogInfos);
    }
}
