package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

import java.util.Random;

public class FighterAbility implements Ability {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    KeyboardUtility keyboard = new KeyboardUtility();
    int playerLvl;
    Player player;

    public FighterAbility(Player player){
        setPlayer(player);
        checkLvl();
    }

    private void setPlayer(Player player){
        this.player = player;
    }

    private void checkLvl(){
        this.playerLvl = player.getLvl();
    }

    public void showAbilities(){
        System.out.println("Abilities:");
        switch (playerLvl){
            case 5:
                System.out.println("1. Sword attack");
                System.out.println("2. Sword Dance. You can hit your opponent two times per turn.");
                System.out.println("3. Sword Dance Enhanced. You can hit your opponent three times per turn.");
                System.out.println("4. Mighty Zornhau. If you hit the opponent, this acts as an instant kill.");
                break;
            case 4:
                System.out.println("1. Sword attack");
                System.out.println("2. Sword Dance. You can hit your opponent two times per turn.");
                System.out.println("3. Sword Dance Enhanced. You can hit your opponent three times per turn.");
                break;
            case 3:
                System.out.println("1. Sword attack");
                System.out.println("2. Sword Dance. You can hit your opponent two times per turn.");
                break;
            case 2:
            case 1:
                System.out.println("1. Sword attack");
                break;
        }
    }
    private int damage() {
        return rng.generateRandomNumber(10) + (int) Math.floor((player.getStrength()-10)/2);
    }
    private int attack() {
        return rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getStrength()-10)/2);
    }
    private int zornhau(){
        int dice1 = rng.generateRandomNumber(20);
        int dice2 = rng.generateRandomNumber(20);
        System.out.println(dice1 +", "+ dice2);
        int attack = Math.min(dice1, dice2);
        return attack+(int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getStrength()-10)/2);
    }
    public void chooseAbility(){
        int choice = keyboard.askForNumber();
        switch (choice){
            case 1:
                System.out.println("Sword attack: "+attack()+", damage: "+damage());
                break;
            case 2:
                System.out.println("Sword dance: "+attack()+", "+ attack()+", damage: "+damage()+", "+damage());
                break;
            case 3:
                System.out.println("Enhanced sword dance: "+attack()+", "+ attack()+", "+attack()+", damage: "+damage()+", "+damage()+", "+damage());
                break;
            case 4:
                System.out.println("Mighty Zornhau: "+ zornhau());
                break ;
        }
    }
}
