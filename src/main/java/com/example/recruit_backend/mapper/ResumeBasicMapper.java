package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.Position;
import com.example.recruit_backend.entity.ResumeBasic;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Mapper
public interface ResumeBasicMapper {

    @Insert("INSERT INTO resume_basic(user_id, name, phone, email, self_evaluate, update_time) " +
            "VALUES (#{user_id}, #{name}, #{phone}, #{email}, #{self_evaluate}, #{update_time});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertResumeBasic(ResumeBasic resumeBasic);


    @Update("UPDATE resume_basic SET name = #{name}, " +
            "phone = #{phone}, email = #{email}, " +
            "self_evaluate = #{self_evaluate} " +
            "WHERE user_id = #{user_id}")
    int updateResumeBasic(@Param("user_id") int user_id,
                          @Param("name") String name,
                          @Param("phone") String phone,
                          @Param("email") String email,
                          @Param("self_evaluate") String self_evaluate);


    @Update("UPDATE resume_basic SET update_time = #{update_time}" +
            "WHERE user_id = #{user_id}")
    int updateResumeUpdateTime(@Param("user_id") int user_id,
                               @Param("update_time") Date update_time);

    @Delete("DELETE FROM resume_basic WHERE user_id = #{user_id}")
    int deleteResumeBasic(@Param("user_id") int user_id);


    @ResultType(ResumeBasic.class)
    @Select("SELECT * FROM resume_basic WHERE user_id = #{user_id};")
    ResumeBasic getResumeBasicByUserId(int user_id);



}

