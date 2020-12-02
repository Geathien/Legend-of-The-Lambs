package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Wolf implements Creature{
    RandomNumberGenerator rng= new RandomNumberGenerator();
    @Override
    public ChallengeRating getCR() {
        return ChallengeRating.CR2;
    }

    @Override
    public int getHP() {
        return 40;
    }

    @Override
    public int getAC() {
        return 19;
    }

    @Override
    public String getName() {
        return "Wolf";
    }

    public int dropGold(){
        return 0;
    }
    public int attack(){
        return rng.generateRandomNumber(20)+3;
    }
    public int damage(){
        return rng.generateRandomNumber(6)+3;
    }

    @Override
    public void setPlayer(Player player) {

    }
}
