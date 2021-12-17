package com.example.recruit_backend.controller;

import com.example.recruit_backend.entity.Position;
import com.example.recruit_backend.entity.Result;
import com.example.recruit_backend.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {

    @Autowired
    PositionService positionService;


    @PostMapping("/insertPosition")
    // ok
    public Result updateUser(@RequestParam("name") String name,
                             @RequestParam("base") String base,
                             @RequestParam("department") String department,
                             @RequestParam("description") String description,
                             @RequestParam("requirement") String requirement) {
        try {
            positionService.insertPosition(
                    name, base, department, description, requirement);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/updatePosition")
    // ok
    public Result updatePosition(@RequestParam("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("base") String base,
                                @RequestParam("department") String department,
                                @RequestParam("description") String description,
                                @RequestParam("requirement") String requirement) {
        try {
            positionService.updatePosition(
                    id, name, base, department, description, requirement);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/deletePosition")
    // ok
    public Result deletePosition(@RequestParam("id") String id) {
        try {
            positionService.deletePosition(id);
            return Result.success(null);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/getPositionById")
    // ok
    public Result getPositionById(@RequestParam("id") String id) {
        Position position;
        try {
            position = positionService.getPositionById(id);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        if (position != null)
            return Result.success(position);
        else
            return Result.fail("don't exist");
    }

    @GetMapping("/getPositionList")
    // ok
    public Result getPositionList() {
        List<Position> positionList;
        try {
            positionList = positionService.getPositionList();
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }

        return Result.success(positionList);
    }




}
