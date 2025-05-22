package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Nutzer;
import com.meinname.kochbuch.repository.NutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/nutzer")
public class NutzerController {

    private final NutzerRepository nutzerRepository;

    public NutzerController(NutzerRepository nutzerRepository) {
        this.nutzerRepository = nutzerRepository;
    }

    @PostMapping
    public Nutzer neueNutzer(@RequestBody Nutzer nutzer) {
        return nutzerRepository.save(nutzer);
    }
}