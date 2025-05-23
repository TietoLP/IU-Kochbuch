package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Bewertung;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.model.Zutat;
import com.meinname.kochbuch.repository.ZutatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/zutat")
public class ZutatController {

    private final ZutatRepository zutatRepo;

    public ZutatController(ZutatRepository zutatRepository) {
        this.zutatRepo = zutatRepository;
    }

    @GetMapping
    public List<Zutat> getAlleZutat() {
        return zutatRepo.findAll().stream()
            .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public Zutat getZutatById(@PathVariable Long id) {
        return zutatRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Zutat mit ID " + id + " nicht gefunden"));
    }

    @PostMapping
    public Zutat neueZutat(@RequestBody Zutat zutat) {
        return zutatRepo.save(zutat);
    }
    
    @DeleteMapping("/{id}")
    public void zutatLoeschen(@PathVariable Long id) {
    	zutatRepo.deleteById(id);
    }
}