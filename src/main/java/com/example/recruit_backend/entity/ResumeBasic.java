package com.example.recruit_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "resume_basic")
public class ResumeBasic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id",nullable = false)
    private int user_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "self_evaluate")
    private String self_evaluate;

    @Column(name = "update_time")
    private Date update_time;

}
