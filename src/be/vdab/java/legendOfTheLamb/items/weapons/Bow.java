package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Bow implements Weapon {

    public Bow(){

    }

    @Override
    public String weapon() {
        return "Bow";
    }



    @Override
    public String description() {
        return "A piece of wood, stringed with flaxen string. Nothing special, but lethal from a distance.";
    }
}
