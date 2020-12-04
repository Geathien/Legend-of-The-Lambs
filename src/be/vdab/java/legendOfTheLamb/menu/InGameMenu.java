package be.vdab.java.legendOfTheLamb.menu;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.gamePlay.GamePlay;
import be.vdab.java.legendOfTheLamb.map.Forest;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;
import be.vdab.java.legendOfTheLamb.utilies.LoadGame;
import be.vdab.java.legendOfTheLamb.utilies.SaveFile;

import java.io.Serializable;

public class InGameMenu implements Serializable {
    transient KeyboardUtility keyboard;

    public InGameMenu(GamePlay gamePlay){
        keyboard = new KeyboardUtility();
        System.out.println("**** Menu ****");
        System.out.println("1. Save     - Save your game");
        System.out.println("2. Load     - Load a saved game");
        int choice= keyboard.askForNumber();
        while(choice!=1&&choice!=2) {
            switch (choice) {
                case 1:
                    saveFile(gamePlay);
                    break;
                case 2:
                    loadFile();
                    break;
                default:
                    System.out.println("enter 1 or 2");
                    choice= keyboard.askForNumber();
                    break;
            }
        }
    }

    public void saveFile(GamePlay gamePlay){
        SaveFile.saveGame(gamePlay);
    }
    public void loadFile(){
        LoadGame.loadGame();
    }

}
