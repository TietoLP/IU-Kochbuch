package com.meinname.kochbuch.model;

import jakarta.persistence.*;

@Entity
public class Favorit {

    @EmbeddedId
    private FavoritId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("nutzerId")
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("rezeptId")
    @JoinColumn(name = "rezept_id")
    private Rezept rezept;

    // Default-Konstruktor
    public Favorit() {}

    // Convenience-Konstruktor
    public Favorit(Nutzer nutzer, Rezept rezept) {
        this.nutzer = nutzer;
        this.rezept = rezept;
        this.id = new FavoritId(nutzer.getId(), rezept.getId());
    }

    public FavoritId getId() {
        return id;
    }

    public void setId(FavoritId id) {
        this.id = id;
    }

    public Nutzer getNutzer() {
        return nutzer;
    }

    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
        if (id == null) id = new FavoritId();
        id.setNutzerId(nutzer.getId());
    }

    public Rezept getRezept() {
        return rezept;
    }

    public void setRezept(Rezept rezept) {
        this.rezept = rezept;
        if (id == null) id = new FavoritId();
        id.setRezeptId(rezept.getId());
    }
}
