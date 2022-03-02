package com.noroff.noroffassignment_7.controller;

import com.noroff.noroffassignment_7.model.Character;
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
    public Franchise getFranchiseById(@PathVariable Long id) {
        if(!franchiseRepository.existsById((id))) { return null; }

        if(franchiseRepository.findById(id).isPresent()) {
            return franchiseRepository.findById(id).get();
        }
        return null;
    }
    @PostMapping("/{id}/update")
    public Franchise Update(@RequestBody Franchise franchise, @PathVariable("id") Long id){
        if(!franchiseRepository.existsById((id))) { return null; }
        if (franchiseRepository.findById(id).isPresent()) {
            Franchise original = franchiseRepository.findById(id).orElseThrow(IllegalArgumentException::new);
            original.setId(franchise.getId());
            original.setName(franchise.getName());
            original.setDescription(franchise.getDescription());
        return franchiseRepository.save(original);
        }
        return null;
    }

    @DeleteMapping("/{id}/delete")
    public Boolean Delete(@PathVariable("id") Long id){
        if (!franchiseRepository.existsById(id)){ return false; }

        franchiseRepository.deleteById(id);

        if (franchiseRepository.existsById(id)){
            return false;
        }
        return true;
    }
}
