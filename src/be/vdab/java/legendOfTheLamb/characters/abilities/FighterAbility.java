package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.Monsters.Creature;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

import java.util.Random;

public class FighterAbility implements Ability {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    KeyboardUtility keyboard = new KeyboardUtility();
    int playerLvl;
    int choice;
    Player player;
    Creature creature;
    int creatureHP;
    int playerHP;

    public FighterAbility(Player player){
        setPlayer(player);
        checkLvl();
    }

    private void setPlayer(Player player){
        this.player = player;
        this.playerHP=player.getHP();
    }

    public void checkLvl(){
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
    public int damage() {
        return rng.generateRandomNumber(10) + (int) Math.floor((player.getStrength()-10)/2);
    }
    public int attack() {
        return rng.generateRandomNumber(20) + (int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getStrength()-10)/2);
    }

    public void chooseAbility(int choice){
        this.choice = choice;
        boolean check = false;
        switch (choice){
            case 1:
                check=swordAttack();
                break;
            case 2:if(playerLvl<3){
                System.out.println("You don't have the required level, choose another ability from above");
                break;
            }
                check=swordDance();
                break;
            case 3:if(playerLvl<4){
                System.out.println("You don't have the required level, choose another ability from above");
                break;
            }
                check=enhancedSwordDance();
                break;
            case 4:
                if(playerLvl<5){
                System.out.println("You don't have the required level, choose another ability from above");
                break;
            }
                check=zornhau();
                break ;
            case 5:
                System.out.println("You don't have a fifth ability, u poor thing");
                break ;
        }
        if(!check) {int choice2= keyboard.askForNumber();
        chooseAbility(choice2);}
    }
    private boolean swordAttack(){
        int attack= attack();
        boolean bool=false;
        if (attack>= creature.getAC()){
            int playerDamage = damage();
            System.out.println("You dealt "+playerDamage+" damage");
            this.creatureHP -= playerDamage;
            }
        bool=true;
        return bool;
    }
    private boolean swordDance(){
        int attack1= attack();
        boolean bool=false;
        if (attack1>= creature.getAC()){
            int playerDamage = damage();
            System.out.println("First attack hit for "+playerDamage+" damage");
            this.creatureHP -= playerDamage;
        }
        else {
            System.out.println("First attack missed");
        }
        int attack2= attack();
            if (attack2>= creature.getAC()){
                int playerDamage = damage();
                System.out.println("Second attack hit for "+playerDamage+" damage");
                this.creatureHP -= playerDamage;
            }
            else {
                System.out.println("Second attack missed");
            }
        bool=true;
            return bool;
        }
    private boolean enhancedSwordDance(){
        int attack1= attack();
        boolean bool=false;
        if (attack1>= creature.getAC()){
            int playerDamage = damage();
            System.out.println("First attack hit for "+playerDamage+" damage");
            this.creatureHP -= playerDamage;
        }
        else {
            System.out.println("First attack missed");
        }
        int attack2= attack();
        if (attack2>= creature.getAC()){
            int playerDamage = damage();
            System.out.println("Second attack hit for "+playerDamage+" damage");
            this.creatureHP -= playerDamage;
        }
        else {
            System.out.println("Second attack missed");
        }
        int attack3= attack();
        if (attack3>= creature.getAC()){
            int playerDamage = damage();
            System.out.println("Third attack hit for "+playerDamage+" damage");
            this.creatureHP -= playerDamage;
        }
        else {
            System.out.println("Third attack missed");
        }
        bool=true;
        return bool;
    }
    public boolean zornhau(){
        boolean bool = false;
        int dice1 = rng.generateRandomNumber(20);
        int dice2 = rng.generateRandomNumber(20);
        System.out.println("you rolled "+dice1 +"and "+ dice2);
        int attack = Math.min(dice1, dice2);
        if(attack+(int)Math.floor(player.getLvl()/2) + (int) Math.floor((player.getStrength()-10)/2)>= creature.getAC()){
            this.creatureHP=0;
            System.out.println("One hit KO!!");
        }else {
            System.out.println("You missed, get good");
        }
        bool=true;
        return bool;

    }
    public void setPlayerHP(int HP){
        this.playerHP=HP;
    }
    public int getPlayerHP(){
        return playerHP;
    }

    @Override
    public void setCreature(Creature creature) {
        this.creature=creature;
        this.creatureHP=creature.getHP();
    }
    public int getCreatureHP(){
        return this.creatureHP;
    }
}
