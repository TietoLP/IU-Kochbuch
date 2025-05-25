package com.meinname.kochbuch.controller;

import com.meinname.kochbuch.dto.RezeptDTO;
import com.meinname.kochbuch.model.Rezept;
import com.meinname.kochbuch.model.Zutat;
import com.meinname.kochbuch.repository.RezeptRepository;
import com.meinname.kochbuch.repository.ZutatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rezept")
public class RezeptController {

    @Autowired
    private RezeptRepository rezeptRepo;

    @Autowired
    private ZutatRepository zutatRepo;

    @GetMapping
    public List<RezeptDTO> getAlleRezepte() {
        return rezeptRepo.findAll().stream()
            .map(RezeptController::convertToDTO)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RezeptDTO getRezeptById(@PathVariable Long id) {
        Rezept rezept = rezeptRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Rezept mit ID " + id + " nicht gefunden"));
        return convertToDTO(rezept);
    }

    // Hiermit kann man Rezepte auch ohne ausformulierte Zutaten hinzufügen. Hier reichen die Zutaten-Ids
    @PostMapping
    public Rezept neuesRezept(@RequestBody Rezept rezept) {
        List<Zutat> zutatenListe = rezept.getZutaten().stream()
            // Expliziter Typ für die Lambda-Variable
            .map(zutat -> {
                Zutat gefundeneZutat = zutatRepo.findById(zutat.getId().longValue())
                    .orElseThrow(() -> new RuntimeException("Zutat nicht gefunden: " + zutat.getId()));
                return gefundeneZutat;
            })
            .collect(Collectors.toList()); // Verwende collect(Collectors.toList())
        
        rezept.setZutaten(zutatenListe);
        return rezeptRepo.save(rezept);
    }
    
    // Aktualisiert ein bestehendes Rezept
    @PutMapping("/{id}")
    public Rezept rezeptAktualisieren(@PathVariable Long id, @RequestBody Rezept aktualisiertesRezept) {
        Rezept vorhandenesRezept = rezeptRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Rezept mit ID " + id + " nicht gefunden"));

        // Felder aktualisieren
        vorhandenesRezept.setTitel(aktualisiertesRezept.getTitel());
        vorhandenesRezept.setBeschreibung(aktualisiertesRezept.getBeschreibung());
        vorhandenesRezept.setZeitaufwand(aktualisiertesRezept.getZeitaufwand());
        vorhandenesRezept.setSchwierigkeitsgrad(aktualisiertesRezept.getSchwierigkeitsgrad());
        vorhandenesRezept.setKategorien(aktualisiertesRezept.getKategorien());
        vorhandenesRezept.setBilder(aktualisiertesRezept.getBilder());

        // Zutaten aktualisieren (IDs aus dem Body validieren)
        List<Zutat> neueZutaten = aktualisiertesRezept.getZutaten().stream()
            .map(zutat -> zutatRepo.findById(zutat.getId().longValue())
                .orElseThrow(() -> new RuntimeException("Zutat nicht gefunden: " + zutat.getId())))
            .collect(Collectors.toList());

        vorhandenesRezept.setZutaten(neueZutaten);

        return rezeptRepo.save(vorhandenesRezept);
    }

    @DeleteMapping("/{id}")
    public void rezeptLoeschen(@PathVariable Long id) {
        rezeptRepo.deleteById(id);
    }

    // Hilfsmethode: Rezept → DTO konvertieren
    private static RezeptDTO convertToDTO(Rezept rezept) {
        RezeptDTO dto = new RezeptDTO();
        dto.setId(rezept.getId());
        dto.setTitel(rezept.getTitel());
        dto.setKategorien(rezept.getKategorien());
        dto.setZutaten(rezept.getZutaten());
        dto.setBeschreibung(rezept.getBeschreibung());
        dto.setZeitaufwand(rezept.getZeitaufwand());
        dto.setSchwierigkeitsgrad(rezept.getSchwierigkeitsgrad());
        dto.setBilder(rezept.getBilder());
        dto.setNutzer(rezept.getNutzer() != null ? rezept.getNutzer().getId() : null);
        dto.setKommentare(rezept.getKommentare().stream().map(KommentarController::convertToDTO).collect(Collectors.toList()));
        dto.setBewertungen(rezept.getBewertungen().stream().map(BewertungController::convertToDTO).collect(Collectors.toList()));
        return dto;
    }
}
