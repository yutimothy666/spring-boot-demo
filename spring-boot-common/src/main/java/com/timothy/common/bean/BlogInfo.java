package com.timothy.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.timothy.common.config.BlogStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author yutimothy
 * @Date 2020/12/27 20:00
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogInfo {
    private String blogTitle;
    private String blogContent;
    private Long numberOfVisits;
    private Long userID;

    private BlogStatus status = BlogStatus.AWAIT;
}
