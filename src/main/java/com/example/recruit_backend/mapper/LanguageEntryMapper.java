package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.LanguageEntry;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LanguageEntryMapper {

    @Insert("INSERT INTO language_entry(user_id, language, level) " +
            "VALUES (#{user_id}, #{language}, #{level});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLanguageEntry(LanguageEntry languageEntry);


    @Update("UPDATE language_entry SET language = #{language}, " +
            "level = #{level}" +
            "WHERE user_id = #{user_id} AND id = #{id}")
    int updateLanguageEntry(int id, int user_id, String language, String level);


    @Delete("DELETE FROM language_entry WHERE user_id = #{user_id} and id = #{id}")
    int deleteLanguageEntry(@Param("id") int id,
                             @Param("user_id") int user_id);


    @Results(
            id = "languageEntryList",value = {
            @Result(property="id", column="id"),
            @Result(property="user_id", column="user_id"),
            @Result(property="language", column="language"),
            @Result(property="level", column="level")
    })
    @Select("SELECT * FROM language_entry WHERE user_id = #{user_id};")
    List<LanguageEntry> getLanguageEntryList(int user_id);



}

