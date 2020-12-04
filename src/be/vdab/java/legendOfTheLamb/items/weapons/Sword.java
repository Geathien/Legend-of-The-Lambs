package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Sword implements Weapon{

    public Sword(){

    }

    @Override
    public String weapon() {
        return "Sword";
    }


    @Override
    public String description() {
        return "A sharpened piece of steelwith a little wooden handle.Lethal how ever you look at it.";
    }
}
