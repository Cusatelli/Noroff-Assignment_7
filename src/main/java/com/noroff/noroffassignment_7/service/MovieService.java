package com.noroff.noroffassignment_7.service;

import com.noroff.noroffassignment_7.model.Movie;

public interface MovieService {
    Movie addMovies(int id, String title, String genre, int releaseYear, String directorName, String imageUrl, String trailerUrl);
    Movie addMovies(Movie movie);
}
