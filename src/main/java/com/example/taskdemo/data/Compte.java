package com.example.taskdemo.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Compte {
    private long compteId;
    private String nom;

    @Id
    @Column(name = "compte_id")
    public long getCompteId() {
        return compteId;
    }

    public void setCompteId(long compteId) {
        this.compteId = compteId;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return compteId == compte.compteId &&
                Objects.equals(nom, compte.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compteId, nom);
    }
}
