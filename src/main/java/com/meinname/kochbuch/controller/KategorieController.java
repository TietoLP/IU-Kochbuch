package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Kategorie;
import com.meinname.kochbuch.repository.KategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/kategorie")
public class KategorieController {

    private final KategorieRepository kategorieRepository;

    public KategorieController(KategorieRepository kategorieRepository) {
        this.kategorieRepository = kategorieRepository;
    }

    @PostMapping
    public Kategorie neueKategorie(@RequestBody Kategorie kategorie) {
        return kategorieRepository.save(kategorie);
    }
}