package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Favorit;
import com.meinname.kochbuch.model.FavoritId;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.repository.FavoritRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/favorit")
public class FavoritController {

    private final FavoritRepository favoritRepo;

    public FavoritController(FavoritRepository favoritRepository) {
        this.favoritRepo = favoritRepository;
    }
    
    @GetMapping("/{nutzerId}/{rezeptId}")
    public Favorit getFavoritById(@PathVariable Long nutzerId, @PathVariable Long rezeptId) {
        FavoritId id = new FavoritId(nutzerId, rezeptId);
        return favoritRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Favorit nicht gefunden"));
    }

    @PostMapping
    public Favorit neueFavorit(@RequestBody Favorit favorit) {
        return favoritRepo.save(favorit);
    }

    @DeleteMapping("/{nutzerId}/{rezeptId}")
    public void favoritLoeschen(@PathVariable Long nutzerId, @PathVariable Long rezeptId) {
        FavoritId id = new FavoritId(nutzerId, rezeptId);
        favoritRepo.deleteById(id);
    }

}