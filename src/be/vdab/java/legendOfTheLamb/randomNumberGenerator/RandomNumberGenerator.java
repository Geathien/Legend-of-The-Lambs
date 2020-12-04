package be.vdab.java.legendOfTheLamb.randomNumberGenerator;

import java.io.Serializable;
import java.util.Random;

public class RandomNumberGenerator implements Serializable {

    public RandomNumberGenerator(){

    }

    public int generateRandomNumber(int bound){
        Random random = new Random();
        return random.nextInt(bound)+1;
    }

    public int generateHP(int bound){
        Random random = new Random();
        int hp = 0;
        for (int i = 0; i<= 2; i++){
            hp += random.nextInt(bound )+1;
        }
        return hp + 10;
    }

}
