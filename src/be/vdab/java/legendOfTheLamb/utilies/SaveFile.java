package be.vdab.java.legendOfTheLamb.utilies;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.gamePlay.GamePlay;
import be.vdab.java.legendOfTheLamb.map.Forest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;

public class SaveFile implements Serializable {

    static Path path= Path.of(".\\src\\be\\vdab\\java\\legendOfTheLamb\\gamePlay\\GamePlay.txt");


    public static void saveGame(GamePlay gamePlay){

        try(FileOutputStream outputStream= new FileOutputStream(path.toString()); ObjectOutputStream o=new ObjectOutputStream(outputStream)){
            o.writeObject(gamePlay);
        }
        catch (IOException io){
            io.printStackTrace();
        }


    }

}
