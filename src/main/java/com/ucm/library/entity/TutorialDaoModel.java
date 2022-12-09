package com.ucm.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tutorial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialDaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private AuthorDaoModel author;

    public TutorialDaoModel(String title, String description, boolean published, AuthorDaoModel authorDaoModel) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.author = authorDaoModel;
    }
}
