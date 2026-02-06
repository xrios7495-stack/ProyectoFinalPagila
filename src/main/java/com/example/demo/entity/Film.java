package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "film_id")
    private Integer filmId;

    private String title;

    @Column(name = "rating")
    private String rating;

    public Integer getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }
}

