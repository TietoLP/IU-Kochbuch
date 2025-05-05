package com.meinname.kochbuch.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Einheit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String abkürzung;
    private String typ;

    // Getter, Setter, Konstruktoren
}
