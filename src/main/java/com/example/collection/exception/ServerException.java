package com.example.collection.exception;

import com.example.collection.constain.ApiCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ServerException extends RuntimeException {
    private String code;
    private String message;
    private HttpStatus status;

    public ServerException(ApiCode errorCode, String message) {
        this.code = errorCode.getCode();
        this.message = message;
        this.status = errorCode.getStatus();
    }

    public ServerException(ApiCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    public ServerException(String message) {
        this.message = message;
    }
}
