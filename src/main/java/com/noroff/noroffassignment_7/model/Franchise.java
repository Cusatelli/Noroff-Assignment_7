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

@Entity
@Table(name = "franchise", schema = "public")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Size(min = 1, max = 45)
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Size(min = 1, max = 100)
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @OneToMany(mappedBy = "franchise", fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Movie> movies = new ArrayList<>();

    @JsonGetter("movies")
    public List<String> getMovies() {
        return movies.stream().map(movie -> "/movie/" + movie.getId()).collect(Collectors.toList());
    }
}