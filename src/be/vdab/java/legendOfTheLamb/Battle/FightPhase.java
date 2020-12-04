package be.vdab.java.legendOfTheLamb.Battle;

import be.vdab.java.legendOfTheLamb.Monsters.Creature;
import be.vdab.java.legendOfTheLamb.characters.ExpGain;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class FightPhase {
    RandomNumberGenerator rng = new RandomNumberGenerator();
    KeyboardUtility keyboard = new KeyboardUtility();
    int creatureHP;
    int playerHP;
    StartFight startFight;
    Player player;
    Creature creature;

    public FightPhase(Player player, Creature creature){
        this.player=player;
        this.creature=creature;
        this.startFight= new StartFight(player,creature);
        fight();
    }

    public void fight(){
        boolean order= startFight.turnOrder();
        this.playerHP=player.getAbility().getPlayerHP();
        this.creatureHP=creature.getHP();

        if (order) {
            int choice;
            while(this.playerHP>0&&this.creatureHP>0){
                this.playerHP=player.getAbility().getPlayerHP();
                System.out.println("**********************");
                System.out.println("your turn");
                System.out.println("\033[32myour HP is: "+this.playerHP+"/"+player.getHP()+"\033[0m");
                player.getAbility().showAbilities();
                choice=keyboard.askForNumber();
                while ( choice>5||choice<1){
                    System.out.println("Choose an ability ranging 1 to 5");
                    choice= keyboard.askForNumber();
                }
                playerAttack(choice);
                this.creatureHP=player.getAbility().getCreatureHP();
                this.playerHP=player.getAbility().getPlayerHP();
                System.out.println("**********************");

                if (this.creatureHP>0){
                    System.out.printf("%s's turn%n",creature.getName());
                    System.out.printf("%s attacks%n",creature.getName());
                    if (creatureAttackHit()){
                        int creatureDamage = creature.damage();
                        System.out.printf("\033[31m%s dealt %d damage%n\033[0m",creature.getName(),creatureDamage);
                        this.playerHP-= creatureDamage;
                        player.getAbility().setPlayerHP(this.playerHP);
                        System.out.println("\033[32myou now have "+this.playerHP+" HP left"+"\033[0m");
                    }
                    else{
                        System.out.printf("%s missed%n",creature.getName());
                    }
                }
                else{
                    ExpGain expGain= new ExpGain(player,creature.getCR());
                    player.getCharacterClass().getBackpack().addGold(creature.dropGold());
                    System.out.printf("\033[31m%s is dead%n\033[0m",creature.getName());
                }
                if (playerHP<=0){
                    System.out.println("\033[31mYou're dead\033[0m");
                    break;
                }

            }
        }
        else{
            while(this.playerHP>0&&this.creatureHP>0) {
                this.playerHP=player.getAbility().getPlayerHP();
                this.creatureHP=player.getAbility().getCreatureHP();
                if (this.creatureHP > 0) {
                    System.out.println("**********************");
                    System.out.printf("%s's turn%n",creature.getName());
                    System.out.printf("%s attacks%n",creature.getName());
                        if (creatureAttackHit()){
                            int creatureDamage = creature.damage();
                            System.out.printf("\033[31m%s dealt %d damage%n\033[0m",creature.getName(),creatureDamage);
                            this.playerHP-= creatureDamage;
                            player.getAbility().setPlayerHP(this.playerHP);
                            System.out.println("\033[32myou now have "+this.playerHP+" HP left"+"\033[0m");
                        }
                        else{
                            System.out.printf("%s missed%n",creature.getName());
                        }

                } else {
                    System.out.printf("\033[31m%s is dead%n\033[0m",creature.getName());
                    ExpGain expGain= new ExpGain(player,creature.getCR());
                    player.getCharacterClass().getBackpack().addGold(creature.dropGold());
                    break;
                }
                if (this.playerHP > 0) {
                    System.out.println("**********************");
                    System.out.println("Your turn");
                    System.out.println("\033[32myour HP is: "+this.playerHP+"/"+player.getHP()+"\033[0m");
                    player.getAbility().showAbilities();
                    int choice=keyboard.askForNumber();
                    while ( choice>5||choice<1){
                        System.out.println("Choose an ability ranging 1 to 5");
                        choice= keyboard.askForNumber();
                    }
                    playerAttack(choice);

                }
                if (playerHP<=0){
                    System.out.println("\033[31mYou're dead\033[0m");
                    break;
                }
            }


        }
    }

    private void playerAttack(int choice){
        player.getAbility().chooseAbility(choice);
    }
    private boolean creatureAttackHit(){
        int attackCreature = creature.attack();
        return attackCreature>= player.getAC();
    }
}
