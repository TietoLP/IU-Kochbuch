package com.meinname.kochbuch.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwort;

    @Column(nullable = false, unique = true)
    private String mailadresse;

    @OneToMany(mappedBy = "nutzer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rezept> rezepte = new ArrayList<>();

    @OneToMany(mappedBy = "nutzer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Kommentar> kommentare = new ArrayList<>();

    @OneToMany(mappedBy = "nutzer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorit> favoriten = new ArrayList<>();

    // Standardkonstruktor
    public Nutzer() {
    }

    // Konstruktor ohne ID und Listen
    public Nutzer(String username, String passwort, String mailadresse) {
        this.username = username;
        this.passwort = passwort;
        this.mailadresse = mailadresse;
    }

    // Getter und Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getMailadresse() {
        return mailadresse;
    }

    public void setMailadresse(String mailadresse) {
        this.mailadresse = mailadresse;
    }

    public List<Rezept> getRezepte() {
        return rezepte;
    }

    public void setRezepte(List<Rezept> rezepte) {
        this.rezepte = rezepte;
    }

    public List<Kommentar> getKommentare() {
        return kommentare;
    }

    public void setKommentare(List<Kommentar> kommentare) {
        this.kommentare = kommentare;
    }

    public List<Favorit> getFavoriten() {
        return favoriten;
    }

    public void setFavoriten(List<Favorit> favoriten) {
        this.favoriten = favoriten;
    }
}
