package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Dagger implements Weapon{


    public Dagger(){
    }

    @Override
    public String weapon() {
        return "Dagger";
    }


    @Override
    public String description() {
        return "A small knife that can be used in different situations.";
    }
}
