package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.EducationEntry;
import com.example.recruit_backend.entity.ResumeBasic;
import com.example.recruit_backend.entity.ResumeFile;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface ResumeFileMapper {

    @Insert("INSERT INTO resume_file(user_id, location, name, old_name, description, create_time, update_time) " +
            "VALUES (#{user_id}, #{location}, #{name}, #{old_name}, #{description}, #{create_time}, #{update_time});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertResumeFile(ResumeFile resumeFile);

    @Delete("DELETE FROM resume_file WHERE id = #{id};")
    int deleteResumeFileById(@Param("id") int id);

    @ResultType(ResumeFile.class)
    @Select("SELECT * FROM resume_file WHERE old_name = #{old_name} LIMIT 1;")
    ResumeFile getResumeFileByOldName(String old_name);

    @ResultType(ResumeFile.class)
    @Select("SELECT * FROM resume_file WHERE name = #{name} LIMIT 1;")
    ResumeFile getResumeFileByName(String name);

    @ResultType(ResumeFile.class)
    @Select("SELECT * FROM resume_file WHERE user_id = #{user_id} LIMIT 1;")
    ResumeFile getResumeFileByUserId(int user_id);

}

