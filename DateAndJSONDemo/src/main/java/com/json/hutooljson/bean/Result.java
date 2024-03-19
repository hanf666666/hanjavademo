package com.json.hutooljson.bean;

import com.alibaba.fastjson.JSON;

import lombok.Data;

import java.util.Collection;
import java.util.List;


/**
 * 接口传输响应模板类
 *
 * @param <T>
 */
@Data
public class Result<T> {
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    /**
     * 状态码
     */
    private Boolean flag;

    /**
     * 传输数据
     */
    private T data;

    /**
     * 消息提示
     */
    private String msg;

    /**
     * 结果编码 0请求成功 403未登录 500请求失败
     */
    private Integer code;

    /**
     * 成功结果
     */






    public static <T> Result<T> success(Integer code, String msg, T data) {
        return new Result<>(true, data, msg, code);
    }

    /**
     * 请求参数错误
     */


    /**
     * 失败结果
     */


    public static <T> Result<T> failed(Integer code, String msg) {
        return new Result<T>(false, msg, code);
    }


    public Result() {
        super();
    }

    public Result(Boolean flag, T data, String msg, Integer code) {
        super();
        this.flag = flag;
        if ((data instanceof List) || (data instanceof Collection)){

        }
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public Result(Boolean flag, String msg, Integer code) {
        super();
        this.flag = flag;
        this.msg = msg;
        this.code = code;
    }



    public Result msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }

    public Result flag(Boolean flag) {
        this.flag = flag;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
