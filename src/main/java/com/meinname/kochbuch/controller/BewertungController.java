package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.dto.BewertungDTO;
import com.meinname.kochbuch.dto.KommentarDTO;
import com.meinname.kochbuch.dto.RezeptDTO;
import com.meinname.kochbuch.model.Bewertung;
import com.meinname.kochbuch.model.Kommentar;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.repository.BewertungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/bewertung")
public class BewertungController {

    private final BewertungRepository bewertungRepo;

    public BewertungController(BewertungRepository bewertungRepository) {
        this.bewertungRepo = bewertungRepository;
    }

    @GetMapping
    public List<BewertungDTO> getAlleBewertungen() {
        return bewertungRepo.findAll().stream()
            .map(BewertungController::convertToDTO)
            .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public BewertungDTO getBewertungById(@PathVariable Long id) {
    	Bewertung bewertung = bewertungRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Bewertung mit ID " + id + " nicht gefunden"));
    	return convertToDTO(bewertung);
    }

    @PostMapping
    public Bewertung neueBewertung(@RequestBody Bewertung bewertung) {
        return bewertungRepo.save(bewertung);
    }
    
    @DeleteMapping("/{id}")
    public void bewertungLoeschen(@PathVariable Long id) {
    	bewertungRepo.deleteById(id);
    }

    // Hilfsmethode: Rezept → DTO konvertieren
    public static BewertungDTO convertToDTO(Bewertung bewertung) {
    	BewertungDTO dto = new BewertungDTO(bewertung.getId(), bewertung.getNutzer().getId(), bewertung.getRezept().getId(), bewertung.getSterne());
        return dto;
    }
}