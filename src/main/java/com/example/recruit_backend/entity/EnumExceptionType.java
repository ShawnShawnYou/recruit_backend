package com.example.recruit_backend.entity;

public enum EnumExceptionType {
    PARAM_ILLEGAL(1000, "参数非法");


    private int errorCode;

    private String codeMessage;

    EnumExceptionType(int errorCode, String codeMessage) {
        this.errorCode = errorCode;
        this.codeMessage = codeMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getCodeMessage() {
        return codeMessage;
    }
}
