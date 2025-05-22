package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Kategorie;
import com.meinname.kochbuch.repository.KategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/kategorie")
public class KategorieController {

    private final KategorieRepository kategorieRepo;

    public KategorieController(KategorieRepository kategorieRepository) {
        this.kategorieRepo = kategorieRepository;
    }

    @PostMapping
    public Kategorie neueKategorie(@RequestBody Kategorie kategorie) {
        return kategorieRepo.save(kategorie);
    }
    
    @DeleteMapping("/{id}")
    public void kategorieLoeschen(@PathVariable Long id) {
    	kategorieRepo.deleteById(id);
    }
}