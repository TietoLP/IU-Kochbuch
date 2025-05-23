package com.meinname.kochbuch.repository;

import com.meinname.kochbuch.model.Favorit;
import com.meinname.kochbuch.model.FavoritId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritRepository extends JpaRepository<Favorit, FavoritId> {}