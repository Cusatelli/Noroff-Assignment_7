package com.noroff.noroffassignment_7.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column
    @Size(min = 1, max = 45)
    @Getter
    @Setter
    private String name;

    @Column
    @Size(min = 1, max = 45)
    @Getter
    @Setter
    private String alias;

    @Column
    @Getter
    @Setter
    private Gender gender;

    @Column
    @Getter
    @Setter
    private String imageUrl;

    /*@ManyToMany(mappedBy = "movies_id", fetch = FetchType.LAZY)
    public List<Movie> movies;*/
}
