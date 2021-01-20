package com.timothy.apidemovue01.controller;

import com.timothy.apidemovue01.dao.UserInfo;
import com.timothy.apidemovue01.repository.UserInfoRepository;
import com.timothy.common.config.AjaxResults;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/28 12:46
 */
@RestController
@RequestMapping(value = "userInfo")
public class UserInfoController {
    @Resource
    UserInfoRepository userInfoRepository;

    @RequestMapping(value = "")
    public AjaxResults<List<UserInfo>> list(UserInfo userInfo) {
        IntStream.range(1,10).forEach( i-> userInfoRepository.save(UserInfo.builder().id((long) i).email(i + "qq.com").password(UUID.randomUUID().toString().substring(1, 10)).build()));
        Example<UserInfo> example = Example.of(userInfo);
        return AjaxResults.success(userInfoRepository.findAll(example));
    }
}
