package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Favorit;
import com.meinname.kochbuch.repository.FavoritRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/favorit")
public class FavoritController {

    private final FavoritRepository favoritRepository;

    public FavoritController(FavoritRepository favoritRepository) {
        this.favoritRepository = favoritRepository;
    }

    @PostMapping
    public Favorit neueFavorit(@RequestBody Favorit favorit) {
        return favoritRepository.save(favorit);
    }
}