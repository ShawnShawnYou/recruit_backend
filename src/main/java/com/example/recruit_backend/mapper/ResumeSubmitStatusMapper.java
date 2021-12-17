package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.ResumeSubmitStatus;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface ResumeSubmitStatusMapper {

    @Insert("INSERT INTO resume_submit_status(user_id, id_position, status, update_time) " +
            "VALUES (#{user_id}, #{id_position}, #{status}, #{update_time});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertResumeSubmitStatus(ResumeSubmitStatus resumeSubmitStatus);


    @Update("UPDATE resume_submit_status SET id_position = #{id_position}, " +
            "status = #{status}, update_time = #{update_time}" +
            "WHERE user_id = #{user_id}")
    int updateResumeSubmitStatus(@Param("user_id") int user_id,
                                 @Param("id_position") int id_position,
                                 @Param("status") int status,
                                 @Param("update_time") Date update_time);


    @Delete("DELETE FROM resume_submit_status WHERE user_id = #{user_id} and id = #{id}")
    int deleteResumeSubmitStatus(@Param("id") int id,
                                 @Param("user_id") int user_id);


    @ResultType(ResumeSubmitStatus.class)
    @Select("SELECT * FROM resume_submit_status WHERE user_id = #{user_id};")
    ResumeSubmitStatus getResumeSubmitStatus(int user_id);



}

