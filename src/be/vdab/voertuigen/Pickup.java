package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.math.BigDecimal;
import java.util.Objects;

public class Pickup extends PersonenWagen implements Laadbaar {

    private Volume laadVolume=null;

    public Pickup(String merk, BigDecimal aankoopPrijs, int zitPlaatsen,Volume laadVolume) {
        super(merk, aankoopPrijs, zitPlaatsen);
        setLaadvolume(laadVolume);
    }

    @Override
    public Volume getLaadvolume() {
        return laadVolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume1) {
        laadVolume=laadvolume1;
    }

    @Override
    public String toString() {
        return "Pickup{" + super.toString() +
                "laadVolume=" + laadVolume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pickup pickup = (Pickup) o;
        return Objects.equals(laadVolume, pickup.laadVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laadVolume);
    }
}
