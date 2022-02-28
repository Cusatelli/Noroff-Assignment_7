package com.noroff.noroffassignment_7;

import com.noroff.noroffassignment_7.model.Movie;
import com.noroff.noroffassignment_7.repository.CharacterRepository;
import com.noroff.noroffassignment_7.repository.FranchiseRepository;
import com.noroff.noroffassignment_7.repository.MovieRepository;
import com.noroff.noroffassignment_7.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    private MovieRepository movieRepository;
    private MovieService movieService;

    @Autowired
    public Seeder(MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*Movie movie = new Movie(1,"Blacklist",
                "Thriller", 2011,
                "Omar and Einar",
                "",
                "");

        movieRepository.save(movie);
        movieService.addMovies(movie);

         */
    }
}
