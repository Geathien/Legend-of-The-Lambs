package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class GoblinMinion implements Creature{
    transient RandomNumberGenerator rng= new RandomNumberGenerator();
    @Override
    public ChallengeRating getCR() {
        return ChallengeRating.CR0;
    }

    @Override
    public int getHP() {
        return 1;
    }

    @Override
    public int getAC() {
        return 13;
    }

    @Override
    public String getName() {
        return "Goblin Minion";
    }

    public int dropGold(){
        return 5;
    }
    public int attack(){
        return rng.generateRandomNumber(20)+3;
    }
    public int damage(){
        return rng.generateRandomNumber(4)+2;
    }

    @Override
    public void setPlayer(Player player) {

    }
}
