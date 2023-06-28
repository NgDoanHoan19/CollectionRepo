package com.example.collection.exception;


import com.example.collection.dto.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.example.collection.constain.Constants.STATUS_FAIL;

@ControllerAdvice
@Slf4j
public class ServerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<BaseResponse> handleServerException(HttpServletRequest request, ServerException ex) {
        log.error("Handler exception : message {}", ex.getMessage());
        return new ResponseEntity<>(new BaseResponse(STATUS_FAIL, ex.getCode(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
