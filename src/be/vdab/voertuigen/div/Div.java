package be.vdab.voertuigen.div;

public enum Div {
    INSTANCE;
    private int nummer=1;

    public NummerPlaat getNummerPlaat(){
        String plaat= String.format("i-AAA-%03d",nummer++);
        if (nummer>=999)
            nummer=1;
        return new NummerPlaat(plaat);
    }

}
