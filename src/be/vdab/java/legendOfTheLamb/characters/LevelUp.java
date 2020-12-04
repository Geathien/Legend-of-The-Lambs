package be.vdab.java.legendOfTheLamb.characters;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

import java.io.Serializable;

public class LevelUp implements Serializable {
    private Player player;
    transient private RandomNumberGenerator rng=new RandomNumberGenerator();

    public LevelUp(Player player){
        this.player=player;
//        hpUp();
//        statsUp();

    }
    public void hpUp(){
        int hp = player.getHP()+ (rng.generateRandomNumber(player.getCharacterClass().getLifeDice())*2);
        player.newHP(hp);
        player.getAbility().setPlayerHP(hp);
    }
//    private void statsUp(){
//
//    }

}
