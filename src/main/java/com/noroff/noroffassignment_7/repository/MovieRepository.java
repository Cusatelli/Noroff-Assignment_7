package com.noroff.noroffassignment_7.repository;

import com.noroff.noroffassignment_7.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> { }
