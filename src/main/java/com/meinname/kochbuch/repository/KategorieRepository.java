package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorieRepository extends JpaRepository<Kategorie, Long> {}