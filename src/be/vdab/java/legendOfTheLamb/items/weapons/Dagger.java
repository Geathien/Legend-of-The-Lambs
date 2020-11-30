package be.vdab.java.legendOfTheLamb.items.weapons;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Dagger implements Weapon{
    RandomNumberGenerator RNG = new RandomNumberGenerator();

    public Dagger(){
    }

    @Override
    public String weapon() {
        return "Dagger";
    }

//    @Override
//    public int attack() {
//        int attack = 0;
//        if (player.getCharacterClass().equals(new Fighter())){
//            attack = RNG.generateRandomNumber(21) + (int)Math.floor(player.getLvl()/2) + player.getStrength();
//        } else if (player.getCharacterClass().equals(new Ranger())){
//            attack = RNG.generateRandomNumber(21) + (int)Math.floor(player.getLvl()/2) + player.getDexterity();
//        }
//        return attack;
//    }
//
//    @Override
//    public int damage() {
//        int damage = 0;
//        if (player.getCharacterClass().equals(new Fighter())){
//            damage = RNG.generateRandomNumber(5) + player.getStrength();
//        } else if (player.getCharacterClass().equals(new Ranger())){
//            damage = RNG.generateRandomNumber(5) + player.getDexterity();
//        }
//        return damage;
//    }

    @Override
    public String description() {
        return "A small knife that can be used in different situations.";
    }
}
