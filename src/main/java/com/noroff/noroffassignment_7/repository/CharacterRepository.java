package com.noroff.noroffassignment_7.repository;

import com.noroff.noroffassignment_7.model.Character;
import com.noroff.noroffassignment_7.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    //Optional<Character> findByCharacterNameIgnoreCase(String name);
    //List<Character> findByCharacterNameContainsIgnoreCAse(String name);
    //Set<Character> findCharacterByNameWithQuery(@Param("character")List<String>character);
}
