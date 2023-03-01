package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.math.BigDecimal;
import java.util.Objects;

public class Vrachtwagen extends Voertuigen implements Laadbaar {

    private Volume laadVolume=null;
    private int maximaalToegelatenMassa;
    private  int aantalAssen;

    public Vrachtwagen(String merk, BigDecimal aankoopPrijs, Volume laadVolume, int maximaalToegelatenMassa, int aantalAssen) {
        super(merk, aankoopPrijs);
        this.laadVolume = laadVolume;
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        this.aantalAssen = aantalAssen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vrachtwagen that = (Vrachtwagen) o;
        return maximaalToegelatenMassa == that.maximaalToegelatenMassa && aantalAssen == that.aantalAssen && Objects.equals(laadVolume, that.laadVolume);
    }

    @Override
    public String toString() {
        return "Vrachtwagen{" + super.toString() +
                "laadVolume=" + laadVolume +
                ", maximaalToegelatenMassa=" + maximaalToegelatenMassa +
                ", aantalAssen=" + aantalAssen +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laadVolume, maximaalToegelatenMassa, aantalAssen);
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
