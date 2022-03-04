package com.noroff.noroffassignment_7.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Creat a movie class with fields id, title, genre, release year, director name, imageUrl, trailerUrl.
 * Use annotations in the fields, and relational database in movies.
 * Franchise can include several movies, one movie contains many characters
 * and a character plays in multiple movies.
 * Use a list of characters and a get character list method to get all characters in a movie.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie", schema = "public")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Size(min = 1, max = 50)
    @Column(nullable = false)
    private String title;

    @Getter @Setter
    @Column(nullable = false)
    private String genre;

    @Getter @Setter
    @Column(nullable = false)
    private Integer releaseYear;

    @Getter @Setter
    @Size(min = 1, max = 100)
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
    @JoinTable(
            name = "movie_franchise",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "franchise_id")}
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Franchise franchise;

    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Character> characters = new ArrayList<>();

    /**
     * Takes the list of characters and then converts it to a list of Long to get characterIds
     * @return characters in a list of type long
     */
    @JsonGetter("characters")
    public List<Long> getCharacters() {
        return characters.stream().map(Character::getId).collect(Collectors.toList());
    }
}