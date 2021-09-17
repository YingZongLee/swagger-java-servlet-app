package com.yls.demo.pojo;

public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(T data) {
        this.code = 200;
        this.message = "Success to get weather resources.";
        this.data = data;
    }
}
