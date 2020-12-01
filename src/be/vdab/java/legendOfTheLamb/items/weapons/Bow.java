package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Bow implements Weapon {
    RandomNumberGenerator RNG = new RandomNumberGenerator();

    public Bow(){

    }

    @Override
    public String weapon() {
        return "Bow";
    }

//    @Override
//    public int attack() {
//        return RNG.generateRandomNumber(21) + (int)Math.floor(player.getLvl()/2) + player.getDexterity();
//    }
//
//    @Override
//    public int damage() {
//        return RNG.generateRandomNumber(13) + player.getDexterity();
//    }

    @Override
    public String description() {
        return "A piece of wood, stringed with flaxen string. Nothing special, but lethal from a distance.";
    }
}
