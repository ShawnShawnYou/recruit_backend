package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.ResumeSubmitStatus;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


public interface EducationEntryService {

    int insertEducationEntry(int user_id, String school, String major, Date start_time, Date end_time, String level);

    int updateEducationEntry(int id, int user_id, String school, String major, Date start_time, Date end_time, String level);

    int deleteEducationEntry(int id, int user_id);

    List<EducationEntry> getEducationEntryList(int user_id);

}
