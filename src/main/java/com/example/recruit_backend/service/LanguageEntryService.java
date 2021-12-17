package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.LanguageEntry;

import java.util.List;


public interface LanguageEntryService {

    int insertLanguageEntry(int user_id, String language, String level);

    int updateLanguageEntry(int id, int user_id, String language, String level);

    int deleteLanguageEntry(int id, int user_id);

    List<LanguageEntry> getLanguageEntryList(int user_id);

}
