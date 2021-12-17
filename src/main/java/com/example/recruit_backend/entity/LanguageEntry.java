package com.example.recruit_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "language_entry")
public class LanguageEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id",nullable = false)
    private int user_id;

    @Column(name = "language",nullable = false)
    private String language;

    @Column(name = "level",nullable = false)
    private String level;


}
