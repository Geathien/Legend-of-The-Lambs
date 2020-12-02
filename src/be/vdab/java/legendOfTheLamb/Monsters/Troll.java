package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Troll implements Creature{
    RandomNumberGenerator rng= new RandomNumberGenerator();
    int dice;
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
        this.dice= rng.generateRandomNumber(10);
        int attack=0 ;
        if(dice>=8){
            System.out.println("The troll attacks you with a heavy blow");
        attack=heavyBlow();
        }
        else{
            System.out.println("The troll attacks you with a club");
        attack= rng.generateRandomNumber(20)+5;
        }
        return attack;
    }
    public int damage(){
        int damage=0 ;
        if(dice>=8){
            damage=heavyBlowDamage();
        }
        else{
            damage= rng.generateRandomNumber(10)+4;
        }
        return damage;
    }

    @Override
    public void setPlayer(Player player) {

    }

    public int heavyBlow(){
        return (rng.generateRandomNumber(20)/2)+(rng.generateRandomNumber(20)/2)+7;
    }
    public int heavyBlowDamage(){
        return rng.generateRandomNumber(10)+rng.generateRandomNumber(10)+4;
    }

}
