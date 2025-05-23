package com.meinname.kochbuch.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritId implements Serializable {

    private Long nutzerId;
    private Long rezeptId;

    public FavoritId() {}

    public FavoritId(Long nutzerId, Long rezeptId) {
        this.nutzerId = nutzerId;
        this.rezeptId = rezeptId;
    }

    public Long getNutzerId() {
        return nutzerId;
    }

    public void setNutzerId(Long nutzerId) {
        this.nutzerId = nutzerId;
    }

    public Long getRezeptId() {
        return rezeptId;
    }

    public void setRezeptId(Long rezeptId) {
        this.rezeptId = rezeptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoritId that)) return false;
        return Objects.equals(nutzerId, that.nutzerId)
            && Objects.equals(rezeptId, that.rezeptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nutzerId, rezeptId);
    }
}
