package com.example.recruit_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "resume_submit_status")
public class ResumeSubmitStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id",nullable = false)
    private int user_id;

    @Column(name = "id_position",nullable = false)
    private int id_position;

    @Column(name = "status",nullable = false)
    private int status;

    @Column(name = "update_time")
    private Date update_time;

}
