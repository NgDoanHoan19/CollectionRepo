package com.example.collection.dto.request;

import lombok.Data;

@Data
public class GetAllStudentRequest {
    private String name;
    private Integer pageNum;
    private Integer pageSize;
    private String sortField;
    private String sortDirection;
}
