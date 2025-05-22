package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Nutzer;
import com.meinname.kochbuch.repository.NutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/nutzer")
public class NutzerController {

    private final NutzerRepository nutzerRepo;

    public NutzerController(NutzerRepository nutzerRepository) {
        this.nutzerRepo = nutzerRepository;
    }

    @PostMapping
    public Nutzer neueNutzer(@RequestBody Nutzer nutzer) {
        return nutzerRepo.save(nutzer);
    }
    
    @DeleteMapping("/{id}")
    public void nutzerLoeschen(@PathVariable Long id) {
    	nutzerRepo.deleteById(id);
    }
}