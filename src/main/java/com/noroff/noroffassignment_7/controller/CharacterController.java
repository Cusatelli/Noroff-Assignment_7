package com.noroff.noroffassignment_7.controller;

import com.noroff.noroffassignment_7.model.Character;
import com.noroff.noroffassignment_7.repository.CharacterRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Character")
@RequestMapping("/api/character")
public class CharacterController {
    // Repository extending JPARepository
    private final CharacterRepository characterRepository;

    /**
     * Inject Character Repository into Rest Character Controller.
     * @param characterRepository JPARepository Interface.
     */
    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * Get all characters through the exposed JPA Repository findAll method.
     * @return List of characters.
     */
    @GetMapping
    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }

    /**
     * Create a new Character through the exposed JPA Repository save method.
     * @param character Character Model.
     * @return The created Character Model.
     */
    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

    /**
     * Find a specific Character from its ID value through the exposed JPA Repository getById() method.
     * @param characterId The Long ID to search for in Character database.
     * @return The Character Model found by getById() method, or null if none found.
     */
    @GetMapping("/{characterId}")
    public Character getCharacterById(@PathVariable Long characterId) {
        if(!characterRepository.existsById((characterId))) { return null; }

        return characterRepository.getById(characterId);
    }

    /**
     * Update an existing Character in database from its ID value, through the exposed JPA Repository save() method.
     * @param character New Character Model to overwrite the current Character in database.
     * @param characterId ID to overwrite in database.
     * @return The updated Character Model.
     */
    @PatchMapping("/{characterId}")
    public Character updateCharacter(@RequestBody Character character, @PathVariable Long characterId){
        if(!characterRepository.existsById((characterId))) { return null; }

        Character original = characterRepository.getById(characterId);
        original.setName(character.getName());
        original.setAlias(character.getAlias());
        original.setGender(character.getGender());
        original.setImageUrl(character.getImageUrl());

        return characterRepository.save(original);
    }

    /**
     * Delete a character in database from ID input value, through exposed JPA Repository deleteById().
     * @param characterId Character ID to delete.
     * @return True if character does not exist anymore. (Successful delete).
     */
    @DeleteMapping("/{characterId}")
    public Boolean deleteCharacter(@PathVariable Long characterId){
        if (!characterRepository.existsById(characterId)){ return false; }

        characterRepository.deleteById(characterId);

        return !characterRepository.existsById(characterId);
    }
}
