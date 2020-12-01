package be.vdab.java.legendOfTheLamb;


import be.vdab.java.legendOfTheLamb.menu.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Menu game = new Menu();

        game.raceMenu();
        String race = keyboard.next();
        game.classMenu();
        String characterClass = keyboard.next();

        System.out.println(race + ", " +characterClass);

    }
}
