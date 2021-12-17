package com.example.recruit_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "resume_file")
public class ResumeFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id",nullable = false)
    private int user_id;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "old_name",nullable = false)
    private String old_name;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "create_time",nullable = false)
    private Date create_time;

    @Column(name = "update_time",nullable = false)
    private Date update_time;



}
