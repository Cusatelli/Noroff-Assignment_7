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
 * Creat a franchise class with fields id, name and description.
 * Use annotations in the fields, and relational database (ManyToMany) in movies.
 *One movie belongs to one franchise, but a franchise contains many movies.
 * Use a list of movies and a get movie list method to get all movies in franchise.
 */
@Entity
@Table(name = "franchise", schema = "public")
public class Franchise {
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
    @Size(max = 150)
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @Setter
    @OneToMany(
        mappedBy = "franchise",
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