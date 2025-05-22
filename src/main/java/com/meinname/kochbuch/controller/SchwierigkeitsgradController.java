package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.model.Schwierigkeitsgrad;
import com.meinname.kochbuch.repository.SchwierigkeitsgradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/schwierigkeitsgrad")
public class SchwierigkeitsgradController {

    private final SchwierigkeitsgradRepository schwierigkeitsgradRepository;

    public SchwierigkeitsgradController(SchwierigkeitsgradRepository schwierigkeitsgradRepository) {
        this.schwierigkeitsgradRepository = schwierigkeitsgradRepository;
    }

    @PostMapping
    public Schwierigkeitsgrad neueSchwierigkeitsgrad(@RequestBody Schwierigkeitsgrad schwierigkeitsgrad) {
        return schwierigkeitsgradRepository.save(schwierigkeitsgrad);
    }
}