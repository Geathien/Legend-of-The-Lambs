package be.vdab.java.legendOfTheLamb.Monsters;

public interface Creature {

    ChallengeRating getCR();
    int getHP();
    int getAC();
    String getName();

}
