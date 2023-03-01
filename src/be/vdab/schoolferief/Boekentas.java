package be.vdab.schoolferief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {

    private Volume laadVolume=null;
    private String kleur;

    public Boekentas(Volume laadVolume, String kleur) {
        if (laadVolume==null || kleur ==null)
            throw new IllegalArgumentException();
        this.laadVolume = laadVolume;
        this.kleur = kleur;
    }

    @Override
    public String toString() {
        return "Boekentas{" +
                "laadVolume=" + laadVolume +
                ", kleur='" + kleur + '\'' +
                '}';
    }

    public String getKleur() {
        return kleur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boekentas boekentas = (Boekentas) o;
        return Objects.equals(laadVolume, boekentas.laadVolume) && Objects.equals(kleur, boekentas.kleur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laadVolume, kleur);
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    @Override
    public Volume getLaadvolume() {
        return laadVolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume1) {
        laadVolume=laadvolume1;
    }
}

