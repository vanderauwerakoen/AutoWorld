package be.vdab.util;

import be.vdab.voertuigen.div.Maat;

import java.io.Serializable;
import java.util.Objects;

public class Volume implements Serializable,Comparable<Volume> {
     private int breedte , hoogte, diepte;
     private Maat maat;

     public Volume(int breedte, int hoogte, int diepte, Maat maat) {
          setBreedte(breedte);
          setHoogte( hoogte);
          setDiepte( diepte);
          this.maat = maat;
     }

     public int getBreedte() {
          return breedte;
     }

     private void setBreedte(int breedte) {
          if(breedte<0)
               throw new VolumeException("breedte kan niet negatief zijn");
          this.breedte = breedte;
     }

     public int getHoogte() {
          return hoogte;
     }

     private void setHoogte(int hoogte) {
          if(hoogte<0)
               throw new VolumeException("hoogte kan niet negatief zijn");
          this.hoogte=hoogte;
     }

     private void setDiepte(int diepte) {
          if(diepte<0)
               throw new VolumeException("diepte kan niet negatief zijn");
          this.diepte = diepte;
     }

     public Maat getMaat() {
          return maat;
     }

     private void setMaat(Maat maat) {
          this.maat = maat;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Volume volume = (Volume) o;
          return breedte == volume.breedte && hoogte == volume.hoogte && diepte == volume.diepte && maat == volume.maat;
     }

     @Override
     public int hashCode() {
          return Objects.hash(breedte, hoogte, diepte, maat);
     }

     public double getVolume(){
          return diepte*hoogte*breedte;
     }

     @Override
     public int compareTo(Volume o) {
          return (int)(this.getVolume()-o.getVolume());
     }

     @Override
     public String toString() {
          return "Volume{" +
                  "breedte=" + breedte +
                  ", hoogte=" + hoogte +
                  ", diepte=" + diepte +
                  ", maat=" + maat +
                  '}';
     }
}
