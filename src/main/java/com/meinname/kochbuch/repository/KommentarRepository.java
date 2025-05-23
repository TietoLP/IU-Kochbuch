package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Kommentar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommentarRepository extends JpaRepository<Kommentar, Long> {}