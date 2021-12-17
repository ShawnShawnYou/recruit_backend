package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.mapper.EducationEntryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EducationEntryServiceImpl implements EducationEntryService {

    @Autowired
    EducationEntryMapper educationEntryMapper;

    @Autowired
    ResumeBasicService resumeBasicService;

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int insertEducationEntry(int user_id, String school, String major,
                                    Date start_time, Date end_time, String level) {
        EducationEntry educationEntry = new EducationEntry(0, user_id, school, major, start_time, end_time, level);
        educationEntryMapper.insertEducationEntry(educationEntry);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }


    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int updateEducationEntry(int id, int user_id, String school, String major,
                                    Date start_time, Date end_time, String level) {
        educationEntryMapper.updateEducationEntry(id, user_id, school, major, start_time, end_time, level);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }


    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int deleteEducationEntry(int id, int user_id) {
        educationEntryMapper.deleteEducationEntry(id, user_id);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public List<EducationEntry> getEducationEntryList(int user_id) {
        return educationEntryMapper.getEducationEntryList(user_id);
    }

}

