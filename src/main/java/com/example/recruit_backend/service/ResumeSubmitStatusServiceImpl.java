package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.ResumeSubmitStatus;
import com.example.recruit_backend.mapper.ResumeSubmitStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResumeSubmitStatusServiceImpl implements ResumeSubmitStatusService {

    @Autowired
    ResumeSubmitStatusMapper resumeSubmitStatusMapper;

    @Autowired
    ResumeBasicService resumeBasicService;

    @Override
    public int insertResumeSubmitStatus(int user_id, int id_position) {
        ResumeSubmitStatus resumeSubmitStatus = new ResumeSubmitStatus();
        resumeSubmitStatus.setUser_id(user_id);
        resumeSubmitStatus.setId_position(id_position);
        resumeSubmitStatus.setStatus(0);
        resumeSubmitStatus.setUpdate_time(new Date());
        return resumeSubmitStatusMapper.insertResumeSubmitStatus(resumeSubmitStatus);
    }

    @Override
    public int updateResumeSubmitStatus(int user_id, int id_position, int status) {
        return resumeSubmitStatusMapper.updateResumeSubmitStatus(user_id, id_position, status, new Date());
    }

    @Override
    public int deleteResumeSubmitStatus(int id, int user_id) {
        return resumeSubmitStatusMapper.deleteResumeSubmitStatus(id, user_id);
    }

    @Override
    public ResumeSubmitStatus getResumeSubmitStatus(int user_id) {
        return resumeSubmitStatusMapper.getResumeSubmitStatus(user_id);
    }

}

