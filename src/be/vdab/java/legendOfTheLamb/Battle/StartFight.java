package be.vdab.java.legendOfTheLamb.Battle;

import be.vdab.java.legendOfTheLamb.Monsters.Creature;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

public class StartFight {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    Player player;
    Creature creature;
    int initiativePlayer;
    int initiativeCreature;

    public StartFight(Player player, Creature creature){
        this.player=player;
        this.creature=creature;
        player.getAbility().setCreature(creature);
        creature.setPlayer(this.player);
        setInitiatives();
    }

    private void setInitiatives(){
        this.initiativePlayer= rng.generateRandomNumber(20)+ (int) Math.floor((player.getDexterity()-10)/2);
        this.initiativeCreature= rng.generateRandomNumber(20);
    }
    public boolean turnOrder(){
        while(initiativeCreature==initiativePlayer){
            setInitiatives();
        }
        return initiativeCreature < initiativePlayer;
    }
}
