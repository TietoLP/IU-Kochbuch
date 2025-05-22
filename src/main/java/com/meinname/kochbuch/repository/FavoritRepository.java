package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Favorit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritRepository extends JpaRepository<Favorit, Long> {}