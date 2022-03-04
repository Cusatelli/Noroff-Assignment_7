package com.noroff.noroffassignment_7.repository;

import com.noroff.noroffassignment_7.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * use: full CRUD in Movies with JpaRepository.
 */
public interface MovieRepository extends JpaRepository<Movie, Long> { }
