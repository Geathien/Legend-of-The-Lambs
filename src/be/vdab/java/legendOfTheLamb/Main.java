package be.vdab.java.legendOfTheLamb;

import be.vdab.java.legendOfTheLamb.Monsters.*;
import be.vdab.java.legendOfTheLamb.characters.ExpGain;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.characters.abilities.Ability;
import be.vdab.java.legendOfTheLamb.characters.abilities.FighterAbility;
import be.vdab.java.legendOfTheLamb.characters.abilities.HealerAbility;
import be.vdab.java.legendOfTheLamb.characters.abilities.RangerAbility;
import be.vdab.java.legendOfTheLamb.characters.classes.Fighter;

public class Main {
    public static void main(String[] args) {
        Player player= new Player("Elf","Fighter","Leonidas");

        Troll troll = new Troll();
        HobbGoblin hobbGoblin = new HobbGoblin();
        Bugbear bugBear= new Bugbear();

        System.out.println(player);
        System.out.println("Troll attack: "+ troll.attack()+", damage: "+troll.damage());
        System.out.println("Troll heavy blow attack: "+ troll.heavyBlow()+", damage: "+troll.heavyBlowDamage());
        System.out.println("HobbGoblin attack: "+ hobbGoblin.attack()+", damage: "+hobbGoblin.damage());
        System.out.println("Bugbear attack: "+ bugBear.attack()+", damage: "+bugBear.damage());
        bugBear.swordDance();

    }
}
