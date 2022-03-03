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
    private final CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

    @GetMapping("/{characterId}")
    public Character getCharacterById(@PathVariable Long characterId) {
        if(!characterRepository.existsById((characterId))) { return null; }

        return characterRepository.getById(characterId);
    }

    @PostMapping("/{characterId}")
    public Character updateCharacter(@RequestBody Character character, @PathVariable Long characterId){
        if(!characterRepository.existsById((characterId))) { return null; }

        Character original = characterRepository.getById(characterId);
        original.setName(character.getName());
        original.setAlias(character.getAlias());
        original.setGender(character.getGender());

        return characterRepository.save(original);
    }

    @DeleteMapping("/{characterId}")
    public Boolean deleteCharacter(@PathVariable Long characterId){
        if (!characterRepository.existsById(characterId)){ return false; }

        characterRepository.deleteById(characterId);

        return !characterRepository.existsById(characterId);
    }
}
