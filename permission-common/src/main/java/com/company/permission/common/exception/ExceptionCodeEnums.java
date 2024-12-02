package com.company.permission.common.exception;

public enum ExceptionCodeEnums implements ExceptionHandler {

    SUCCESS(200, "操作成功"),
    FALL(400, "操作失败"),
    NOT_FOUND(404, "接口不存在"),
    ERROR(500, "系统异常");

    private long code;
    private String message;

    private ExceptionCodeEnums(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
