package com.meinname.kochbuch.kochbuch;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@IdClass(FavoritKey.class)
public class Favorit {

    @Id
    @ManyToOne
    private Nutzer nutzer;

    @Id
    @ManyToOne
    private Rezept rezept;

    @Column(name = "favorisiert_am")
    private java.time.LocalDateTime favorisiertAm = java.time.LocalDateTime.now();

    // Getter, Setter, Konstruktoren
}
