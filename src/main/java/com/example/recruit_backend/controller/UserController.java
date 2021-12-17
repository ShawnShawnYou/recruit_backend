package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.entity.User;
import com.example.recruit_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/updateUser")
    // ok
    public Result updateUser(@RequestParam("phone") String phone,
                             @RequestParam("password") String password) {
        try {
            userService.updatePassword(phone, password);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/deleteUser")
    // ok
    public Result deleteUser(@RequestParam("phone") String phone) {
        try {
            userService.deleteUser(phone);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getUserByPhone")
    // ok
    public Result getUserByPhone(@RequestParam("phone") String phone) {
        User user;
        try {
            user = userService.getUserByPhone(phone);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        if (user != null)
            return Result.success(user);
        else
            return Result.fail("user don't exist");
    }

    @GetMapping("/getUserList")
    // ok
    public Result getUserList() {
        List<User> userList;
        try {
            userList = userService.getUserListByType(0);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }

        return Result.success(userList);
    }


}
