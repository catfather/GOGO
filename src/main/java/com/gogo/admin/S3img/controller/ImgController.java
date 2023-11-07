package com.gogo.admin.S3img.controller;

import com.gogo.admin.S3img.service.S3ImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/img")
@RequiredArgsConstructor
public class ImgController {

    private final S3ImgService s3ImgService;

    @PostMapping("/upload")
    public String uploadImg(@RequestParam("file") MultipartFile file) throws IOException {
        return s3ImgService.saveFile(file);
    }
}
