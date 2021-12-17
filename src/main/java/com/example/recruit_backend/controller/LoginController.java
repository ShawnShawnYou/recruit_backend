package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.entity.User;
import com.example.recruit_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    // ok
    public Result login(@RequestParam("phone")  String phone,
                        @RequestParam("password") String password,
                        HttpSession session){
        if(phone.length() != 11
                || password.length() < 2 || password.length() > 20)
            return Result.fail("invalid phone");

        User user = userService.getUserByPhone(phone);
        if (user == null)
            return Result.fail("unregistered phone");
        if (!user.getPassword().equals(password))
            return Result.fail("unmatched password");

        //请求转发，会话管理
        try{
            session.setAttribute(String.valueOf(user.getId()), user);
        } catch (RuntimeException e){
            return Result.fail("session exception");
        }
        return Result.success(user.getType());
    }


    @GetMapping("/logout")
    // ok
    public Result logout(HttpSession session){
        //注销session（在服务器里删除该session）
        session.invalidate();
        return Result.success(null);
    }

    @PostMapping("/register")
    // ok
    public Result Register(@RequestParam("phone")  String phone,
                           @RequestParam("password") String password,
                           @RequestParam("type") int type) {
        if (phone.isEmpty())
            return Result.fail("invalid phone");
        if (password.isEmpty())
            return Result.fail("invalid password");
        if (userService.getUserByPhone(phone) != null)
            return Result.fail("the phone has been registered");

        try {
            userService.insertUser(phone, password, type);
        } catch (Exception e) {
            return Result.fail("ORM error");
        }

        return Result.success(null);
    }


}