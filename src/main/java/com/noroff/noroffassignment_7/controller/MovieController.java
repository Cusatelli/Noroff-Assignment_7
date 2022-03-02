package com.noroff.noroffassignment_7.controller;

import com.noroff.noroffassignment_7.model.Character;
import com.noroff.noroffassignment_7.model.Movie;
import com.noroff.noroffassignment_7.repository.MovieRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Movie")
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    @PostMapping("/")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        if(!movieRepository.existsById((id))) { return null; }

        if(movieRepository.findById(id).isPresent()) {
            return movieRepository.findById(id).get();
        }
        return null;
    }
    @PostMapping("/{id}/update")
    public Movie Update(@RequestBody Movie movie, @PathVariable("id") Long id){
        if(!movieRepository.existsById((id))) { return null; }
        if (movieRepository.findById(id).isPresent()) {
            Movie original = movieRepository.findById(id).orElseThrow(IllegalArgumentException::new);
            original.setId(movie.getId());
            original.setTitle(movie.getTitle());
            original.setGenre(movie.getGenre());
            original.setReleaseYear(movie.getReleaseYear());
            original.setDirectorName(movie.getDirectorName());
            original.setImageUrl(movie.getImageUrl());
            original.setTrailerUrl(movie.getTrailerUrl());
            return movieRepository.save(original);
        }
        return null;
    }

    @DeleteMapping("/{id}/delete")
    public Boolean Delete(@PathVariable("id") Long id){
        if (!movieRepository.existsById(id)){ return false; }

        movieRepository.deleteById(id);

        if (movieRepository.existsById(id)){
            return false;
        }
        return true;
    }
}
