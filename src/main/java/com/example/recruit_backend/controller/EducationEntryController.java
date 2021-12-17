package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.service.EducationEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EducationEntryController {

    @Autowired
    EducationEntryService educationEntryService;


    @PostMapping("/insertEducationEntry")
    // ok
    public Result insertEducationEntry(@RequestParam("user_id") int user_id,
                                       @RequestParam("school") String school,
                                       @RequestParam("major") String major,
                                       @RequestParam("start_time") String start_timestamp,
                                       @RequestParam("end_time") String end_timestamp,
                                       @RequestParam("level") String level) {
        try {
            Date start_time = new Date(Long.parseLong(start_timestamp));
            Date end_time = new Date(Long.parseLong(end_timestamp));

            educationEntryService.insertEducationEntry(user_id, school, major, start_time, end_time, level);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }


    @PostMapping("/updateEducationEntry")
    // ok
    public Result updateEducationEntry(@RequestParam("id") int id,
                                       @RequestParam("user_id") int user_id,
                                       @RequestParam("school") String school,
                                       @RequestParam("major") String major,
                                       @RequestParam("start_time") String start_timestamp,
                                       @RequestParam("end_time") String end_timestamp,
                                       @RequestParam("level") String level) {
        try {
            Date start_time = new Date(Long.parseLong(start_timestamp));
            Date end_time = new Date(Long.parseLong(end_timestamp));

            educationEntryService.updateEducationEntry(id, user_id, school, major, start_time, end_time, level);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/deleteEducationEntry")
    // ok
    public Result deleteEducationEntry(@RequestParam("id") int id,
                                       @RequestParam("user_id") int user_id) {
        try {
            educationEntryService.deleteEducationEntry(id, user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getEducationEntryList")
    // ok
    public Result getEducationEntryList(@RequestParam("user_id") int user_id) {
        List<EducationEntry> educationEntryList;
        try {
            educationEntryList = educationEntryService.getEducationEntryList(user_id);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        if (educationEntryList != null)
            return Result.success(educationEntryList);
        else
            return Result.fail("don't exist");
    }

}
