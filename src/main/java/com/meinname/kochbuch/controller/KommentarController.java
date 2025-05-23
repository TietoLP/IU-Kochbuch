package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.dto.KommentarDTO;
import com.meinname.kochbuch.dto.RezeptDTO;
import com.meinname.kochbuch.model.Bewertung;
import com.meinname.kochbuch.model.Kommentar;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.repository.KommentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/kommentar")
public class KommentarController {

    private final KommentarRepository kommentarRepo;

    public KommentarController(KommentarRepository kommentarRepository) {
        this.kommentarRepo = kommentarRepository;
    }

    @GetMapping
    public List<KommentarDTO> getAlleKommentarDTO() {
        return kommentarRepo.findAll().stream()
            .map(KommentarController::convertToDTO)
            .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public KommentarDTO getKommentarById(@PathVariable Long id) {
    	Kommentar kommentar = kommentarRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Kommentar mit ID " + id + " nicht gefunden"));
    	return convertToDTO(kommentar);
    }

    @PostMapping
    public Kommentar neueKommentar(@RequestBody Kommentar kommentar) {
        return kommentarRepo.save(kommentar);
    }
    
    @DeleteMapping("/{id}")
    public void kommentarLoeschen(@PathVariable Long id) {
    	kommentarRepo.deleteById(id);
    }

    // Hilfsmethode: Rezept → DTO konvertieren
    public static KommentarDTO convertToDTO(Kommentar kommentar) {
    	KommentarDTO dto = new KommentarDTO(kommentar.getId(), kommentar.getText(), kommentar.getNutzer().getId(), kommentar.getRezept().getId());
        return dto;
    }
}