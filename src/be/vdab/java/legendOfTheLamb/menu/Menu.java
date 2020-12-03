package be.vdab.java.legendOfTheLamb.menu;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.gamePlay.GamePlay;
import be.vdab.java.legendOfTheLamb.map.Forest;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class Menu {
    KeyboardUtility keyboard=new KeyboardUtility();
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
        System.out.println("Reset    - Reset all saved files");
        System.out.println("Controls - Game controls");
        System.out.println("Settings - Game settings");
        System.out.println("Quit     - Quit game");
        System.out.println("Please choose an option:");
        String word=keyboard.askForString();
        switch (word){
            case "New":
                newGame();
                break;
            case"Controls":
                controlMenu();
                break;

        }
    }

    public void newGame(){
        System.out.println("What map do you want to play?");
        System.out.println("   1. Forest of Streams");
        System.out.println("Please choose a map");
        int choice = keyboard.askForNumber();
        switch(choice){
            case 1:
                System.out.println("Welcome to the Forest of Streams");
                this.forest = new Forest();
                raceMenu();
                break;
        }
    }
    public void raceMenu(){
        System.out.println("What race do you want to play with?");
        System.out.println("Human");
        System.out.println("Dwarf");
        System.out.println("Elf");
        System.out.println("Enter a race:");
        this.race = keyboard.askForString();
        classMenu();
    }
    public void classMenu(){
        System.out.println("What class do you want to play with?");
        System.out.println("Fighter");
        System.out.println("Ranger");
        System.out.println("Healer");
        System.out.println("Pick a class");
        this.characterClass = keyboard.askForString();
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
        mainMenu();
    }

    public Player getPlayer(){
        return this.player;
    }

    public Forest getForest(){
        return this.forest;
    }
}
