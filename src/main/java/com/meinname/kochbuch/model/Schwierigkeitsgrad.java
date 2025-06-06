package com.meinname.kochbuch.model;

import jakarta.persistence.*;

@Entity
public class Schwierigkeitsgrad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Entferne das, falls du IDs manuell verwaltest
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    // Standardkonstruktor
    public Schwierigkeitsgrad() {
    }

    // Konstruktor ohne ID
    public Schwierigkeitsgrad(String name) {
        this.name = name;
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
}
