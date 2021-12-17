package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.ResumeBasic;
import com.example.recruit_backend.entity.ResumeFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ResumeFileService {

    void upload(MultipartFile file, String baseDir, int user_id) throws Exception;

    void download(HttpServletResponse response, int user_id) throws IOException;

    ResumeFile getResumeFileByUserId(int user_id);

}
