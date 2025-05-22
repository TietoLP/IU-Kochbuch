package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Kategorie;
import com.meinname.kochbuch.model.Rezept;
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
    
    @GetMapping("/{id}")
    public Kategorie getKategorieById(@PathVariable Long id) {
        return kategorieRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Kategorie mit ID " + id + " nicht gefunden"));
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