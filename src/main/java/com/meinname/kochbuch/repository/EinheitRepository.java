package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Einheit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EinheitRepository extends JpaRepository<Einheit, Long> {}