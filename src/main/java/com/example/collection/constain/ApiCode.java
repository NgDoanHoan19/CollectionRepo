package com.example.collection.constain;

import org.springframework.http.HttpStatus;

public enum ApiCode {
    SUCCESS(HttpStatus.OK, "200", "Thành Công!"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "404", "Not Found"),
    VALIDATE_AGE(HttpStatus.OK, "305", "Tuổi Không Hợp Lệ !"),
    VALIDATE_GENDER(HttpStatus.OK, "305", "Giới Tính Không Hợp Lệ!"),
    VALIDATE_CPA(HttpStatus.OK, "305", "CPA Không Hợp lệ !"),
    VALIDATE_SALARY(HttpStatus.OK, "305", "Lương nhập chưa chính xác!"),
    FAIL(HttpStatus.OK, "303", "Đối tượng truyền vào không hợp lệ"),
    UNKNOWN_ERROR(HttpStatus.OK, "500", "Internal Server Error"),
    TEACHER_NOT_FOUND(HttpStatus.OK, "301", "Không tồn tại giáo viên có mã ID này!"),
    STUDENT_NOT_FOUND(HttpStatus.OK, "301", "Không tồn tại học sinh có mã ID này!");


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
