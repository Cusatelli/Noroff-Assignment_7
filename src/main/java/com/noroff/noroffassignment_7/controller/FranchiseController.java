package com.noroff.noroffassignment_7.controller;

import com.noroff.noroffassignment_7.model.Franchise;
import com.noroff.noroffassignment_7.repository.FranchiseRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Franchise")
@RequestMapping("/franchise")
public class FranchiseController {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @GetMapping("/")
    public List<Franchise> getFranchise() {
        return franchiseRepository.findAll();
    }

    @PostMapping("/")
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @GetMapping("/{id}")
    public Franchise getFranchiseById(@PathVariable Integer id) {
        if(!franchiseRepository.existsById((id))) { return null; }

        if(franchiseRepository.findById(id).isPresent()) {
            return franchiseRepository.findById(id).get();
        }
        return null;
    }

}
