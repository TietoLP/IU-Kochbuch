package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Bewertung;
import com.meinname.kochbuch.repository.BewertungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bewertung")
public class BewertungController {

    private final BewertungRepository bewertungRepository;

    public BewertungController(BewertungRepository BewertungRepository) {
        this.bewertungRepository = BewertungRepository;
    }

    @PostMapping
    public Bewertung neueZutat(@RequestBody Bewertung bewertung) {
        return bewertungRepository.save(bewertung);
    }
}