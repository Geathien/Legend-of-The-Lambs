package be.vdab.java.legendOfTheLamb.menu;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.gamePlay.GamePlay;
import be.vdab.java.legendOfTheLamb.map.Forest;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;
import be.vdab.java.legendOfTheLamb.utilies.LoadGame;

import java.io.Serializable;

public class Menu implements Serializable {
    transient KeyboardUtility keyboard=new KeyboardUtility();
    Player player;
    String race;
    String characterClass;
    String name;
    Forest forest;
    GamePlay gamePlay;

    public Menu(){
        startScreen();
    }

    public void startScreen(){
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("++ Legend of the Lamb - DA ++");
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("--    DA Studios Belgium   --");
        System.out.println("-----------------------------");
        System.out.println("Loading Maps and Saved games");
        System.out.println("++++++++++");
        System.out.println("++ DONE ++");
        System.out.println("++++++++++");
        mainMenu();
    }
    public void mainMenu(){
        System.out.println("What do you want to do");
        System.out.println("New      - Start a new game");
        System.out.println("Load     - Load a saved game");
        System.out.println("Controls - Game controls");
        System.out.println("Please choose an option:");
        String word=keyboard.askForString();
        boolean check =false;
        while(!check) {
            switch (word) {
                case "New":
                case"new":
                    check=true;
                    newGame();
                    break;
                case "Load":
                case "load":
                    check=true;
                    LoadGame.loadGame();
                    break;
                case "Controls":
                case "controls":
                    check=true;
                    controlMenu();
                    break;
                default:
                    check=false;
                    System.out.println("Please enter a valid option");
                    word= keyboard.askForString();
                    break;
            }
        }
    }

    public void newGame(){
        System.out.println("What map do you want to play?");
        System.out.println("   1. Forest of Streams");
        System.out.println("Please choose a map");
        int choice = keyboard.askForNumber();
        boolean check=false;
        while(!check){
        if(choice==1){
            check=true;
            System.out.println("Welcome to the Forest of Streams");
            this.forest = new Forest();
            raceMenu();
        }else{
            System.out.println("enter number 1");
            choice = keyboard.askForNumber();
        }
        }
    }
    public void raceMenu(){
        System.out.println("What race do you want to play with?");
        System.out.println("Human");
        System.out.println("Dwarf");
        System.out.println("Elf");
        System.out.println("Enter a race:");
        boolean check =false;
        String race=keyboard.askForString();
        while(!check) {
            switch (race){
                case "Human":
                case "human":
                    check=true;
                    this.race="Human";
                    break;
                case "Dwarf":
                case "dwarf":
                    check=true;
                    this.race="Dwarf";
                    break;
                case "Elf":
                case "elf":
                    check=true;
                    this.race="Elf";
                    break;
                default:
                    check=false;
                    System.out.println("Please enter a valid option");
                    race= keyboard.askForString();
                    break;
            }
        }
        classMenu();
    }
    public void classMenu(){
        System.out.println("What class do you want to play with?");
        System.out.println("Fighter");
        System.out.println("Ranger");
        System.out.println("Healer");
        System.out.println("Pick a class");
        boolean check= false;
        String charClass= keyboard.askForString();
        while(!check) {
            switch (charClass){
                case "Fighter":
                case "fighter":
                    check=true;
                    this.characterClass="Fighter";
                    break;
                case "Ranger":
                case "ranger":
                    check=true;
                    this.characterClass="Ranger";
                    break;
                case "Healer":
                case "healer":
                    check=true;
                    this.characterClass="Healer";
                    break;
                default:
                    check=false;
                    System.out.println("Please enter a valid option");
                    charClass= keyboard.askForString();
                    break;
            }
        }
        System.out.println("what's your characters name:");
        this.name= keyboard.askForString();
        this.player=new Player(this.race,this.characterClass,this.name);
        System.out.println(this.player);
        this.gamePlay = new GamePlay(this.player, this.forest);
    }

    private void controlMenu() {
        System.out.println("Z:  north");
        System.out.println("S:  south");
        System.out.println("Q:  west");
        System.out.println("D:  east");
        System.out.println("P:  in game menu");
        System.out.println("C:  character stats");
        mainMenu();
    }

    public Player getPlayer(){
        return this.player;
    }

    public Forest getForest(){
        return this.forest;
    }
}
