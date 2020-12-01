package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class HolySymbol implements Weapon {
    RandomNumberGenerator RNG = new RandomNumberGenerator();

    public HolySymbol(){

    }

    @Override
    public String weapon() {
        return "Holy Symbol";
    }

//    @Override
//    public int attack() {
//        return RNG.generateRandomNumber(21) + (int)Math.floor(player.getLvl()/2) + player.getWisdom();
//    }
//
//    @Override
//    public int damage() {
//        return RNG.generateRandomNumber(7) + player.getWisdom();
//    }

    @Override
    public String description() {
        return "An emblem to a god that is imbued with its power. Can be usedto cast various spells that need support off the Wisdom Ability.";
    }
}
