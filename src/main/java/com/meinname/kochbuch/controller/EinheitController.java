package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Einheit;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.repository.EinheitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/einheit")
public class EinheitController {

    private final EinheitRepository einheitRepo;

    public EinheitController(EinheitRepository einheitRepository) {
        this.einheitRepo = einheitRepository;
    }
    
    @GetMapping("/{id}")
    public Einheit getEinheitById(@PathVariable Long id) {
        return einheitRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Einheit mit ID " + id + " nicht gefunden"));
    }

    @PostMapping
    public Einheit neueEinheit(@RequestBody Einheit einheit) {
        return einheitRepo.save(einheit);
    }
    
    @DeleteMapping("/{id}")
    public void einheitLoeschen(@PathVariable Long id) {
    	einheitRepo.deleteById(id);
    }
}