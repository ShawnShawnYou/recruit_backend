package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.User;
import com.example.recruit_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ResumeBasicService resumeBasicService;

    @Autowired
    ResumeFileService resumeFileService;

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int insertUser(String phone, String password, int type) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);

        userMapper.insertUser(user);
        int user_id = getUserByPhone(phone).getId();
        resumeBasicService.insertResumeBasic(user_id, "", "", "", "");
//        resumeFileService.insertResumeFile(user_id, null);

        return 1;
    }

    @Override
    public User getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserListByType(int type) {
        return userMapper.getUserListByType(type);
    }

    @Override
    public int updatePassword(String phone, String password) {
        return userMapper.updatePassword(phone, password);
    }


    @Override
    public int deleteUser(String phone) {
        return userMapper.deleteUser(phone);
    }
}
