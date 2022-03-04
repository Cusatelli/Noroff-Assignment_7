package com.noroff.noroffassignment_7.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create a character class with fields id, name, alias, gender and imageUrl.
 * Use annotations in the fields, and relational database(ManyToMany) in movies.
 * One movie contains many characters and a character plays in multiple movies.
 */
@Entity
@Table(name = "character", schema = "public")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Size(min = 1, max = 50)
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Size(max = 50)
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String alias;

    @Getter @Setter
    @Column(nullable = false)
    private Gender gender;

    @Getter @Setter
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;

    @Setter
    @ManyToMany(
        mappedBy = "characters",
        fetch = FetchType.LAZY,
        cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
        }
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Movie> movies = new ArrayList<>();

    /**
     * Takes the list of movies and then converts it to a list of Long to get movieIds
     * @return movies in a list of type long
     */
    @JsonGetter("movies")
    public List<Long> getMovies() {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}