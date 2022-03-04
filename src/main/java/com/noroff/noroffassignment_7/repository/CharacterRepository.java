package com.noroff.noroffassignment_7.repository;

import com.noroff.noroffassignment_7.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * use: full CRUD in character with JpaRepository.
 */
public interface CharacterRepository extends JpaRepository<Character, Long> { }
