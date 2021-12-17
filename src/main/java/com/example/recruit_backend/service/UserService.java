package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    int insertUser(String phone, String password, int type);

    User getUserByPhone(String phone);

    User getUserById(int id_user);

    List<User> getUserListByType(int type);

    int updatePassword(String phone, String password);

    int deleteUser(String phone);
}
