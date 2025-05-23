package com.meinname.kochbuch.dto;

import java.util.ArrayList;
import java.util.List;

import com.meinname.kochbuch.model.Bewertung;
import com.meinname.kochbuch.model.Kategorie;
import com.meinname.kochbuch.model.Kommentar;
import com.meinname.kochbuch.model.Nutzer;
import com.meinname.kochbuch.model.Schwierigkeitsgrad;
import com.meinname.kochbuch.model.Zutat;

// Klasse um Loop zwischen Rezept-Nutzer zu verhindern

public class RezeptDTO {
    private Long id;
    private String titel;
    private List<Kategorie> kategorien = new ArrayList<>();
    private List<Zutat> zutaten = new ArrayList<>();
    private String beschreibung;
    private Integer zeitaufwand;
    private Schwierigkeitsgrad schwierigkeitsgrad;
    private List<String> bilder = new ArrayList<>();
    private Long nutzer;
    private List<KommentarDTO> kommentare = new ArrayList<>();
    private List<BewertungDTO> bewertungen = new ArrayList<>();

    // Getter & Setter
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public List<Kategorie> getKategorien() {
        return kategorien;
    }

    public void setKategorien(List<Kategorie> kategorien) {
        this.kategorien = kategorien;
    }

    public List<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(List<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Integer getZeitaufwand() {
        return zeitaufwand;
    }

    public void setZeitaufwand(Integer zeitaufwand) {
        this.zeitaufwand = zeitaufwand;
    }

    public Schwierigkeitsgrad getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    public void setSchwierigkeitsgrad(Schwierigkeitsgrad schwierigkeitsgrad) {
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }

    public List<String> getBilder() {
        return bilder;
    }

    public void setBilder(List<String> bilder) {
        this.bilder = bilder;
    }

    public Long getNutzer() {
        return nutzer;
    }

    public void setNutzer(Long nutzer) {
        this.nutzer = nutzer;
    }

    public List<KommentarDTO> getKommentare() {
        return kommentare;
    }

    public void setKommentare(List<KommentarDTO> kommentare) {
        this.kommentare = kommentare;
    }

    public List<BewertungDTO> getBewertungen() {
        return bewertungen;
    }

    public void setBewertungen(List<BewertungDTO> bewertungen) {
        this.bewertungen = bewertungen;
    }
}
