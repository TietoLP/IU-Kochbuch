package com.meinname.kochbuch.kochbuch;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kommentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    @ManyToOne
    private Nutzer nutzer;

    @ManyToOne
    private Rezept rezept;

    @Column(name = "kommentiert_am")
    private java.time.LocalDateTime kommentiertAm = java.time.LocalDateTime.now();

    // Getter, Setter, Konstruktoren
}
