package com.noroff.noroffassignment_7.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Size(min = 1, max = 45)
    @Column(nullable = false)
    private String title;

    @Getter @Setter
    @Column(nullable = false)
    private String genre;

    @Getter @Setter
    @Size(min = 2, max = 4)
    @Column(nullable = false)
    private Integer releaseYear;

    @Getter @Setter
    @Size(min = 1, max = 45)
    @Column(nullable = false)
    private String directorName;

    @Getter @Setter
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;

    @Getter @Setter
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String trailerUrl;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "franchise_movies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Franchise franchise;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_characters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Character> characters;
}
