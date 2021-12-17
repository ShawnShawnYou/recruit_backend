package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.LanguageEntry;
import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.service.LanguageEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class LanguageEntryController {

    @Autowired
    LanguageEntryService languageEntryService;


    @PostMapping("/insertLanguageEntry")
    // ok
    public Result insertLanguageEntry(@RequestParam("user_id") int user_id,
                                       @RequestParam("major") String language,
                                       @RequestParam("level") String level) {
        try {
            languageEntryService.insertLanguageEntry(user_id, language, level);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }


    @PostMapping("/updateLanguageEntry")
    // ok
    public Result updateLanguageEntry(@RequestParam("id") int id,
                                      @RequestParam("user_id") int user_id,
                                      @RequestParam("major") String language,
                                      @RequestParam("level") String level) {
        try {
            languageEntryService.updateLanguageEntry(id, user_id, language, level);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/deleteLanguageEntry")
    // ok
    public Result deleteLanguageEntry(@RequestParam("id") int id,
                                       @RequestParam("user_id") int user_id) {
        try {
            languageEntryService.deleteLanguageEntry(id, user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getLanguageEntryList")
    // ok
    public Result getLanguageEntryList(@RequestParam("user_id") int user_id) {
        List<LanguageEntry> languageEntryList;
        try {
            languageEntryList = languageEntryService.getLanguageEntryList(user_id);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        if (languageEntryList != null)
            return Result.success(languageEntryList);
        else
            return Result.fail("don't exist");
    }

}
