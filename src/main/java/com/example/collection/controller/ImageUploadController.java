package com.example.collection.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageUploadController {
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Đường dẫn đến thư mục lưu trữ tệp ảnh trên máy chủ
                String uploadDir = "C:\\Users\\Administrator\\Pictures\\image_test\\";
                String fileName = file.getOriginalFilename();
                File targetFile = new File(uploadDir + fileName);

                // Lưu tệp ảnh vào thư mục trên máy chủ
                file.transferTo(targetFile);

                // Trả về thông báo thành công
                return "File uploaded successfully.";
            } catch (IOException e) {
                e.printStackTrace();
                return "File upload failed.";
            }
        } else {
            return "File is empty.";
        }
    }
}
