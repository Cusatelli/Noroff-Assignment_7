package com.noroff.noroffassignment_7.repository;

import com.noroff.noroffassignment_7.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //Optional<Movie> findByMovieTitleIgnoreCase(String title);
    //List<Movie> findByMovieTitleContainsIgnoreCAse(String title);
    //Set<Movie> findMovieByTitleWithQuery(@Param("movie")List<String>movie);
}
