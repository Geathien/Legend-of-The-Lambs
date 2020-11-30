package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Sword implements Weapon{
    RandomNumberGenerator RNG = new RandomNumberGenerator();

    public Sword(){

    }

    @Override
    public String weapon() {
        return "Sword";
    }

//    @Override
//    public int attack() {
//        return RNG.generateRandomNumber(21) + (int)Math.floor(player.getLvl()/2) + player.getStrength();
//    }
//
//    @Override
//    public int damage() {
//        return RNG.generateRandomNumber(11) + player.getStrength();
//    }

    @Override
    public String description() {
        return "A sharpened piece of steelwith a little wooden handle.Lethal how ever you look at it.";
    }
}
