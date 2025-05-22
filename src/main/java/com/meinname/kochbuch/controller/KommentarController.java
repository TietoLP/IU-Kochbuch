package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Kommentar;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.repository.KommentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/kommentar")
public class KommentarController {

    private final KommentarRepository kommentarRepo;

    public KommentarController(KommentarRepository kommentarRepository) {
        this.kommentarRepo = kommentarRepository;
    }
    
    @GetMapping("/{id}")
    public Kommentar getKommentarById(@PathVariable Long id) {
        return kommentarRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Kommentar mit ID " + id + " nicht gefunden"));
    }

    @PostMapping
    public Kommentar neueKommentar(@RequestBody Kommentar kommentar) {
        return kommentarRepo.save(kommentar);
    }
    
    @DeleteMapping("/{id}")
    public void kommentarLoeschen(@PathVariable Long id) {
    	kommentarRepo.deleteById(id);
    }
}