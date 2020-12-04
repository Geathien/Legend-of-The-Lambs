package be.vdab.java.legendOfTheLamb.utilies;

import be.vdab.java.legendOfTheLamb.gamePlay.GamePlay;
import be.vdab.java.legendOfTheLamb.map.Forest;


import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Path;

public class LoadGame implements Serializable {
    static Path path= Path.of(".\\src\\be\\vdab\\java\\legendOfTheLamb\\gamePlay\\GamePlay.txt");


    public static void loadGame(){

        try(FileInputStream inputStream= new FileInputStream(path.toString()); ObjectInputStream o=new ObjectInputStream(inputStream)){
            GamePlay gamePlay=(GamePlay) o.readObject();
            System.out.println(gamePlay.getPlayer());
            //gamePlay.getForest();
            try{
                GamePlay startLoadedFile= new GamePlay(gamePlay.getPlayer(),gamePlay.getForest());
            }
            catch (NullPointerException npe){
                npe.printStackTrace();
            }

        }
        catch (ClassNotFoundException | IOException cnfe){
            cnfe.printStackTrace();
        }


    }
}
