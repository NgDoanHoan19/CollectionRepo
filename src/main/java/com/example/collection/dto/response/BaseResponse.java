package com.example.collection.dto.response;


import com.example.collection.constain.ApiCode;
import lombok.Data;

@Data
public class BaseResponse<T> {
    private String status;
    private String message;
    private String code;
    private T data;

    public BaseResponse(T data) {
        this.status = "OK";
        this.code = "200";
        this.message = "SUCCESS";
        this.data = data;
    }

    public BaseResponse() {
        this.status = "OK";
        this.code = "200";
        this.message = "SUCCESS";
    }

    public BaseResponse(String status, String message, String code, T data) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public BaseResponse(ApiCode apiCode){
        this.status = apiCode.getStatus().name();
        this.code = apiCode.getCode();
        this.message =apiCode.getMessage();
    }

    public BaseResponse(ApiCode apiCode,T data){
        this.status = apiCode.getStatus().name();
        this.code =apiCode.getCode();
        this.message = apiCode.getMessage();
        this.data = data;
    }
}
