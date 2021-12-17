package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // 注册
    @Insert("INSERT INTO user(phone, password, type) " +
            "VALUES (#{phone}, #{password}, #{type});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);


    @Select("SELECT id FROM user WHERE phone=#{phone};")
    int getIdUserByPhone(@Param("phone") String phone);


    @ResultType(User.class)
    @Select("SELECT * FROM user WHERE id=#{id};")
    User getUserById(@Param("id") int id);


    @ResultType(User.class)
    @Select("SELECT * FROM user WHERE phone=#{phone};")
    User getUserByPhone(@Param("phone") String phone);


    //如果已经定义过@Results，可以直接用@ResultMap来调取
    @Results(
            id = "userList",value = {
            @Result(property="id", column="id"),
            @Result(property="phone", column="phone"),
            @Result(property="password", column="password"),
            @Result(property="type", column="type")
    })
    @Select("SELECT * FROM user WHERE type = #{type};")
    List<User> getUserListByType(@Param("type") int type);


    @Update("UPDATE user SET password = #{password} WHERE phone = #{phone}")
    int updatePassword(@Param("phone") String phone,
                       @Param("password") String password);


    @Delete("DELETE FROM user WHERE phone = #{phone}")
    int deleteUser(@Param("phone") String phone);
}

