package be.vdab.java.legendOfTheLamb.characters;

import be.vdab.java.legendOfTheLamb.Monsters.ChallengeRating;

public class ExpGain {
    Player player;
    int lvl=1;
    LevelUp levelUp;


    public ExpGain(Player player){
        this.player=player;
        setLvl();
    }
    public ExpGain(Player player, ChallengeRating CR){
        this.player=player;
        checkRating(CR);
        this.levelUp=new LevelUp(player);
        setLvl();

    }
    private void checkRating(ChallengeRating CR){
      addExp(CR.getExp());
    }

    private void addExp(int exp){
        player.setXp(exp);
    }
    private void setLvl(){
        int xp = player.getXp();
        if (xp >= 1500){
            this.lvl = 5;
        }
        else if (xp >= 700){
            this.lvl = 4;
        }
        else if (xp >= 250){
            this.lvl = 3;
        }
        else if (xp >= 100){
            this.lvl = 2;
        }
        else {
            this.lvl = 1;
        }
        if(player.getLvl()!=lvl){
            for (int i = player.getLvl(); i <= lvl; i++){
                levelUp.hpUp();
                player.setLvl(i);
                }
        }
    }

}
