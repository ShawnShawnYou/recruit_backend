package com.example.recruit_backend.service;

import com.example.recruit_backend.entity.Position;
import com.example.recruit_backend.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionMapper positionMapper;

    @Override
    public int insertPosition(String name, String base, String department,
                              String description, String requirement) {
        Position position = new Position();
        position.setName(name);
        position.setBase(base);
        position.setDepartment(department);
        position.setDescription(description);
        position.setRequirement(requirement);
        position.setUpdate_time(new Date());
        return positionMapper.insertPosition(position);

    }

    @Override
    public int updatePosition(String id, String name, String base,
                              String department, String description, String requirement) {
        return positionMapper.updatePosition(
                id, name, base, department, description, requirement, new Date());
    }

    @Override
    public int deletePosition(String id) {
        return positionMapper.deletePosition(id);
    }

    @Override
    public Position getPositionById(String id) {
        return positionMapper.getPositionById(id);
    }

    @Override
    public List<Position> getPositionList() {
        return positionMapper.getPositionList();
    }

}

