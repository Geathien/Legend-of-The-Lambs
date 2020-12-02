package be.vdab.java.legendOfTheLamb.characters;

import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class LevelUp {
    private Player player;
    private RandomNumberGenerator rng=new RandomNumberGenerator();

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
