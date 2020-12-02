package be.vdab.java.legendOfTheLamb.Monsters;

import be.vdab.java.legendOfTheLamb.characters.Player;

public interface Creature {

    ChallengeRating getCR();
    int getHP();
    int getAC();
    String getName();
    int attack();
    int damage();
    void setPlayer(Player player);

}
