package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.ResumeSubmitStatus;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface EducationEntryMapper {

    @Insert("INSERT INTO education_entry(user_id, school, major, start_time, end_time, level) " +
            "VALUES (#{user_id}, #{school}, #{major}, #{start_time}, #{end_time}, #{level});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertEducationEntry(EducationEntry educationEntry);


    @Update("UPDATE education_entry SET school = #{school}, " +
            "major = #{major}, start_time = #{start_time}, " +
            "end_time = #{end_time}, level = #{level}" +
            "WHERE user_id = #{user_id} AND id = #{id}")
    int updateEducationEntry(int id, int user_id, String school, String major, Date start_time, Date end_time, String level);


    @Delete("DELETE FROM education_entry WHERE user_id = #{user_id} and id = #{id}")
    int deleteEducationEntry(@Param("id") int id,
                             @Param("user_id") int user_id);


    @Results(
            id = "educationEntryList",value = {
            @Result(property="id", column="id"),
            @Result(property="user_id", column="user_id"),
            @Result(property="school", column="school"),
            @Result(property="major", column="major"),
            @Result(property="start_time", column="start_time"),
            @Result(property="end_time", column="end_time"),
            @Result(property="level", column="level")
    })
    @Select("SELECT * FROM education_entry WHERE user_id = #{user_id};")
    List<EducationEntry> getEducationEntryList(int user_id);



}

