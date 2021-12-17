package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.Position;
import com.example.recruit_backend.entity.ResumeBasic;
import com.example.recruit_backend.mapper.PositionMapper;
import com.example.recruit_backend.mapper.ResumeBasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResumeBasicServiceImpl implements ResumeBasicService {

    @Autowired
    ResumeBasicMapper resumeBasicMapper;

    @Override
    public int insertResumeBasic(int user_id, String name, String phone, String email,
                                 String self_evaluate) {
        ResumeBasic resumeBasic = new ResumeBasic();
        resumeBasic.setUser_id(user_id);
        resumeBasic.setName(name);
        resumeBasic.setPhone(phone);
        resumeBasic.setEmail(email);
        resumeBasic.setSelf_evaluate(self_evaluate);
        resumeBasic.setUpdate_time(new Date());
        return resumeBasicMapper.insertResumeBasic(resumeBasic);
    }

    @Override
    public int updateResumeBasic(int user_id, String name, String phone, String email,
                                 String self_evaluate) {
        resumeBasicMapper.updateResumeBasic(user_id, name, phone, email, self_evaluate);
        return updateResumeUpdateTime(user_id);
    }

    @Override
    public int deleteResumeBasic(int user_id) {
        return resumeBasicMapper.deleteResumeBasic(user_id);
    }

    @Override
    public ResumeBasic getResumeBasicByUserId(int user_id) {
        return resumeBasicMapper.getResumeBasicByUserId(user_id);
    }

    @Override
    public int updateResumeUpdateTime(int user_id) {
        return resumeBasicMapper.updateResumeUpdateTime(user_id, new Date());
    }

}

