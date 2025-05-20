package com.meinname.kochbuch.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bewertung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nutzer_id", nullable = false)
    private Nutzer nutzer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rezept_id", nullable = false)
    private Rezept rezept;

    @Column(nullable = false)
    private Integer sterne;

    // Konstruktoren
    public Bewertung() {}

    public Bewertung(Nutzer nutzer, Rezept rezept, Integer sterne) {
        this.nutzer = nutzer;
        this.rezept = rezept;
        this.sterne = sterne;
    }

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getSterne() {
        return sterne;
    }

    public void setSterne(Integer sterne) {
        this.sterne = sterne;
    }
}
