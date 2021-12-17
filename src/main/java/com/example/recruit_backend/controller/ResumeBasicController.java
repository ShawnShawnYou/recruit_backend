package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.Position;
import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.entity.ResumeBasic;
import com.example.recruit_backend.service.PositionService;
import com.example.recruit_backend.service.ResumeBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
public class ResumeBasicController {

    @Autowired
    ResumeBasicService resumeBasicService;


    @PostMapping("/insertResumeBasic")
    // ok
    public Result insertResumeBasic(@RequestParam("user_id") int user_id,
                                    @RequestParam("name") String name,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("email") String email,
                                    @RequestParam("self_evaluate") String self_evaluate) {
        try {
            resumeBasicService.insertResumeBasic(
                    user_id, name, phone, email, self_evaluate);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }


    @PostMapping("/updateResumeBasic")
    // ok
    public Result updateResumeBasic(@RequestParam("user_id") int user_id,
                                    @RequestParam("name") String name,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("email") String email,
                                    @RequestParam("self_evaluate") String self_evaluate) {
        try {
            resumeBasicService.updateResumeBasic(user_id, name, phone, email, self_evaluate);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/deleteResumeBasic")
    // ok
    public Result deleteResumeBasic(@RequestParam("user_id") int user_id) {
        try {
            resumeBasicService.deleteResumeBasic(user_id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getResumeBasicByUserId")
    // ok
    public Result getResumeBasicByUserId(@RequestParam("user_id") int user_id) {
        ResumeBasic resumeBasic;
        try {
            resumeBasic = resumeBasicService.getResumeBasicByUserId(user_id);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        if (resumeBasic != null)
            return Result.success(resumeBasic);
        else
            return Result.fail("factory don't exist");
    }

}
