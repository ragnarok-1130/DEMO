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

}
