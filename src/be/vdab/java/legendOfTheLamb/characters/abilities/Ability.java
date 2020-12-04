package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.Monsters.Creature;

import java.io.Serializable;

public interface Ability extends Serializable {

    void showAbilities();
    void chooseAbility(int choice);
    void setCreature(Creature creature);
    void setPlayerHP(int HP);
    int getPlayerHP();
    void checkLvl();
    int getCreatureHP();
}
