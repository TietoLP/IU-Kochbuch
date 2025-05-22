package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Zutat;
import com.meinname.kochbuch.repository.ZutatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/zutat")
public class ZutatController {

    private final ZutatRepository zutatRepo;

    public ZutatController(ZutatRepository zutatRepository) {
        this.zutatRepo = zutatRepository;
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