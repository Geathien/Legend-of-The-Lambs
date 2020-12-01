package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Bugbear implements Creature{
    RandomNumberGenerator rng= new RandomNumberGenerator();
    @Override
    public ChallengeRating getCR() {
        return ChallengeRating.CR5;
    }

    @Override
    public int getHP() {
        return 34;
    }

    @Override
    public int getAC() {
        return 18;
    }

    @Override
    public String getName() {
        return "Bugbear";
    }

    public int dropGold(){
        return 20;
    }
    public int attack(){
        return rng.generateRandomNumber(20)+5;
    }
    public int damage(){
        return rng.generateRandomNumber(10)+4;
    }
    public void swordDance(){
        int a1 = attack();
        int a2 = attack();
        int d1 = damage();
        int d2 = damage();
        System.out.println("Bugbear sword dance attack: "+a1+", "+a2+", damage: "+d1+", "+d2);
    }

}
