package com.meinname.kochbuch.kochbuch;

import jakarta.persistence.*;

@Entity
@Table(name = "rezepte")
public class Rezept {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String titel;
    private Kategorie kategorie;
    private Zutat[] zutaten;
    private String beschreibung;
    private int zeitaufwand;
    private Schwierigkeitsgrad schwierigkeitsgrad;
    private String bild;
    private Nutzer nutzer;
    private Kommentar[] kommentare;

    // Standard-Konstruktor (für JPA notwendig)
    public Rezept() {}

    public Rezept(String name) {
        this.name = name;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
