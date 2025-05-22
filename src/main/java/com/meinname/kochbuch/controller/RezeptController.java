package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.model.Zutat;
import com.meinname.kochbuch.repository.RezeptRepository;
import com.meinname.kochbuch.repository.ZutatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rezept")
public class RezeptController {

    @Autowired
    private RezeptRepository rezeptRepo;

    @Autowired
    private ZutatRepository zutatRepo; // <-- Hinzufügen

    @GetMapping
    public List<Rezept> getAlleRezepte() {
        return rezeptRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public Rezept getRezeptById(@PathVariable Long id) {
        return rezeptRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Rezept mit ID " + id + " nicht gefunden"));
    }
    
    // Hiermit kann man Rezepte auch ohne ausformulierte Zutaten hinzufügen. Hier reichen die Zutaten-Ids
    @PostMapping
    public Rezept neuesRezept(@RequestBody Rezept rezept) {
        List<Zutat> zutatenListe = rezept.getZutaten().stream()
            // Expliziter Typ für die Lambda-Variable
            .map(zutat -> {
                Zutat gefundeneZutat = zutatRepo.findById(zutat.getId().longValue())
                    .orElseThrow(() -> new RuntimeException("Zutat nicht gefunden: " + zutat.getId()));
                return gefundeneZutat;
            })
            .collect(Collectors.toList()); // Verwende collect(Collectors.toList())
        
        rezept.setZutaten(zutatenListe);
        return rezeptRepo.save(rezept);
    }
    
    @DeleteMapping("/{id}")
    public void rezeptLoeschen(@PathVariable Long id) {
    	rezeptRepo.deleteById(id);
    }
}