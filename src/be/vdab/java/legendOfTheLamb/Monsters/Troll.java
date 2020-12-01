package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Troll implements Creature{
    RandomNumberGenerator rng= new RandomNumberGenerator();
    @Override
    public ChallengeRating getCR() {
        return ChallengeRating.CR6;
    }

    @Override
    public int getHP() {
        return 60;
    }

    @Override
    public int getAC() {
        return 19;
    }

    @Override
    public String getName() {
        return "Troll";
    }

    public int dropGold(){
        return 50;
    }
    public int attack(){
        return rng.generateRandomNumber(20)+5;
    }
    public int damage(){
        return rng.generateRandomNumber(10)+4;
    }
    public int heavyBlow(){
        return (rng.generateRandomNumber(20)/2)+(rng.generateRandomNumber(20)/2)+7;
    }
    public int heavyBlowDamage(){
        return rng.generateRandomNumber(10)+rng.generateRandomNumber(10)+4;
    }

}
