package com.meinname.kochbuch.kochbuch;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Zutat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // Getter, Setter, Konstruktoren
}
