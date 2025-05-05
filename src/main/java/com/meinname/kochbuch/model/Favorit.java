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

    @Column(name = "favorisiert_am")
    private java.time.LocalDateTime favorisiertAm = java.time.LocalDateTime.now();

    // Getter, Setter, Konstruktoren
}