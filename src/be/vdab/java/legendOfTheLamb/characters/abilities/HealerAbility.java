package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.Monsters.Creature;
import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class HealerAbility implements Ability{
    RandomNumberGenerator rng = new RandomNumberGenerator();
    KeyboardUtility keyboard = new KeyboardUtility();
    int choice;
    int playerLvl;
    int playerHP;
    int creatureHP;
    Player player;
    Creature creature;

    public HealerAbility(Player player){
        setPlayer(player);
        checkLvl();
    }

    private void setPlayer(Player player){
        this.player = player;
        this.playerHP= player.getHP();
    }

    public void checkLvl(){
        this.playerLvl = player.getLvl();
    }

    public int getCreatureHP(){
        return this.creatureHP;
    }
    @Override
    public void showAbilities() {
        System.out.println("Abilities:");
        switch (playerLvl){
            case 5:
                System.out.println("1. Healing word. Heal another creature");
                System.out.println("2. Cursing word. Curse another creature");
                System.out.println("3. Healing prayer. Heal another creature");
                System.out.println("4. Maddening prayer. Let another creature despair and inflict damage on itself. ");
                System.out.println("5. Gods Area. Every Ally gets healed. Every non ally creature within this area is damaged");
                break;
            case 4:
                System.out.println("1. Healing word. Heal another creature");
                System.out.println("2. Cursing word. Curse another creature");
                System.out.println("3. Healing prayer. Heal another creature");
                System.out.println("4. Maddening prayer. Let another creature despair and inflict damage on itself. ");
                break;
            case 3:
                System.out.println("1. Healing word. Heal another creature");
                System.out.println("2. Cursing word. Curse another creature");
                System.out.println("3. Healing prayer. Heal another creature");
                break;
            case 2:
            case 1:
                System.out.println("1. Healing word. Heal another creature");
                System.out.println("2. Cursing word. Curse another creature");
                break;
        }

    }
    private boolean healingWord(){
        int healing=rng.generateRandomNumber(6)+ (int) Math.floor((player.getWisdom()-10)/2);
        if(this.playerHP==player.getHP()){
            System.out.println("you're already at full health");
        }
        else if(this.playerHP+ healing> player.getHP()){
            int difference = player.getHP()-this.playerHP;
            System.out.println("you healed for "+difference);
            this.playerHP=player.getHP();
            System.out.println("You now have "+this.playerHP+" HP");
        }else {
            this.playerHP+= healing;
            System.out.println("You healed for "+healing);
            System.out.println("You now have "+this.playerHP+" HP");
        }
        return true;
    }
    private boolean cursingWord(){
        int attack = rng.generateRandomNumber(20)+ (int) Math.floor(playerLvl/2) + (int) Math.floor((player.getWisdom()-10)/2);
        int damage = rng.generateRandomNumber(6)+ (int) Math.floor((player.getWisdom()-10)/2);
        if (attack>= creature.getAC()){
            this.creatureHP-= damage;
            System.out.println("You dealt "+damage+" damage");
        }else {
            System.out.println("You missed");
        }
        return true;
    }
    private boolean healingPrayer(){
        int healing =rng.generateRandomNumber(12)+ (int) Math.floor((player.getWisdom()-10)/2);
        if(this.playerHP<player.getHP()){
            this.playerHP+= healing;
            System.out.println("You healed for "+healing);
            System.out.println("You now have "+this.playerHP+" HP");
        }else if(this.playerHP+ healing> player.getHP()){
            int difference = player.getHP()-this.playerHP;
            System.out.println("you healed for "+difference);
            this.playerHP=player.getHP();
            System.out.println("You now have "+this.playerHP+" HP");
        }
        else{
            System.out.println("you're already at full health");
        }
        return true;
    }
    private boolean maddeningPrayer(){
        int attack = rng.generateRandomNumber(20)+ (int) Math.floor(playerLvl/2) + (int) Math.floor((player.getWisdom()-10)/2);
        int damage = creature.damage();
        if (attack>= creature.getAC()){
            this.creatureHP-= damage;
            System.out.printf("%s dealt %d damage to itself",creature.getName(),damage);
        }else {
            System.out.println("You missed");
        }
        return true;
    }
    private boolean godsArea(){
       int healing = rng.generateRandomNumber(12)+ rng.generateRandomNumber(12) + (int) Math.floor((player.getWisdom()-10)/2);
       int damage = rng.generateRandomNumber(12)+ rng.generateRandomNumber(12) + (int) Math.floor((player.getWisdom()-10)/2);
       int dice = rng.generateRandomNumber(6);
       if (dice >= 5){
           if(this.playerHP<player.getHP()){
               this.playerHP+= healing;
               System.out.println("You healed for "+healing);
               System.out.println("You now have "+this.playerHP+" HP");
           }else if(playerHP+ healing> player.getHP()){
               System.out.println("you healed for "+(player.getHP()-this.playerHP));
               this.playerHP=player.getHP();
               System.out.println("You now have "+this.playerHP+" HP");
           }
           else{
               System.out.println("you're already at full health");
           }
           this.creatureHP-= damage;
           System.out.println("You dealt "+damage+" damage");
       }
       else{
           System.out.println("You missed");
       }
        return true;
    }

    @Override
    public void chooseAbility(int choice) {
        this.choice = choice;
        boolean check = false;
        switch (choice){
            case 1:
                check=healingWord();
                break;
            case 2:
                check=cursingWord();
                break;
            case 3:if(playerLvl<3){
                System.out.println("You don't have the required level, choose another ability from above");
                break;
            }
                check=healingPrayer();
                break;
            case 4:if(playerLvl<4){
                System.out.println("You don't have the required level, choose another ability from above");
                break;
            }
                check=maddeningPrayer();
                break ;
            case 5:if(playerLvl<5){
                System.out.println("You don't have the required level, choose another ability from above");
                break;
            }
                check=godsArea();
                break;
        }
        if(!check){
        int choice2= keyboard.askForNumber();
        chooseAbility(choice2);}

    }

    public void setPlayerHP(int HP){
        this.playerHP= HP;
    }

    @Override
    public int getPlayerHP() {
        return this.playerHP;
    }


    @Override
    public void setCreature(Creature creature) {
        this.creature= creature;
        this.creatureHP=creature.getHP();
    }
}
