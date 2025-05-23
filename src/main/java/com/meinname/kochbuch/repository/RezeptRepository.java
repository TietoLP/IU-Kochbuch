package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Rezept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezeptRepository extends JpaRepository<Rezept, Long> {}