package com.gardener.dto;

public class GardenerResponse<T> {
    private T data;
    private String code;
    private String message;

    public GardenerResponse() {
        this.code = "200";
        this.message = "成功";
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
