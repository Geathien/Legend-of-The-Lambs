package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class RangerAbility implements Ability {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    KeyboardUtility keyboard = new KeyboardUtility();
    int playerLvl;
    Player player;

    public RangerAbility(Player player){
        setPlayer(player);
        checkLvl();
    }

    private void setPlayer(Player player){
        this.player = player;
    }

    private void checkLvl(){
        this.playerLvl = player.getLvl();
    }

    @Override
    public void showAbilities() {
        System.out.println("Abilities:");
        switch (playerLvl){
            case 5:
                System.out.println("1. Sword attack");
                System.out.println("2. Bow Attack");
                System.out.println("3. Piercing shot. You shoot your arrow with much more power.");
                System.out.println("4. Seeker Shot. You loosely shoot an arrow that can not miss.");
                System.out.println("5. Arrow Rain. You shoot an arrow in the air that explodes and rains down arrows on all enemies.");
                break;
            case 4:
                System.out.println("1. Sword attack");
                System.out.println("2. Bow Attack");
                System.out.println("3. Piercing shot. You shoot your arrow with much more power.");
                System.out.println("4. Seeker Shot. You loosely shoot an arrow that can not miss.");
                break;
            case 3:
                System.out.println("1. Sword attack");
                System.out.println("2. Bow Attack");
                System.out.println("3. Piercing shot. You shoot you arrow with much more power.");
                break;
            case 2:
            case 1:
                System.out.println("1. Sword attack");
                System.out.println("2. Bow Attack");
                break;
        }

    }

    private int swordDamage() {
        return rng.generateRandomNumber(10) + (int) Math.floor((player.getStrength()-10)/2);
    }
    private int swordAttack() {
        return rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getStrength()-10)/2);
    }
    private int bowDamage() {
        return rng.generateRandomNumber(12) + (int) Math.floor((player.getDexterity()-10)/2);
    }
    private int bowAttack() {
        return rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getDexterity()-10)/2);
    }
    private int piercingShotDamage(){
        return rng.generateRandomNumber(12) + (int) Math.floor((player.getDexterity()-10)/2)*2;
    }
    private int piercingShotAttack(){
        return rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getDexterity()-10)/2);
    }
    private int seekerShotDamage(){
        int damage = rng.generateRandomNumber(12) + (int) Math.floor((player.getDexterity()-10)/2);
        return (int) Math.floor(damage/2);
    }
    private int arrowRainDamage(){
        return rng.generateRandomNumber(10) + (int) Math.floor((player.getDexterity()-10)/2);
    }

    @Override
    public void chooseAbility() {
        int choice = keyboard.askForNumber();
        switch (choice){
            case 1:
                System.out.println("Sword attack: "+swordAttack()+", damage: "+swordDamage());
                break;
            case 2:
                System.out.println("Bow attack: "+ bowAttack()+", damage: "+bowDamage());
                break;
            case 3:
                System.out.println("Piercing shot: "+ piercingShotAttack()+", damage: "+ piercingShotDamage());
                break;
            case 4:
                System.out.println("Seeker shot: always hit"+", damage: "+seekerShotDamage());
                break ;
            case 5:
                System.out.println("Arrow rain: "+ bowAttack()+", damage: "+arrowRainDamage());
                break;
        }

    }
}
