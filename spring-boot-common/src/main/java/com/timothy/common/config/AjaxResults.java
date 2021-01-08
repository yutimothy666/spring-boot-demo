package com.timothy.common.config;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author yutimothy
 * @Date 2020/12/25 12:34
 * @Version 1.0
 */
public class AjaxResults<T> extends HashMap<String, Object> implements Serializable {
    static final long serialVersionUID = 1L;
    private String code = "200";
    private String msg = "ok";
    private T data;

    public AjaxResults(String code, String msg, T data) {
        put("code", code);
        put("msg", msg);
        put("data", data);
    }

    public static <T> AjaxResults<T> success(T data) {
        return new AjaxResults<T>("200", "ok", data);
    }

    public static <T> AjaxResults<T> error(String msg, T data) {
        return new AjaxResults<T>("200", msg, data);
    }

    public static <T> AjaxResults<T> error(String msg) {
        return new AjaxResults<T>("200", msg, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
