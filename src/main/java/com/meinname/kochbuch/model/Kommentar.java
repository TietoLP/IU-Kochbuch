package com.meinname.kochbuch.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Kommentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nutzer_id", nullable = false)
    private Nutzer nutzer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rezept_id", nullable = false)
    private Rezept rezept;

    @Column(name = "kommentiert_am", nullable = false)
    private LocalDateTime kommentiertAm = LocalDateTime.now();

    // Standardkonstruktor
    public Kommentar() {
    }

    // Konstruktor ohne ID
    public Kommentar(String text, Nutzer nutzer, Rezept rezept) {
        this.text = text;
        this.nutzer = nutzer;
        this.rezept = rezept;
        this.kommentiertAm = LocalDateTime.now();
    }

    // Getter und Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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

    public LocalDateTime getKommentiertAm() {
        return kommentiertAm;
    }

    public void setKommentiertAm(LocalDateTime kommentiertAm) {
        this.kommentiertAm = kommentiertAm;
    }
}
