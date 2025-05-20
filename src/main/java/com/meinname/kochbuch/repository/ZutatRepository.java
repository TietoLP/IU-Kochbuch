package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Zutat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZutatRepository extends JpaRepository<Zutat, Long> {}