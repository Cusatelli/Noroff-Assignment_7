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
    public Character getCharacterById(@PathVariable Long id) {
        if(!characterRepository.existsById((id))) { return null; }

        if(characterRepository.findById(id).isPresent()) {
            return characterRepository.findById(id).get();
        }
        return null;
    }

    @PostMapping("/{id}/update")
    public Character Update(@RequestBody Character character, @PathVariable("id") Long id){
        if(!characterRepository.existsById((id))) { return null; }
        if (characterRepository.findById(id).isPresent()) {
            Character original = characterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
            original.setId(character.getId());
            original.setName(character.getName());
            original.setAlias(character.getAlias());
            original.setGender(character.getGender());
        return characterRepository.save(original);
        }
        return null;
    }

    @DeleteMapping("/{id}/delete")
    public Boolean Delete(@PathVariable("id") Long id){
        if (!characterRepository.existsById(id)){ return false; }

        characterRepository.deleteById(id);

        if (characterRepository.existsById(id)){
            return false;
        }
        return true;
    }
}
