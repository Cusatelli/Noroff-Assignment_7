package com.noroff.noroffassignment_7.controller;

import com.noroff.noroffassignment_7.model.Character;
import com.noroff.noroffassignment_7.model.Franchise;
import com.noroff.noroffassignment_7.model.Movie;
import com.noroff.noroffassignment_7.repository.CharacterRepository;
import com.noroff.noroffassignment_7.repository.FranchiseRepository;
import com.noroff.noroffassignment_7.repository.MovieRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Franchise")
@RequestMapping("/franchise")
public class FranchiseController {
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    public FranchiseController(FranchiseRepository franchiseRepository, MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    @GetMapping("/")
    public List<Franchise> getFranchise() {
        return franchiseRepository.findAll();
    }

    @GetMapping("/{franchiseId}/movies")
    public List<Movie> getAllMoviesInFranchise(@PathVariable Long franchiseId) {
        if(!franchiseRepository.existsById(franchiseId)) { return null; }

        return getAllMovies(franchiseId);
    }

    @GetMapping("/{franchiseId}/movies/characters")
    public List<Character> getAllCharactersInFranchise(@PathVariable Long franchiseId) {
        if(!franchiseRepository.existsById(franchiseId)) { return null; }

        List<Movie> movies = getAllMovies(franchiseId);
        List<Character> characters = new ArrayList<>();
        for (Movie movie : movies) {
            characters.addAll(MovieController.getCharactersFromMovie(movie, characterRepository));
        }

        return characters;
    }

    @PostMapping("/")
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @GetMapping("/{id}")
    public Franchise getFranchiseById(@PathVariable Long id) {
        if(!franchiseRepository.existsById((id))) { return null; }

        if(franchiseRepository.findById(id).isPresent()) {
            return franchiseRepository.findById(id).get();
        }
        return null;
    }

    @PatchMapping("/{franchiseId}/movies")
    public Franchise updateMoviesInFranchise(@PathVariable Long franchiseId, @RequestBody Long[] movieIds) {
        Franchise franchise = franchiseRepository.getById(franchiseId);

        for (int i = 0; i < franchise.getMovies().size(); i++) {
            Movie movie = movieRepository.getById(Long.valueOf(franchise.getMovies().get(i).replace("/movie/", "")));

            movie.setFranchise(null);
            movieRepository.save(movie);
        }

        List<Movie> movies = new ArrayList<>();
        for (Long movieId: movieIds) {
            Movie movie = movieRepository.getById(movieId);
            movies.add(movie);

            movie.setFranchise(franchise);
            movieRepository.save(movie);
        }
        franchise.setMovies(movies);

        return franchiseRepository.save(franchise);
    }

    @DeleteMapping("/{franchiseId}/")
    public Boolean deleteFranchise(@PathVariable Long franchiseId){
        if (!franchiseRepository.existsById(franchiseId)){ return false; }

        franchiseRepository.deleteById(franchiseId);

        return !franchiseRepository.existsById(franchiseId);
    }

    private List<Movie> getAllMovies(Long franchiseId) {
        Franchise franchise = new Franchise();
        if(franchiseRepository.findById(franchiseId).isPresent()) {
            franchise = franchiseRepository.findById(franchiseId).get();
        }

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < franchise.getMovies().size(); i++) {
            Long movieId = Long.valueOf(franchise.getMovies().get(i).replace("/movie/", ""));
            if(movieRepository.findById(movieId).isPresent()) {
                movies.add(movieRepository.findById(movieId).get());
            }
        }

        return movies;
    }
}
