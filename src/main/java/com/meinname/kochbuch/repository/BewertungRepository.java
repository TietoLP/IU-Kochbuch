package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Bewertung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BewertungRepository extends JpaRepository<Bewertung, Long> {}