package com.gogo.admin.S3img.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.gogo.admin.S3img.repository.ImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

//AWS S3 업로드 서비스
@Service
@RequiredArgsConstructor
public class S3ImgService {

    private final ImgRepository imgRepository;

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    //파일 업로드
    public String saveFile(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename(); //파일 이름

        ObjectMetadata metadata = new ObjectMetadata(); //메타데이터 설정
        metadata.setContentLength(multipartFile.getSize()); //파일 사이즈
        metadata.setContentType(multipartFile.getContentType()); //파일 타입


        amazonS3.putObject(bucket, originalFilename, multipartFile.getInputStream(), metadata); //파일 업로드

        String S3ImgURL = amazonS3.getUrl(bucket, originalFilename).toString(); //파일 URL 리턴


        return
    }

    //파일 다운로드
    public ResponseEntity<UrlResource> downloadImage(String originalFilename) throws MalformedURLException {
        UrlResource resource = new UrlResource(amazonS3.getUrl(bucket, originalFilename).toString());
        String contentDisposition = "attachment; filename=\"" + originalFilename + "\""; //파일 이름 설정
        return ResponseEntity.ok()
                //헤더에 contentDisposition 설정 클릭시 다운
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }
}
