package com.example.recruit_backend.mapper;

import com.example.recruit_backend.entity.Position;
import org.apache.ibatis.annotations.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
public interface PositionMapper {

    @Insert("INSERT INTO `position`(`name`, base, department, `description`, requirement, update_time) " +
            "VALUES (#{name}, #{base}, #{department}, #{description}, #{requirement}, #{update_time});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPosition(Position position);


    @Update("UPDATE position SET name = #{name}, base = #{base}, " +
            "department = #{department}, description = #{description}, " +
            "requirement = #{requirement}, update_time = #{update_time} " +
            "WHERE id = #{id}")
    int updatePosition(@Param("id") String id,
                       @Param("name") String name,
                       @Param("base") String base,
                       @Param("department") String department,
                       @Param("description") String description,
                       @Param("requirement") String requirement,
                       @Param("update_time") Date update_time);

    @Delete("DELETE FROM position WHERE id = #{id}")
    int deletePosition(@Param("id") String id);


    @ResultType(Position.class)
    @Select("SELECT * FROM position WHERE id = #{id};")
    Position getPositionById(String id);


    @Results(
            id = "positionList",value = {
            @Result(property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="base", column="base"),
            @Result(property="department", column="department"),
            @Result(property="description", column="description"),
            @Result(property="requirement", column="requirement")
    })
    @Select("SELECT * FROM position")
    List<Position> getPositionList();
}

