package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class GoblinRanger implements Creature {
    RandomNumberGenerator rng= new RandomNumberGenerator();
    @Override
    public ChallengeRating getCR() {
        return ChallengeRating.CR3;
    }

    @Override
    public int getHP() {
        return 12;
    }

    @Override
    public int getAC() {
        return 15;
    }

    @Override
    public String getName() {
        return "Goblin Ranger";
    }

    public int dropGold(){
        return 5;
    }
    public int attack(){
        return rng.generateRandomNumber(20)+4;
    }
    public int damage(){
        return rng.generateRandomNumber(6)+3;
    }
}
