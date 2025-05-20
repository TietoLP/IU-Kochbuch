package com.meinname.kochbuch.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Favorit {

    @Id
    @ManyToOne
    @JoinColumn(name = "nutzer_id") // Annahme: Spalte in der favorit-Tabelle
    private Nutzer nutzer;

    @Id
    @ManyToOne
    @JoinColumn(name = "rezept_id") // Annahme: Spalte in der favorit-Tabelle
    private Rezept rezept;

    public Nutzer getNutzer() {
        return nutzer;
    }

    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }

    public Rezept getRezept() {
        return rezept;
    }

    public void setRezept(Rezept rezept) {
        this.rezept = rezept;
    }
}