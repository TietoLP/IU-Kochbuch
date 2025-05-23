package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.model.Schwierigkeitsgrad;
import com.meinname.kochbuch.repository.SchwierigkeitsgradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/schwierigkeitsgrad")
public class SchwierigkeitsgradController {

    private final SchwierigkeitsgradRepository schwierigkeitsgradRepo;

    public SchwierigkeitsgradController(SchwierigkeitsgradRepository schwierigkeitsgradRepository) {
        this.schwierigkeitsgradRepo = schwierigkeitsgradRepository;
    }
    
    @GetMapping("/{id}")
    public Schwierigkeitsgrad getSchwierigkeitsgradById(@PathVariable Long id) {
        return schwierigkeitsgradRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Schwierigkeitsgrad mit ID " + id + " nicht gefunden"));
    }

    @PostMapping
    public Schwierigkeitsgrad neueSchwierigkeitsgrad(@RequestBody Schwierigkeitsgrad schwierigkeitsgrad) {
        return schwierigkeitsgradRepo.save(schwierigkeitsgrad);
    }
    
    @DeleteMapping("/{id}")
    public void schwierigkeitsgradLoeschen(@PathVariable Long id) {
    	schwierigkeitsgradRepo.deleteById(id);
    }
}