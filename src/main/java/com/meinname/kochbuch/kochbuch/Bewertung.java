package com.meinname.kochbuch.kochbuch;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@IdClass(BewertungKey.class)
public class Bewertung {

    @Id
    @ManyToOne
    private Nutzer nutzer;

    @Id
    @ManyToOne
    private Rezept rezept;

    @Column(nullable = false)
    private Integer sterne;

    @Column(name = "bewertet_am")
    private java.time.LocalDateTime bewertetAm = java.time.LocalDateTime.now();

    // Getter, Setter, Konstruktoren
}

