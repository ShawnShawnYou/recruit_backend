package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.ResumeBasic;
import com.example.recruit_backend.entity.ResumeFile;
import com.example.recruit_backend.mapper.ResumeBasicMapper;
import com.example.recruit_backend.mapper.ResumeFileMapper;
import com.example.recruit_backend.util.FileUploadUtils;
import com.example.recruit_backend.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

@Service
public class ResumeFileServiceImpl implements ResumeFileService {

    @Autowired
    ResumeFileMapper resumeFileMapper;

    @Override
    public void upload(MultipartFile file, String baseDir, int user_id) throws Exception {
        //就算什么也不传，controller层的file也不为空，但是originalFilename会为空（亲测）
        String originalFilename = file.getOriginalFilename();

        if(originalFilename == null || "".equals(originalFilename)) {
            throw new Exception( "上传文件不能为空");
        }
        //检测是否上传过同样的文件，如果有的话就删除。（这边可根据个人的情况修改逻辑）
//        QueryWrapper<ResumeFile> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("old_name", originalFilename);
//        ResumeFile oldEntity = resumeFileMapper.getResumeFileByOldName(originalFilename);

        ResumeFile old_file = resumeFileMapper.getResumeFileByUserId(user_id);
        if(old_file != null) {
            //确保新的文件保存成功后，删除原有的同名文件(实体文件 and 数据库文件)
            FileUtils.deleteFile(old_file.getLocation());
            resumeFileMapper.deleteResumeFileById(old_file.getId());
        }

        //新的文件
        ResumeFile resumeFile = new ResumeFile();
        resumeFile.setUser_id(user_id);
        resumeFile.setCreate_time(new Date());
        resumeFile.setUpdate_time(new Date());
        resumeFile.setOld_name(file.getOriginalFilename());        //这边可以根据业务修改，项目中不要写死
        String fileLocation = null ;
        if(baseDir != null) {
            fileLocation = FileUploadUtils.upload(baseDir, file);
        }else {
            fileLocation = FileUploadUtils.upload(file);
        }
        resumeFile.setLocation(fileLocation);
        String[] path = fileLocation.split("\\\\");
        resumeFile.setName(path[path.length - 1]);
        resumeFileMapper.insertResumeFile(resumeFile);


    }

    @Override
    public void download(HttpServletResponse response, int user_id) throws IOException {
//        QueryWrapper<ResumeFile> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name", newName);
//        ResumeFile resumeFile = resumeFileMapper.getResumeFileByName(newName);
        ResumeFile resumeFile = resumeFileMapper.getResumeFileByUserId(user_id);

        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");        //这边可以设置文件下载时的名字，我这边用的是文件原本的名字，可以根据实际场景设置
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(resumeFile.getOld_name(), "UTF-8"));
        FileUtils.writeBytes(resumeFile.getLocation(), response.getOutputStream());
    }

    @Override
    public ResumeFile getResumeFileByUserId(int user_id) {
        return resumeFileMapper.getResumeFileByUserId(user_id);
    }
}

