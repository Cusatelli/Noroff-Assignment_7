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
    // Repository extending JPARepository
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    /**
     * Inject Movie & Character Repository into Rest Movie Controller.
     * @param movieRepository JPARepository Interface.
     * @param characterRepository JPARepository Interface.
     */
    public MovieController(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    /**
     * Get all movies through the exposed JPA Repository findAll method.
     * @return List of movies.
     */
    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    /**
     * Create a new Movie through the exposed JPA Repository save method.
     * @param movie Movie Model.
     * @return The created Movie Model.
     */
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Find a specific Movie from its ID value through the exposed JPA Repository getById() method.
     * @param movieId The Long ID to search for in Movie database.
     * @return The Movie Model found by getById() method, or null if none found.
     */
    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        if(!movieRepository.existsById((movieId))) { return null; }

        return movieRepository.getById(movieId);
    }

    /**
     * Update an existing Movie in database from its ID value, through the exposed JPA Repository save() method.
     * Before overwriting new data make sure data is not null or empty.
     * @param movie New Movie Model to overwrite the current Movie in database.
     * @param movieId ID to overwrite in database.
     * @return The updated Movie Model.
     */
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

    /**
     * Delete a movie in database from ID input value, through exposed JPA Repository deleteById().
     * @param movieId Movie ID to delete.
     * @return True if movie does not exist anymore. (Successful delete).
     */
    @DeleteMapping("/{movieId}")
    public Boolean deleteMovie(@PathVariable Long movieId){
        if (!movieRepository.existsById(movieId)){ return false; }

        movieRepository.deleteById(movieId);
        return !movieRepository.existsById(movieId);
    }

    /**
     * Get All characters in Movie by ID, through Helper Method getCharactersFromMovie().
     * @param movieId Movie ID to search by.
     * @return List of Characters.
     */
    @GetMapping("/{movieId}/characters")
    public List<Character> getAllCharactersInMovie(@PathVariable Long movieId) {
        if(!movieRepository.existsById(movieId)) { return null; }

        return getCharactersFromMovie(movieRepository.getById(movieId), characterRepository);
    }

    /**
     * Update Characters in Movies by Ids & Id. For each new Character Id added iterate over and add that Character to Movie.
     * @param characterIds Array of Long Character ids.
     * @param movieId movie Id to update.
     * @return Movie with updated Characters.
     */
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

    /**
     * Helper Method to get Characters in Movie.
     * @param movie Movie Model to get Characters from.
     * @param characterRepository JPARepository of Character to findById of each movie.
     * @return List of Characters.
     */
    static List<Character> getCharactersFromMovie(Movie movie, CharacterRepository characterRepository) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < movie.getCharacters().size(); i++) { // For each character in param Movie.
            Long characterId = movie.getCharacters().get(i); // Get Id
            if(characterRepository.findById(characterId).isPresent()) { // Check if exists
                characters.add(characterRepository.findById(characterId).get()); // Add to list
            }
        }
        return characters; // return populated list.
    }
}
