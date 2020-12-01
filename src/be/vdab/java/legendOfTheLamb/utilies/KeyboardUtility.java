package be.vdab.java.legendOfTheLamb.utilies;

import java.util.Scanner;

public class KeyboardUtility {
    Scanner keyboard = new Scanner(System.in);

    public int askForNumber(){
        System.out.println("please enter a number");
        return keyboard.nextInt();
    }
}
