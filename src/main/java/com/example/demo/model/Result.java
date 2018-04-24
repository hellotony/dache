package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * @author luogeng.szq
 * @version $$Id:Result.java, v0.1 2018/2/6 下午4:59 Exp$$
 **/
@JsonFormat
public class Result implements Serializable {

    private static final long serialVersionUID = 696165072636355067L;

    @JsonFormat
    private boolean result = true;

    @JsonFormat
    private Integer errorCode;

    @JsonFormat
    private String errorMsg;

    public Result() {

    }

    public Result(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.result = false;
    }

    public Result(String errorMsg) {
        this.errorMsg = errorMsg;
        this.result = false;
    }

    public static Result paramError() {
        return new Result("参数不合法");
    }

    public static Result executeError() {
        return new Result("执行失败");
    }

    public static Result isOk() {
        return new Result();
    }


    @Override
    public String toString() {
        return "Result{" +
            "result=" + result +
            ", errorCode=" + errorCode +
            ", errorMsg='" + errorMsg + '\'' +
            '}';
    }
}
