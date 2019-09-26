package com.lee.demo.api.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LCQ
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private T data;
    private String message;

    public Result(boolean isSuccess, T data, String message) {
        this.success = isSuccess;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> createFailResult(String errorMsg) {
        return new Result<>(false, null, errorMsg);
    }

    public static <T> Result<T> createFailResult(T data, String errorMsg) {
        return new Result<>(false, data, errorMsg);
    }

    public static <T> Result<T> createSuccessResult(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> createSuccessResult(T data, String msg) {
        return new Result<>(true, data, msg);
    }


}
