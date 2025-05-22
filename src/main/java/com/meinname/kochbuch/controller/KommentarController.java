package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Kommentar;
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

    @PostMapping
    public Kommentar neueKommentar(@RequestBody Kommentar kommentar) {
        return kommentarRepo.save(kommentar);
    }
    
    @DeleteMapping("/{id}")
    public void kommentarLoeschen(@PathVariable Long id) {
    	kommentarRepo.deleteById(id);
    }
}