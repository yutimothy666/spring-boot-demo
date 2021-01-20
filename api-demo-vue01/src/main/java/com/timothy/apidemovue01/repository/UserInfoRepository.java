package com.timothy.apidemovue01.repository;

import com.timothy.apidemovue01.dao.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/28 12:44
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
