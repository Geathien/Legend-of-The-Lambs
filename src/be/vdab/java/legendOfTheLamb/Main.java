package be.vdab.java.legendOfTheLamb;

import be.vdab.java.legendOfTheLamb.Battle.FightPhase;
import be.vdab.java.legendOfTheLamb.Monsters.*;
import be.vdab.java.legendOfTheLamb.characters.ExpGain;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.characters.abilities.Ability;
import be.vdab.java.legendOfTheLamb.characters.abilities.FighterAbility;
import be.vdab.java.legendOfTheLamb.characters.abilities.HealerAbility;
import be.vdab.java.legendOfTheLamb.characters.abilities.RangerAbility;
import be.vdab.java.legendOfTheLamb.characters.classes.Fighter;
import be.vdab.java.legendOfTheLamb.menu.Menu;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class Main {
    public static void main(String[] args) {
//        Menu game = new Menu();
//        game.startScreen();
        Player player = new Player("Dwarf","Fighter","Jefke");
        System.out.println(player);
        System.out.println(player.getCharacterClass().getBackpack().getGold());
        HobbGoblin hobbGoblin = new HobbGoblin();
        FightPhase fight= new FightPhase(player, hobbGoblin);
        fight.fight();
        System.out.println(player);
        System.out.println(player.getCharacterClass().getBackpack().getGold());
    }
}
