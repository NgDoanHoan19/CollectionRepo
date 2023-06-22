package com.example.collection.constain;

import org.springframework.http.HttpStatus;

public enum ApiCode {
    SUCCESS(HttpStatus.OK, "200","Thành Công!"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "404","Not Found"),
    STUDENT_NOT_FOUND(HttpStatus.OK,"301","Không tồn tại học sinh có mã ID này!");


    private HttpStatus status;
    private String code;
    private String message;

    ApiCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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
