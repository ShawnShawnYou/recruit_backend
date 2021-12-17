package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.ResumeSubmitStatus;


public interface ResumeSubmitStatusService {

    int insertResumeSubmitStatus(int user_id, int id_position);

    int updateResumeSubmitStatus(int user_id, int id_position, int status);

    int deleteResumeSubmitStatus(int id, int user_id);

    ResumeSubmitStatus getResumeSubmitStatus(int user_id);

}
