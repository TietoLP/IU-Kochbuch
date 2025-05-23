package com.meinname.kochbuch.dto;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class KommentarDTO {

    private Integer id;
    private String text;
    private Long nutzer;
    private Long rezept;

    // Standardkonstruktor für Jackson
    public KommentarDTO() { }

    // Konstruktor mit ID
    public KommentarDTO(Integer id, String text, Long nutzer, Long rezept) {
        this.id = id;
        this.text = text;
        this.nutzer = nutzer;
        this.rezept = rezept;
    }

    // Getter und Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
}
