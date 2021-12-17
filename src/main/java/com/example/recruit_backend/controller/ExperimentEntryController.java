package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.ExperimentEntry;
import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.service.EducationEntryService;
import com.example.recruit_backend.service.ExperimentEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ExperimentEntryController {

    @Autowired
    ExperimentEntryService experimentEntryService;


    @PostMapping("/insertExperimentEntry")
    // ok
    public Result insertExperimentEntry(@RequestParam("user_id") int user_id,
                                       @RequestParam("name") String name,
                                       @RequestParam("role") String role,
                                       @RequestParam("start_time") String start_timestamp,
                                       @RequestParam("end_time") String end_timestamp,
                                       @RequestParam("description") String description) {
        try {
            Date start_time = new Date(Long.parseLong(start_timestamp));
            Date end_time = new Date(Long.parseLong(end_timestamp));

            experimentEntryService.insertExperimentEntry(user_id, name, role, start_time, end_time, description);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }


    @PostMapping("/updateExperimentEntry")
    // ok
    public Result updateExperimentEntry(@RequestParam("id") int id,
                                        @RequestParam("user_id") int user_id,
                                        @RequestParam("name") String name,
                                        @RequestParam("role") String role,
                                        @RequestParam("start_time") String start_timestamp,
                                        @RequestParam("end_time") String end_timestamp,
                                        @RequestParam("description") String description) {
        try {
            Date start_time = new Date(Long.parseLong(start_timestamp));
            Date end_time = new Date(Long.parseLong(end_timestamp));

            experimentEntryService.updateExperimentEntry(id, user_id, name, role, start_time, end_time, description);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/deleteExperimentEntry")
    // ok
    public Result deleteExperimentEntry(@RequestParam("id") int id,
                                       @RequestParam("user_id") int user_id) {
        try {
            experimentEntryService.deleteExperimentEntry(id, user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getExperimentEntryList")
    // ok
    public Result getExperimentEntryList(@RequestParam("user_id") int user_id) {
        List<ExperimentEntry> experimentEntryList;
        try {
            experimentEntryList = experimentEntryService.getExperimentEntryList(user_id);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        if (experimentEntryList != null)
            return Result.success(experimentEntryList);
        else
            return Result.fail("don't exist");
    }

}
