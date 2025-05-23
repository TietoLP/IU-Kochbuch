package com.meinname.kochbuch.model;

import jakarta.persistence.*;

@Entity
public class Einheit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String abkürzung;

    private String typ;

    // Standardkonstruktor
    public Einheit() {
    }

    // Konstruktor mit allen Feldern außer ID
    public Einheit(String name, String abkürzung, String typ) {
        this.name = name;
        this.abkürzung = abkürzung;
        this.typ = typ;
    }

    // Getter und Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbkürzung() {
        return abkürzung;
    }

    public void setAbkürzung(String abkürzung) {
        this.abkürzung = abkürzung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
