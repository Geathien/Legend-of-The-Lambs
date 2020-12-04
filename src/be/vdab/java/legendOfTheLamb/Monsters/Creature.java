package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.characters.Player;

import java.io.Serializable;

public interface Creature extends Serializable {

    ChallengeRating getCR();
    int getHP();
    int getAC();
    String getName();
    int attack();
    int damage();
    void setPlayer(Player player);
    int dropGold();

}
