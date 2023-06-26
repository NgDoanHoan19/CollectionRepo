package com.example.collection.utils;

import com.example.collection.dto.request.StudentCreateRequest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.collection.constain.Constants.STATUS_FAIL;

public class ExcelUtil {
    public static List<StudentCreateRequest> excelStudent(InputStream inputStream) {
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<StudentCreateRequest> studentCreateRequests = new ArrayList<>();
            DataFormatter dataFormatter = new DataFormatter();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellRows = currentRow.iterator();
                StudentCreateRequest studentCreateRequest = new StudentCreateRequest();
                int cellIndex = 0;
                while (cellRows.hasNext()) {
                    Cell currentCell = cellRows.next();
                    switch (cellIndex) {
                        case 0:
                            studentCreateRequest.setStudentName(dataFormatter.formatCellValue(currentCell));
                            break;
                        case 1:
                            studentCreateRequest.setGender(dataFormatter.formatCellValue(currentCell));
                            break;
                        case 2:
                            studentCreateRequest.setAge(Integer.parseInt(dataFormatter.formatCellValue(currentCell)));
                            break;
                        case 3:
                            studentCreateRequest.setStudentEmail(dataFormatter.formatCellValue(currentCell));
                            break;
                        case 4:
                            studentCreateRequest.setStudentAddress(dataFormatter.formatCellValue(currentCell));
                            break;
                        case 5:
                            studentCreateRequest.setCpa(currentCell.getNumericCellValue());
                            break;
                        case 6:
                            studentCreateRequest.setClassStudent(dataFormatter.formatCellValue(currentCell));
                            break;
                        case 7:
                            studentCreateRequest.setUserName(dataFormatter.formatCellValue(currentCell));
                            break;
                        case 8:
                            studentCreateRequest.setPassword(dataFormatter.formatCellValue(currentCell));
                            break;
                        default:
                            break;
                    }
                    cellIndex++;
                }
                studentCreateRequests.add(studentCreateRequest);
            }
            workbook.close();
            return studentCreateRequests;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(STATUS_FAIL + e.getMessage());
        }
    }
}
