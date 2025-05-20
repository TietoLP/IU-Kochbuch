package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Zutat;
import com.meinname.kochbuch.repository.ZutatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/zutaten")
public class ZutatController {

    private final ZutatRepository zutatRepository;

    public ZutatController(ZutatRepository zutatRepository) {
        this.zutatRepository = zutatRepository;
    }

    @PostMapping
    public Zutat neueZutat(@RequestBody Zutat zutat) {
        return zutatRepository.save(zutat);
    }
}