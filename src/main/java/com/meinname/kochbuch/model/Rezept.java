package com.meinname.kochbuch.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rezept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titel;

    @ManyToMany
    @JoinTable(
        name = "rezept_kategorie",
        joinColumns = @JoinColumn(name = "rezept_id"),
        inverseJoinColumns = @JoinColumn(name = "kategorie_id")
    )
    private List<Kategorie> kategorien = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "rezept_zutat",
        joinColumns = @JoinColumn(name = "rezept_id"),
        inverseJoinColumns = @JoinColumn(name = "zutat_id")
    )
    private List<Zutat> zutaten = new ArrayList<>();

    @Column(length = 2000)
    private String beschreibung;

    private Integer zeitaufwand; // in Minuten z. B.

    @ManyToOne
    @JoinColumn(name = "schwierigkeitsgrad_id")
    private Schwierigkeitsgrad schwierigkeitsgrad;

    // Bilder – Liste von Pfaden oder URLs als JSON speichern (siehe Hinweis unten)
    @ElementCollection
    @CollectionTable(name = "rezept_bilder", joinColumns = @JoinColumn(name = "rezept_id"))
    @Column(name = "bild_url")
    private List<String> bilder = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

    @OneToMany(mappedBy = "rezept", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Kommentar> kommentare = new ArrayList<>();

    @OneToMany(mappedBy = "rezept", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bewertung> bewertungen = new ArrayList<>();

    // Konstruktoren
    public Rezept() {}

    public Rezept(String titel) {
        this.titel = titel;
    }

    // Getter & Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Nutzer getNutzer() {
        return nutzer;
    }

    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }

    public List<Kommentar> getKommentare() {
        return kommentare;
    }

    public void setKommentare(List<Kommentar> kommentare) {
        this.kommentare = kommentare;
    }

    public List<Bewertung> getBewertungen() {
        return bewertungen;
    }

    public void setBewertungen(List<Bewertung> bewertungen) {
        this.bewertungen = bewertungen;
    }
}
