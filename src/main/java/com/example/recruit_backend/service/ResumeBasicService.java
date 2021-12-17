package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.Position;
import com.example.recruit_backend.entity.ResumeBasic;

import java.util.List;

public interface ResumeBasicService {

    int insertResumeBasic(int user_id, String name, String phone, String email,
                          String self_evaluate);

    int updateResumeBasic(int user_id, String name, String phone, String email,
                          String self_evaluate);

    int deleteResumeBasic(int user_id);

    ResumeBasic getResumeBasicByUserId(int user_id);

    int updateResumeUpdateTime(int user_id);
}
