package com.noroff.noroffassignment_7.controller;

import com.noroff.noroffassignment_7.model.Character;
import com.noroff.noroffassignment_7.repository.CharacterRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Character")
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping("/")
    public List<Character> getCharacter() {
        return characterRepository.findAll();
    }

    @PostMapping("/")
    public Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Integer id) {
        if(!characterRepository.existsById((id))) { return null; }

        if(characterRepository.findById(id).isPresent()) {
            return characterRepository.findById(id).get();
        }
        return null;
    }

}
