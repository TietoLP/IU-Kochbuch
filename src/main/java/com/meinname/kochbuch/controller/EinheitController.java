package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Einheit;
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

    @PostMapping
    public Einheit neueEinheit(@RequestBody Einheit einheit) {
        return einheitRepo.save(einheit);
    }
    
    @DeleteMapping("/{id}")
    public void einheitLoeschen(@PathVariable Long id) {
    	einheitRepo.deleteById(id);
    }
}