package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class HobbGoblin implements Creature{
    RandomNumberGenerator rng= new RandomNumberGenerator();
    @Override
    public ChallengeRating getCR() {
        return ChallengeRating.CR4;
    }

    @Override
    public int getHP() {
        return 25;
    }

    @Override
    public int getAC() {
        return 18;
    }

    @Override
    public String getName() {
        return "HobbGoblin";
    }

    public int dropGold(){
        return 10;
    }
    public int attack(){
        return rng.generateRandomNumber(20)+4;
    }
    public int damage(){
        return rng.generateRandomNumber(8)+3;
    }
}
