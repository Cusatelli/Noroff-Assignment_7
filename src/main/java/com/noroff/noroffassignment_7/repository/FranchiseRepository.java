package com.noroff.noroffassignment_7.repository;

import com.noroff.noroffassignment_7.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * use: full CRUD in Franchise with JpaRepository.
 */
public interface FranchiseRepository extends JpaRepository<Franchise, Long> { }
