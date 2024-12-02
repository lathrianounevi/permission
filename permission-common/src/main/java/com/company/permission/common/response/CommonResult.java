package com.company.permission.common.response;

import com.company.permission.common.exception.ExceptionCodeEnums;
import lombok.Data;

/**
 * @author candylove
 * @date 2024/11/29 10:42
 */
@Data
public class CommonResult<T> {

    private long code;
    private String message;
    private T data;

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(ExceptionCodeEnums.SUCCESS.getCode(), ExceptionCodeEnums.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     * @param data
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ExceptionCodeEnums.SUCCESS.getCode(), ExceptionCodeEnums.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return new CommonResult<>(ExceptionCodeEnums.FALL.getCode(), ExceptionCodeEnums.FALL.getMessage(), null);
    }

}
