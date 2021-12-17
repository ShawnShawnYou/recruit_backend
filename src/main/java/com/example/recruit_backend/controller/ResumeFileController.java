package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.entity.ResumeBasic;
import com.example.recruit_backend.entity.ResumeFile;
import com.example.recruit_backend.service.ResumeBasicService;
import com.example.recruit_backend.service.ResumeFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
public class ResumeFileController {

    @Autowired
    ResumeFileService resumeFileService;

    //使用默认路径
    @PostMapping("/upload/defaultPath")
    // ok
    public Result upload(MultipartFile file, int user_id){
        try {
            resumeFileService.upload(file, null, user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    //自定义路径
    @PostMapping("/upload/usingPath")
    // ok
    public Result uploadPlace(MultipartFile file, String dir_path, int user_id){
        // path: "H:\\upload"
        try {
            resumeFileService.upload(file, dir_path, user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    //下载
    @GetMapping("/download/file")
    // ok
    public Result downloadFileByUserId(HttpServletResponse response, int user_id){
        try {
            resumeFileService.download(response, user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    // 获取文件预览信息
    @GetMapping("/get/fileInfo")
    // ok
    public Result getFileInfo(int user_id){
        try {
            ResumeFile resumeFile = resumeFileService.getResumeFileByUserId(user_id);
            return Result.success(resumeFile);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }




}
