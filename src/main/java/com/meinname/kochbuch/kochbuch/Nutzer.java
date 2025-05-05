package com.meinname.kochbuch.kochbuch;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String passwort;
    private String mailadresse;

    @OneToMany(mappedBy = "nutzer", cascade = CascadeType.ALL)
    private List<Rezept> rezepte = new ArrayList<>();

    @OneToMany(mappedBy = "nutzer", cascade = CascadeType.ALL)
    private List<Kommentar> kommentare = new ArrayList<>();

    @OneToMany(mappedBy = "nutzer", cascade = CascadeType.ALL)
    private List<Favorit> favoriten = new ArrayList<>();

    // Getter, Setter, Konstruktoren
}
