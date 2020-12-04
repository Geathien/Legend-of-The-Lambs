package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class HolySymbol implements Weapon {


    public HolySymbol(){

    }

    @Override
    public String weapon() {
        return "Holy Symbol";
    }



    @Override
    public String description() {
        return "An emblem to a god that is imbued with its power. Can be usedto cast various spells that need support off the Wisdom Ability.";
    }
}
