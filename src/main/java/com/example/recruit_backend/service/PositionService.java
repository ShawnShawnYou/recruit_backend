package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.Position;

import java.util.List;

public interface PositionService {

    int insertPosition(String name, String base, String department,
                       String description, String requirement);

    int updatePosition(String id, String name, String base,
                       String department, String description, String requirement);

    int deletePosition(String id);

    Position getPositionById(String id);

    List<Position> getPositionList();
}
