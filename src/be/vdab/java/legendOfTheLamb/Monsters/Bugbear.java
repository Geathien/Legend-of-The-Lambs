package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class Bugbear implements Creature{
    transient RandomNumberGenerator rng= new RandomNumberGenerator();
    Player player;
    int d1;
    int d2;
    int dice ;
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
        this.dice = rng.generateRandomNumber(12);
        int attack=0;
        if (dice >= 9) {
            attack = swordDance();
            System.out.println("used sword dance");
        }else{
            attack=rng.generateRandomNumber(20)+5;
            System.out.println("used sword attack");
        }
        return attack;
    }
    public int damage(){
        int damage=0;
        if (this.dice >= 9){
            damage = swordDanceDamage();
        }else{
            damage = rng.generateRandomNumber(10)+4;
        }

         return damage;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }
    public int swordDanceDamage(){
      return this.d1+this.d2;
    }
    public int swordDance(){
        int a1 = rng.generateRandomNumber(20)+5;
        int a2 = rng.generateRandomNumber(20)+5;
        if (a1 >= player.getAC()){
            this.d1 = rng.generateRandomNumber(10)+4;
        }else{this.d1=0;}
        if (a2 >= player.getAC()){
            this.d2 = rng.generateRandomNumber(10)+4;
        }else{this.d2=0;}
        if (a1 >= player.getAC()||a2 >= player.getAC()){
        return 99;}else {
            return 0;
        }
    }

}
