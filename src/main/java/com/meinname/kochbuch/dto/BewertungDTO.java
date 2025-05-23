package com.meinname.kochbuch.dto;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class BewertungDTO {

    private Long id;
    private Long nutzer;
    private Long rezept;
    private Integer sterne;

    // Konstruktoren
    public BewertungDTO() {}

    public BewertungDTO(Long id, Long nutzer, Long rezept, Integer sterne) {
    	this.id = id;
        this.nutzer = nutzer;
        this.rezept = rezept;
        this.sterne = sterne;
    }

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNutzer() {
        return nutzer;
    }

    public void setNutzer(Long nutzer) {
        this.nutzer = nutzer;
    }

    public Long getRezept() {
        return rezept;
    }

    public void setRezept(Long rezept) {
        this.rezept = rezept;
    }

    public Integer getSterne() {
        return sterne;
    }

    public void setSterne(Integer sterne) {
        this.sterne = sterne;
    }
}
