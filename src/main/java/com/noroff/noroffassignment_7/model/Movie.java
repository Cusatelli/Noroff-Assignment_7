package com.noroff.noroffassignment_7.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Size(min = 1, max = 45)
    private String title;

    @Column
    private String genre;

    @Column
    @Size(min = 2, max = 4)
    private Integer releaseYear;

    @Column
    @Size(min = 1, max = 45)
    private String directorName;

    @Column
    private String imageUrl;

    @Column
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

}
