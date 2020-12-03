package be.vdab.java.legendOfTheLamb.gamePlay;

import be.vdab.java.legendOfTheLamb.Battle.FightPhase;
import be.vdab.java.legendOfTheLamb.Battle.StartFight;
import be.vdab.java.legendOfTheLamb.Monsters.*;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.map.Forest;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class GamePlay {
    KeyboardUtility keyboard = new KeyboardUtility();
    RandomNumberGenerator rng = new RandomNumberGenerator();
    FightPhase fightPhase;
    Player player;
    Forest forest;

    public GamePlay(Player player, Forest forest){
        this.player = player;
        this.forest = forest;
        setPlayerPosition(39,6);
        printMap();
        walk();
    }

    public void setPlayerPosition(int x, int y){
        forest.setPlayerPosition(x, y);
        forest.write();
    }

    public void printMap(){
        forest.read();
    }

    public void walk(){
        System.out.println("Which direction would you like to go: (z/s/q/d)");
        String direction = keyboard.askForString();
        boolean bool = false;
        while (player.getAbility().getPlayerHP()>0) {
            switch (direction) {
                case "z":
                    bool = goNorth();
                    break;
                case "s":
                    bool = goSouth();
                    break;
                case "q":
                    bool = goWest();
                    break;
                case "d":
                    bool = goEast();
                    break;
            }
            if (bool){
                printMap();
                if (forest.getPlayerXPosition() == 15 && forest.getPlayerYPosition() == 27){
                    if (player.getLvl() >= 4){
                        System.out.println("***Boss fight***");
                        this.fightPhase = new FightPhase(this.player, new Bugbear());
                    } else {
                        System.out.println("You're level is too low. Come back later.");
                    }

                }
                if (forest.getPlayerXPosition() == 21 && forest.getPlayerYPosition() == 29){
                    if (player.getLvl() >= 2) {
                        System.out.println("***Boss fight***");
                        this.fightPhase = new FightPhase(this.player, new Wolf());
                    } else {
                        System.out.println("You're level is too low. Come back later.");
                    }
                }
                int chance = rng.generateRandomNumber(10);
                if (chance == 1 || chance == 4 || chance == 7){
                    encounterRandomMonster();
                }
            }
            System.out.println("Which direction would you like to go: (z/s/q/d)");
            direction = keyboard.askForString();
        }
    }

    private boolean goNorth(){
        boolean check = false;
        int playerXPosition= forest.getPlayerXPosition()-1;
        int playerYPosition= forest.getPlayerYPosition();
        if (forest.wallCheck(playerXPosition,playerYPosition)){
            forest.generateMap();
            forest.setPlayerPosition(playerXPosition,playerYPosition);
            forest.write();
            check = true;
        }else{
            System.out.println("You walked into a wall");
        }
        return check;
    }
    private boolean goSouth(){
        boolean check = false;
        int playerXPosition= forest.getPlayerXPosition()+1;
        int playerYPosition= forest.getPlayerYPosition();
        if (forest.wallCheck(playerXPosition,playerYPosition)){
            forest.generateMap();
            forest.setPlayerPosition(playerXPosition,playerYPosition);
            forest.write();
            check = true;
        }else{
            System.out.println("You walked into a wall");
        }
        return check;
    }
    private boolean goWest(){
        boolean check = false;
        int playerXPosition= forest.getPlayerXPosition();
        int playerYPosition= (forest.getPlayerYPosition()-1);
        if (forest.wallCheck(playerXPosition,playerYPosition)){
            forest.generateMap();
            forest.setPlayerPosition(playerXPosition,playerYPosition);
            forest.write();
            check = true;
        }else{
            System.out.println("You walked into a wall");
        }
        return check;
    }
    private boolean goEast(){
        boolean check = false;
        int playerXPosition= forest.getPlayerXPosition();
        int playerYPosition= forest.getPlayerYPosition()+1;
        if (forest.wallCheck(playerXPosition,playerYPosition)){
            forest.generateMap();
            forest.setPlayerPosition(playerXPosition,playerYPosition);
            forest.write();
            check = true;
        }else{
            System.out.println("You walked into a wall");
        }
        return check;
    }

    public void encounterRandomMonster(){
        int chance = rng.generateRandomNumber(22);
        switch (chance){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("***Fight***");
                System.out.println("You encountered a Goblin Minion");
                this.fightPhase = new FightPhase(this.player, new GoblinMinion());
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("***Fight***");
                System.out.println("You encountered a Goblin Fighter");
                this.fightPhase = new FightPhase(this.player, new GoblinFighter());
                break;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                System.out.println("***Fight***");
                System.out.println("You encountered a Goblin Ranger");
                this.fightPhase = new FightPhase(this.player, new GoblinRanger());
                break;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                if (player.getLvl() >=3){
                    System.out.println("***Fight***");
                    System.out.println("You encountered a HobbGoblin");
                    this.fightPhase = new FightPhase(this.player, new HobbGoblin());
                }
                break;
            case 21:
            case 22:
                if (player.getLvl() >= 4){
                    System.out.println("***Fight***");
                    System.out.println("You encountered a Troll");
                    this.fightPhase = new FightPhase(this.player, new Troll());
                }
                break;
        }

    }
}
