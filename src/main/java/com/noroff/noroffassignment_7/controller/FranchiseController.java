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
@RequestMapping("/api/franchise")
public class FranchiseController {
    // Repository extending JPARepository
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    /**
     * Inject Franchise, Movie & Character Repository into Rest Franchise Controller.
     * @param franchiseRepository JPARepository Interface.
     * @param movieRepository JPARepository Interface.
     * @param characterRepository JPARepository Interface.
     */
    public FranchiseController(FranchiseRepository franchiseRepository, MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    /**
     * Get all franchises through the exposed JPA Repository findAll method.
     * @return List of franchises.
     */
    @GetMapping
    public List<Franchise> getFranchises() {
        return franchiseRepository.findAll();
    }

    /**
     * Create a new Franchise through the exposed JPA Repository save method.
     * @param franchise Franchise Model.
     * @return The created Franchise Model.
     */
    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    /**
     * Find a specific Franchise from its ID value through the exposed JPA Repository getById() method.
     * @param franchiseId The Long ID to search for in Franchise database.
     * @return The Franchise Model found by getById() method, or null if none found.
     */
    @GetMapping("/{franchiseId}")
    public Franchise getFranchiseById(@PathVariable Long franchiseId) {
        if(!franchiseRepository.existsById((franchiseId))) { return null; }

        return franchiseRepository.getById(franchiseId);
    }

    /**
     * Update an existing Franchise in database from its ID value, through the exposed JPA Repository save() method.
     * Before overwriting new data make sure data is not null or empty.
     * @param franchise New Franchise Model to overwrite the current Franchise in database.
     * @param franchiseId ID to overwrite in database.
     * @return The updated Franchise Model.
     */
    @PatchMapping("/{franchiseId}")
    public Franchise updateFranchise(@PathVariable Long franchiseId, @RequestBody Franchise franchise) {
        if(!franchiseRepository.existsById(franchiseId)) { return null; }

        Franchise franchiseToUpdate = franchiseRepository.getById(franchiseId);
        if(isValid(franchise.getName())) {
            franchiseToUpdate.setName(franchise.getName());
        }
        if(isValid(franchise.getDescription())) {
            franchiseToUpdate.setDescription(franchise.getDescription());
        }

        return franchiseRepository.save(franchiseToUpdate);
    }

    /**
     * Delete a franchise in database from ID input value, through exposed JPA Repository deleteById().
     * @param franchiseId Franchise ID to delete.
     * @return True if franchise does not exist anymore. (Successful delete).
     */
    @DeleteMapping("/{franchiseId}")
    public Boolean deleteFranchise(@PathVariable Long franchiseId){
        if (!franchiseRepository.existsById(franchiseId)){ return false; }

        franchiseRepository.deleteById(franchiseId);

        return !franchiseRepository.existsById(franchiseId);
    }

    /**
     * Get all movies in Franchise based on ID input. Makes use of the getAllMovies(franchiseId) helper method.
     * @param franchiseId Franchise ID to find all Movies in.
     * @return List of Movies.
     */
    @GetMapping("/{franchiseId}/movies")
    public List<Movie> getAllMoviesInFranchise(@PathVariable Long franchiseId) {
        if(!franchiseRepository.existsById(franchiseId)) { return null; }

        return getAllMovies(franchiseId);
    }

    /**
     * Update Movies in Franchise by ID & Movie Ids.
     * Iterate over currently saved movies and remove the Franchise ID in list before proceeding to add new movies.
     * This ensures values can be assigned and update values reflects the current desired database relationship.
     * @param franchiseId Franchise to modify.
     * @param movieIds Movie Ids to add to Franchise.
     * @return Franchise with updated Movies List.
     */
    @PatchMapping("/{franchiseId}/movies")
    public Franchise updateMoviesInFranchise(@PathVariable Long franchiseId, @RequestBody Long[] movieIds) {
        Franchise franchise = franchiseRepository.getById(franchiseId);

        // Iterate over existing movies in franchise before update.
        for (int i = 0; i < franchise.getMovies().size(); i++) {
            Movie movie = movieRepository.getById(franchise.getMovies().get(i));

            movie.setFranchise(null); // Remove this Franchise from Movie.
            movieRepository.save(movie); // Save data to movies (database).
        }

        // Iterate over new movies in franchise after update.
        List<Movie> movies = new ArrayList<>();
        for (Long movieId: movieIds) {
            Movie movie = movieRepository.getById(movieId);
            movies.add(movie); // Add to list

            movie.setFranchise(franchise); // Add this franchise to movie.
            movieRepository.save(movie); // Save data to movies (database).
        }
        franchise.setMovies(movies); // overwrite all movies in franchise.

        return franchiseRepository.save(franchise); // Save updated data to franchise.
    }

    /**
     * Get all Characters in Franchise through Movies.
     * Get all movies in Franchise through Helper Method getAllMovies(franchiseId),
     * then iterate over this list of Movies to find all characters related to that movie.
     * Finally, return this list of characters.
     * @param franchiseId Franchise ID to iterate through.
     * @return List of Characters.
     */
    @GetMapping("/{franchiseId}/movies/characters")
    public List<Character> getAllCharactersInFranchise(@PathVariable Long franchiseId) {
        if(!franchiseRepository.existsById(franchiseId)) { return null; }

        List<Movie> movies = getAllMovies(franchiseId); // Get All movies
        List<Character> characters = new ArrayList<>(); // Init empty list
        for (Movie movie : movies) { // For each movie get all characters and save in list.
            characters.addAll(MovieController.getCharactersFromMovie(movie, characterRepository));
        }

        return characters; // Return character list.
    }

    /**
     * Helper Method to get all movies in Franchise Database.
     * @param franchiseId Franchise to iterate through.
     * @return List of Movies.
     */
    private List<Movie> getAllMovies(Long franchiseId) {
        Franchise franchise = franchiseRepository.getById(franchiseId);

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < franchise.getMovies().size(); i++) {
            Long movieId = franchise.getMovies().get(i);
            movies.add(movieRepository.getById(movieId));
        }

        franchise.setMovies(movies);
        return movies;
    }

    /**
     * Check if String value is empty, blank or in Swagger-UI "string".
     * @param str input value to check.
     * @return True if not Empty, Blank or "string".
     */
    private boolean isValid(String str) {
        return !str.isEmpty() && !str.isBlank() && !str.equals("string");
    }
}
