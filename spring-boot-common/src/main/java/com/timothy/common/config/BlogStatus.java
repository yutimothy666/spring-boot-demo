package com.timothy.common.config;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yutimothy
 * @Date 2020/12/27 20:05
 * @Version 1.0
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BlogStatus {
    AWAIT {
        @Override
        public String getName() {
            return "等待审核";
        }
    },
    ACCEPT {
        @Override
        public String getName() {
            return "通过审核";
        }
    },
    ;

    public static Map<String, String> getMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        for (BlogStatus status : BlogStatus.values()) {
            map.put(status.getName(), status.getValue());
        }
        return map;
    }

    public abstract String getName();

    public String getValue() {
        return String.valueOf(this.ordinal());
    }

    @Override
    public String toString() {
        return getName();
    }
}
