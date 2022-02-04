package csakennijottunk.Game;

public class FajInstance {



    public Fajok.Faj base;
    public float hungerLvl;
    public float thirstLvl;
    public float evolution;


    public FajInstance(Fajok.Faj base) {
        this.base = base;
        hungerLvl = 1;
        thirstLvl = 1;
        evolution = 0;
    }
}
