package be.vdab.voertuigen.div;

public enum Maat {
    centimeter(100), decimeter(10) , meter(1);
    private final int waardeInMeter;

    Maat(int waardeInMeter){
        this.waardeInMeter=waardeInMeter;
    }


    public int getWaardeInMeter() {
        return waardeInMeter;
    }


}
