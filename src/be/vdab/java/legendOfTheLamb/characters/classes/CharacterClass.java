package be.vdab.java.legendOfTheLamb.characters.classes;

import be.vdab.java.legendOfTheLamb.items.packs.Pack;

import java.io.Serializable;

public interface CharacterClass extends Serializable {

    String getCharacterClass();

    int getArmour();

    int getArmourBase();

    int getLifeDice();

    int getHP();

    Pack getBackpack();

}
