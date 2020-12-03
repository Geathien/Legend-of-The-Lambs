package be.vdab.java.legendOfTheLamb.utilies;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardUtility {
    Scanner keyboard = new Scanner(System.in);
    int number = 0;

    public int askForNumber(){
        System.out.println("please enter a number");
        while(!keyboard.hasNextInt()){
            System.out.println("Enter a number nothing else");
            keyboard.next();  // remove incorrect token
        }
        return keyboard.nextInt();
    }

//    public int getNumber(){
//        while(true) {
//            try {
//                number= keyboard.nextInt();
//            } catch (InputMismatchException ime) {
//                ime.printStackTrace();
//                System.out.println("Please enter a number you idiot!");
//                number = keyboard.nextInt();
//            }
//            return number;
//        }
//    }

    public String askForString(){
        return keyboard.next();
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
