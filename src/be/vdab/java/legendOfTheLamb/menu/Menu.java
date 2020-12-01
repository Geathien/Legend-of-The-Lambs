package be.vdab.java.legendOfTheLamb.menu;

public class Menu {
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
    }
    public void mainMenu(){
        System.out.println("What do you want to do");
        System.out.println("New      - Start a new game");
        System.out.println("Load     - Load a saved game");
        System.out.println("Reset    - Reset all saved files");
        System.out.println("Controls - Game controls");
        System.out.println("Settings - Game settings");
        System.out.println("Quit     - Quit game");
    }

    public void newGame(){
        System.out.println("What map do you want to play?");
        System.out.println("   1. Forest of Streams");
        System.out.println("   2. Cave of Thread");
    }
    public void raceMenu(){
        System.out.println("What race do you want to play with?");
        System.out.println("Human");
        System.out.println("Dwarf");
        System.out.println("Elf");
    }
    public void classMenu(){
        System.out.println("What class do you want to play with?");
        System.out.println("Fighter");
        System.out.println("Ranger");
        System.out.println("Healer");
    }
}
