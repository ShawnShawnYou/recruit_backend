package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.ExperimentEntry;
import com.example.recruit_backend.mapper.EducationEntryMapper;
import com.example.recruit_backend.mapper.ExperimentEntryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExperimentEntryServiceImpl implements ExperimentEntryService {

    @Autowired
    ExperimentEntryMapper experimentEntryMapper;

    @Autowired
    ResumeBasicService resumeBasicService;

    @Override
    public int insertExperimentEntry(int user_id, String name, String role,
                                     Date start_time, Date end_time, String description) {
        ExperimentEntry experimentEntry = new ExperimentEntry(0, user_id, name, role, start_time, end_time, description);
        experimentEntryMapper.insertExperimentEntry(experimentEntry);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }

    @Override
    public int updateExperimentEntry(int id, int user_id, String name, String role,
                                     Date start_time, Date end_time, String description) {
        experimentEntryMapper.updateExperimentEntry(id, user_id, name, role, start_time, end_time, description);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }

    @Override
    public int deleteExperimentEntry(int id, int user_id) {
        experimentEntryMapper.deleteExperimentEntry(id, user_id);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }

    @Override
    public List<ExperimentEntry> getExperimentEntryList(int user_id) {
        return experimentEntryMapper.getExperimentEntryList(user_id);
    }

}

