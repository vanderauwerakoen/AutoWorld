package be.vdab.voertuigen;

import be.vdab.voertuigen.div.NummerPlaat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class PersonenWagen extends Voertuigen implements Serializable {
    private int zitPlaatsen=1;

    public int getZitPlaatsen() {
        return zitPlaatsen;
    }

    public PersonenWagen(String merk, BigDecimal aankoopPrijs, int zitPlaatsen) {
        super(merk, aankoopPrijs);
        this.setZitPlaatsen (zitPlaatsen);
    }

    public void setZitPlaatsen(int zitPlaatsen) {
        if( zitPlaatsen<=0)
        ;
        else
        this.zitPlaatsen = zitPlaatsen;
    }

    @Override
    public String toString() {
        return "PersonenWagen{" + super.toString() +
                "zitPlaatsen=" + zitPlaatsen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonenWagen that = (PersonenWagen) o;
        return zitPlaatsen == that.zitPlaatsen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zitPlaatsen);
    }

}
