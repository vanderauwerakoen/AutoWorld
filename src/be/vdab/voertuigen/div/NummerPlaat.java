package be.vdab.voertuigen.div;

import java.io.Serializable;
import java.util.Objects;

public class NummerPlaat implements Serializable,Comparable<String> {


    private String plaat;

    public NummerPlaat(String plaat) {
        this.plaat=plaat;
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NummerPlaat that = (NummerPlaat) o;
        return Objects.equals(plaat, that.plaat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plaat);
    }

    @Override
    public String toString() {
        return "NummerPlaat{" +
                "plaat='" + plaat + '\'' +
                '}';
    }

    @Override
    public int compareTo(String p) {
        return getPlaat().compareTo(p);
    }
}