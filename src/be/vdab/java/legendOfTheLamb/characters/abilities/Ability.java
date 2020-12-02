package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.Monsters.Creature;

public interface Ability {

    void showAbilities();
    void chooseAbility(int choice);
    void setCreature(Creature creature);
    void setPlayerHP(int HP);
    int getPlayerHP();
    void checkLvl();
    int getCreatureHP();
}
