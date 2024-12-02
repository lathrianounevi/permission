package com.company.permission.common.exception;

/**
 * @author candylove
 * @date 2024/12/2 16:07
 */
public class BizException extends RuntimeException{
    public BizException() {}
    public BizException(String message) {
        super(message);
    }
}
