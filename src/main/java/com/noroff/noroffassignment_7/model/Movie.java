package com.noroff.noroffassignment_7.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column
    @Size(min = 1, max = 45)
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private String genre;

    @Column
    @Size(min = 2, max = 4)
    @Getter
    @Setter
    private Integer releaseYear;

    @Column
    @Size(min = 1, max = 45)
    @Getter
    @Setter
    private String directorName;

    @Column
    @Getter
    @Setter
    private String imageUrl;

    @Column
    @Getter
    @Setter
    private String trailerUrl;

    /*@ManyToOne
    @JoinTable(
            name = "movie_franchise",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "franchise_id" ) }
    )
    private Franchise franchise;*/

    /*@ManyToMany
    @JoinTable(
            name = "movie_characters",
            joinColumns = { @JoinColumn(name = "movie_id", referencedColumnName = "character_id") },
            inverseJoinColumns = { @JoinColumn(name = "character_id", referencedColumnName = "movie_id") }
    )
    private List<Character> characters;*/
}
