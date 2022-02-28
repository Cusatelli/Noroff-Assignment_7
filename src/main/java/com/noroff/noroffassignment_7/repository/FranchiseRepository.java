package com.noroff.noroffassignment_7.repository;

import com.noroff.noroffassignment_7.model.Franchise;
import com.noroff.noroffassignment_7.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
    //Optional<Franchise> findByFranchiseIgnoreCase(String title);
    //List<Franchise> findByFranchiseContainsIgnoreCAse(String title);
    //Set<Franchise> findMovieByFranchiseWithQuery(@Param("character")List<String>character);

}
