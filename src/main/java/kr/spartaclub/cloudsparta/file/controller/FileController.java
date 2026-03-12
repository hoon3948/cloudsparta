package kr.spartaclub.cloudsparta.file.controller;

import kr.spartaclub.cloudsparta.file.dto.FileDownloadUrlResponse;
import kr.spartaclub.cloudsparta.file.dto.FileUploadResponse;
import kr.spartaclub.cloudsparta.file.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final S3Service s3Service;

    // 사진 업로드
    @PostMapping("/api/members/{id}/upload")
    public ResponseEntity<FileUploadResponse> upload(@RequestParam("file") MultipartFile file) {
        String key = s3Service.upload(file);
        return ResponseEntity.ok(new FileUploadResponse(key));
    }

    // 사진 다운로드
    @GetMapping("/api/members/{id}/download-url")
    public ResponseEntity<FileDownloadUrlResponse> getDownloadUrl(@RequestParam String key) {
        URL url = s3Service.getDownloadUrl(key);
        return ResponseEntity.ok(new FileDownloadUrlResponse(url.toString()));
    }
}