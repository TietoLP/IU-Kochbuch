package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Bewertung;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.repository.BewertungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bewertung")
public class BewertungController {

    private final BewertungRepository bewertungRepo;

    public BewertungController(BewertungRepository bewertungRepository) {
        this.bewertungRepo = bewertungRepository;
    }
    
    @GetMapping("/{id}")
    public Bewertung getBewertungById(@PathVariable Long id) {
        return bewertungRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Bewertung mit ID " + id + " nicht gefunden"));
    }

    @PostMapping
    public Bewertung neueBewertung(@RequestBody Bewertung bewertung) {
        return bewertungRepo.save(bewertung);
    }
    
    @DeleteMapping("/{id}")
    public void bewertungLoeschen(@PathVariable Long id) {
    	bewertungRepo.deleteById(id);
    }
}