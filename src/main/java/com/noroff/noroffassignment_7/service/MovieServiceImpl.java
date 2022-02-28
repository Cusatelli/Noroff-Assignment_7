package com.noroff.noroffassignment_7.service;

import com.noroff.noroffassignment_7.model.Movie;
import com.noroff.noroffassignment_7.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovies(int id, String title, String genre, int releaseYear, String directorName, String imageUrl, String trailerUrl) {
        Movie newMovie = new Movie(
                id,
                title,
                genre,
                releaseYear,
                directorName,
                imageUrl,
                trailerUrl
        );
        return this.addMovies(newMovie);
    }

    @Override
    public Movie addMovies(Movie movie) {
        return movieRepository.save(movie);
    }
}
