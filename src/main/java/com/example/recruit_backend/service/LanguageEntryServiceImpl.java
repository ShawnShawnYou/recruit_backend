package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.LanguageEntry;
import com.example.recruit_backend.mapper.LanguageEntryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LanguageEntryServiceImpl implements LanguageEntryService {

    @Autowired
    LanguageEntryMapper languageEntryMapper;

    @Autowired
    ResumeBasicService resumeBasicService;

    @Override
    public int insertLanguageEntry(int user_id, String language, String level) {
        LanguageEntry languageEntry = new LanguageEntry(0, user_id, language, level);
        languageEntryMapper.insertLanguageEntry(languageEntry);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }

    @Override
    public int updateLanguageEntry(int id, int user_id, String language, String level) {
        languageEntryMapper.updateLanguageEntry(id, user_id, language, level);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }

    @Override
    public int deleteLanguageEntry(int id, int user_id) {
        languageEntryMapper.deleteLanguageEntry(id, user_id);
        return resumeBasicService.updateResumeUpdateTime(user_id);
    }

    @Override
    public List<LanguageEntry> getLanguageEntryList(int user_id) {
        return languageEntryMapper.getLanguageEntryList(user_id);
    }

}

