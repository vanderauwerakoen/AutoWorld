package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.NummerPlaat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Voertuigen implements Serializable,Comparable<Voertuigen> {
    private NummerPlaat nummerPlaat= Div.INSTANCE.getNummerPlaat();
    private String merk="";
    private BigDecimal aankoopPrijs=new BigDecimal(0);

    public Voertuigen(String merk, BigDecimal aankoopPrijs) {
        setMerk(merk);
        setAankoopPrijs(aankoopPrijs);
    }

    public NummerPlaat getNummerPlaat() {
        return nummerPlaat;
    }

    public void setMerk(String merk) {
        if (merk.equals(null))
            ;
        else
        this.merk = merk;
    }

    public void setAankoopPrijs(BigDecimal aankoopPrijs) {
        if ((aankoopPrijs ).intValue()<0)
            this.aankoopPrijs=BigDecimal.valueOf(0 );
        else
            this.aankoopPrijs=aankoopPrijs;
    }

    @Override
    public String toString() {
        return "Voertuigen{" +
                "nummerPlaat=" + nummerPlaat +
                ", merk='" + merk + '\'' +
                ", aankoopPrijs=" + aankoopPrijs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voertuigen that = (Voertuigen) o;
        return nummerPlaat.equals(that.nummerPlaat) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummerPlaat, merk, aankoopPrijs);
    }

    public String getMerk() {
        return merk;
    }

    public BigDecimal getAankoopPrijs() {
        return aankoopPrijs;
    }



    @Override
    public int compareTo(Voertuigen o) {
        return this.nummerPlaat.getPlaat().compareTo(o.nummerPlaat.getPlaat());
    }
}
