package com.noroff.noroffassignment_7.controller;

import com.noroff.noroffassignment_7.model.Character;
import com.noroff.noroffassignment_7.model.Movie;
import com.noroff.noroffassignment_7.repository.CharacterRepository;
import com.noroff.noroffassignment_7.repository.MovieRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Movie")
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    public MovieController(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        if(!movieRepository.existsById((movieId))) { return null; }

        return movieRepository.getById(movieId);
    }

    @PostMapping("/{movieId}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable Long movieId){
        if(!movieRepository.existsById((movieId))) { return null; }

        Movie original = movieRepository.getById(movieId);
        original.setTitle(movie.getTitle());
        original.setGenre(movie.getGenre());
        original.setReleaseYear(movie.getReleaseYear());
        original.setDirectorName(movie.getDirectorName());
        original.setImageUrl(movie.getImageUrl());
        original.setTrailerUrl(movie.getTrailerUrl());

        return movieRepository.save(original);
    }

    @DeleteMapping("/{movieId}")
    public Boolean deleteMovie(@PathVariable Long movieId){
        if (!movieRepository.existsById(movieId)){ return false; }

        movieRepository.deleteById(movieId);
        return !movieRepository.existsById(movieId);
    }

    @GetMapping("/{movieId}/characters")
    public List<Character> getAllCharactersInMovie(@PathVariable Long movieId) {
        if(!movieRepository.existsById(movieId)) { return null; }

        return getCharactersFromMovie(movieRepository.getById(movieId), characterRepository);
    }

    @PatchMapping("/{movieId}/characters")
    public Movie updateCharactersInMovie(@RequestBody Long[] characterIds, @PathVariable Long movieId) {
        if (!movieRepository.existsById(movieId)) { return null; }

        List<Character> characters = new ArrayList<>();
        for (Long characterId: characterIds) {
            Character character = characterRepository.getById(characterId);
            characters.add(character);
        }
        Movie movie = movieRepository.getById(movieId);
        movie.setCharacters(characters);

        return movieRepository.save(movie);
    }

    static List<Character> getCharactersFromMovie(Movie movie, CharacterRepository characterRepository) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < movie.getCharacters().size(); i++) {
            Long characterId = movie.getCharacters().get(i);
            if(characterRepository.findById(characterId).isPresent()) {
                characters.add(characterRepository.findById(characterId).get());
            }
        }
        return characters;
    }
}
