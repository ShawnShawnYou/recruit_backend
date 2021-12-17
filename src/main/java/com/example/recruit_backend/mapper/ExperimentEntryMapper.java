package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.ExperimentEntry;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExperimentEntryMapper {

    @Insert("INSERT INTO experiment_entry(user_id, name, role, start_time, end_time, description) " +
            "VALUES (#{user_id}, #{name}, #{role}, #{start_time}, #{end_time}, #{description});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertExperimentEntry(ExperimentEntry experimentEntry);


    @Update("UPDATE experiment_entry SET name = #{name}, " +
            "role = #{role}, start_time = #{start_time}, " +
            "end_time = #{end_time}, description = #{description}" +
            "WHERE user_id = #{user_id} AND id = #{id}")
    int updateExperimentEntry(int id, int user_id, String name, String role, Date start_time, Date end_time, String description);


    @Delete("DELETE FROM experiment_entry WHERE user_id = #{user_id} and id = #{id}")
    int deleteExperimentEntry(@Param("id") int id,
                             @Param("user_id") int user_id);


    @Results(
            id = "educationEntryList",value = {
            @Result(property="id", column="id"),
            @Result(property="user_id", column="user_id"),
            @Result(property="name", column="name"),
            @Result(property="role", column="role"),
            @Result(property="start_time", column="start_time"),
            @Result(property="end_time", column="end_time"),
            @Result(property="description", column="description")
    })
    @Select("SELECT * FROM experiment_entry WHERE user_id = #{user_id};")
    List<ExperimentEntry> getExperimentEntryList(int user_id);



}

