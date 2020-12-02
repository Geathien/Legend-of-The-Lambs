package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.Monsters.Creature;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class RangerAbility implements Ability {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    KeyboardUtility keyboard = new KeyboardUtility();
    int choice;
    int playerLvl;
    int playerHP;
    int creatureHP;
    Player player;
    Creature creature;

    public RangerAbility(Player player){
        setPlayer(player);
        checkLvl();
    }

    private void setPlayer(Player player){
        this.player = player;
        this.playerHP = player.getHP();
    }

    public void checkLvl(){
        this.playerLvl = player.getLvl();
    }

    @Override
    public int getCreatureHP() {
        return this.creatureHP;
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

    private boolean swordAttack() {
        int attack= rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getStrength()-10)/2);
        int damage=rng.generateRandomNumber(10) + (int) Math.floor((player.getStrength()-10)/2);
        if (attack>= creature.getAC()){
            this.creatureHP-= damage;
            System.out.println("You dealt "+damage+" damage");
        }else{
            System.out.println("You missed");
        }
        return true;
    }


    private boolean bowAttack() {
        int attack= rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getDexterity()-10)/2);
        int damage= rng.generateRandomNumber(12) + (int) Math.floor((player.getDexterity()-10)/2);
        if (attack>= creature.getAC()){
            this.creatureHP-= damage;
            System.out.println("You dealt "+damage+" damage");
        }else{
            System.out.println("You missed");
        }
        return true;
    }

    private boolean piercingShot(){
        int attack = rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getDexterity()-10)/2);
        int damage = rng.generateRandomNumber(12) + (int) Math.floor((player.getDexterity()-10)/2)*2;
        if (attack>= creature.getAC()){
            this.creatureHP-= damage;
            System.out.println("You dealt "+damage+" damage");
        }else{
            System.out.println("You missed");
        }
        return true;
    }
    private boolean seekerShot(){
        int damage = rng.generateRandomNumber(12) + (int) Math.floor((player.getDexterity()-10)/2);
        this.creatureHP-= (int) Math.floor(damage/2);
        System.out.println("You dealt "+(int)Math.floor(damage/2)+" damage");
        return true;
    }
    private boolean arrowRain(){
        int attack= rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getDexterity()-10)/2);
        int damage= rng.generateRandomNumber(10) + (int) Math.floor((player.getDexterity()-10)/2);
        if (attack>= creature.getAC()){
            this.creatureHP-= damage;
            System.out.println("You dealt "+damage+" damage");
        }else{
            System.out.println("You missed");
        }
        return true;
    }

    @Override
    public void chooseAbility(int choice) {
       this.choice = choice;
       boolean check= false;
        switch (choice){
            case 1:
                check=swordAttack();
                break;
            case 2:
                check=bowAttack();
                break;
            case 3:
                if(playerLvl<3){
                    System.out.println("You don't have the required level, choose another ability from above");
                    break;
                }
                check = piercingShot();
                break;
            case 4:
                if(playerLvl<4){
                    System.out.println("You don't have the required level, choose another ability from above");
                    break;
                }
                check=seekerShot();
                break ;
            case 5:if(playerLvl<5){
                System.out.println("You don't have the required level, choose another ability from above");
                break;
                }
                check=arrowRain();
                break;
        }
        if(!check){int choice2= keyboard.askForNumber();
        chooseAbility(choice2);}
    }
    public void setPlayerHP(int HP){
        this.playerHP=HP;
    }
    public int getPlayerHP(){
        return playerHP;
    }


    @Override
    public void setCreature(Creature creature) {
        this.creature= creature;
        this.creatureHP = creature.getHP();
    }
}
