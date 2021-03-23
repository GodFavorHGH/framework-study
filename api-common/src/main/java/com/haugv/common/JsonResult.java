package com.haugv.common;

import lombok.Data;

public class JsonResult<T> {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JsonResult(int code, String message){
        this(code, message, null);
    }

    public JsonResult(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static JsonResult error(String message){
        return new JsonResult(444,message,null);
    }
}
