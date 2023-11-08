package com.gogo.admin.ProductImg.controller;

import com.gogo.admin.ProductImg.service.S3ImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/img")
@RequiredArgsConstructor
public class ImgController {

    private final S3ImgService s3ImgService;

    @PostMapping("/upload/{productId}")
    public String uploadImg(@RequestParam("file") MultipartFile file,
                            @PathVariable(name = "productId") Long productId) throws IOException {
        return s3ImgService.saveFile(file,productId);
    }
}
