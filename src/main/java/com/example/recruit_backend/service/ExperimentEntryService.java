package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.ExperimentEntry;

import java.util.Date;
import java.util.List;


public interface ExperimentEntryService {

    int insertExperimentEntry(int user_id, String name, String role, Date start_time, Date end_time, String description);

    int updateExperimentEntry(int id, int user_id, String name, String role, Date start_time, Date end_time, String description);

    int deleteExperimentEntry(int id, int user_id);

    List<ExperimentEntry> getExperimentEntryList(int user_id);

}
