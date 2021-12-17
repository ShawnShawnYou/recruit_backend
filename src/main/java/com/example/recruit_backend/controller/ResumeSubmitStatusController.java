package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.entity.ResumeSubmitStatus;
import com.example.recruit_backend.service.ResumeSubmitStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResumeSubmitStatusController {

    @Autowired
    ResumeSubmitStatusService resumeSubmitStatusService;


    @PostMapping("/insertResumeSubmitStatus")
    // ok
    public Result insertResumeSubmitStatus(@RequestParam("user_id") int user_id,
                                           @RequestParam("id_position") int id_position) {
        try {
            resumeSubmitStatusService.insertResumeSubmitStatus(user_id, id_position);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }


    @PostMapping("/updateResumeSubmitStatus")
    // ok
    public Result updateResumeSubmitStatus(@RequestParam("user_id") int user_id,
                                           @RequestParam("id_position") int id_position,
                                           @RequestParam("status") int status) {
        try {
            resumeSubmitStatusService.updateResumeSubmitStatus(user_id, id_position, status);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/deleteResumeSubmitStatus")
    // ok
    public Result deleteResumeSubmitStatus(@RequestParam("id") int id,
                                           @RequestParam("user_id") int user_id) {
        try {
            resumeSubmitStatusService.deleteResumeSubmitStatus(id, user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getResumeSubmitStatus")
    // ok
    public Result getResumeSubmitStatus(@RequestParam("user_id") int user_id) {
        ResumeSubmitStatus resumeSubmitStatus;
        try {
            resumeSubmitStatus = resumeSubmitStatusService.getResumeSubmitStatus(user_id);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        if (resumeSubmitStatus != null)
            return Result.success(resumeSubmitStatus);
        else
            return Result.fail("don't exist");
    }

}
