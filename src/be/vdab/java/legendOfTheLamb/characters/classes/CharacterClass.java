package be.vdab.java.legendOfTheLamb.characters.classes;

import be.vdab.java.legendOfTheLamb.items.packs.Pack;

public interface CharacterClass {

    String getCharacterClass();

    int getArmour();

    int getArmourBase();

    int getLifeDice();

    int getHP();

    Pack getBackpack();

}
