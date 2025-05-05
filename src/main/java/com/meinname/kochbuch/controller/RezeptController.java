package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.repository.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rezepte")
public class RezeptController {

    @Autowired
    private RezeptRepository rezeptRepo;

    @GetMapping
    public List<Rezept> alleRezepte() {
        return rezeptRepo.findAll();
    }

    @PostMapping
    public Rezept neuesRezept(@RequestBody Rezept rezept) {
        return rezeptRepo.save(rezept);
    }
}