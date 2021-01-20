package com.timothy.apidemovue01.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/28 12:39
 */
@Entity(name = "user_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;
}
