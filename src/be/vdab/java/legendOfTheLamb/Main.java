package be.vdab.java.legendOfTheLamb;

import be.vdab.java.legendOfTheLamb.characters.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Dwarf", "Healer", "dwarf");
        Player fighter = new Player("Human", "Fighter", "fighter");
        Player ranger = new Player("Elf", "Ranger", "ranger");
        System.out.println(player);
        System.out.println(fighter);
        System.out.println(ranger);


    }
}
