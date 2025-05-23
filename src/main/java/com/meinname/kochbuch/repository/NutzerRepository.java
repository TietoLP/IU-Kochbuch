package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Nutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutzerRepository extends JpaRepository<Nutzer, Long> {}