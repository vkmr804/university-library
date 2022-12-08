package com.ucm.thesis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;

    public AuthorDaoModel(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

}
