package com.meinname.kochbuch.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bewertung {

    @Id
    @ManyToOne
    @JoinColumn(name = "nutzer_id") // Name der Spalte, die auf die Nutzer-ID verweist
    private Nutzer nutzer;

    @Id
    @ManyToOne
    @JoinColumn(name = "rezept_id") // Name der Spalte, die auf die Rezept-ID verweist
    private Rezept rezept;

    @Column(nullable = false)
    private Integer sterne;

    @Column(name = "bewertet_am")
    private LocalDateTime bewertetAm = LocalDateTime.now();

    // Getter, Setter, Konstruktoren
}
