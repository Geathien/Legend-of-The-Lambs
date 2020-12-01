package be.vdab.java.legendOfTheLamb.characters.abilities;

import be.vdab.java.legendOfTheLamb.characters.Player;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.utilies.KeyboardUtility;

public class HealerAbility implements Ability{
    RandomNumberGenerator rng = new RandomNumberGenerator();
    KeyboardUtility keyboard = new KeyboardUtility();
    int playerLvl;
    Player player;

    public HealerAbility(Player player){
        setPlayer(player);
        checkLvl();
    }

    private void setPlayer(Player player){
        this.player = player;
    }

    private void checkLvl(){
        this.playerLvl = player.getLvl();
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
    private int healingWord(){
        return rng.generateRandomNumber(6)+ (int) Math.floor((player.getWisdom()-10)/2);
    }
    private int cursingWordAttack(){
        return rng.generateRandomNumber(20)+ (int) Math.floor(playerLvl/2) + (int) Math.floor((player.getWisdom()-10)/2);
    }
    private int cursingWordDamage(){
        return rng.generateRandomNumber(6)+ (int) Math.floor((player.getWisdom()-10)/2);
    }
    private int healingPrayer(){
        return rng.generateRandomNumber(12)+ (int) Math.floor((player.getWisdom()-10)/2);
    }
    private int maddeningPrayerAttack(){
        return rng.generateRandomNumber(20)+ (int) Math.floor(playerLvl/2) + (int) Math.floor((player.getWisdom()-10)/2);
    }
    private int maddeningPrayerDamage(){
        // TODO: calc monsters
        return 0;
    }
    private int godsAreaHealing(){
        return rng.generateRandomNumber(12)+ rng.generateRandomNumber(12) + (int) Math.floor((player.getWisdom()-10)/2);
    }
    private int godsAreaDamage(){
        return rng.generateRandomNumber(12)+ rng.generateRandomNumber(12) + (int) Math.floor((player.getWisdom()-10)/2);
    }
    private int godsAreaDice(){
        return rng.generateRandomNumber(6);
    }

    @Override
    public void chooseAbility() {
        int choice = keyboard.askForNumber();
        switch (choice){
            case 1:
                System.out.println("Healing word: "+healingWord());
                break;
            case 2:
                System.out.println("Cursing word: "+ cursingWordAttack()+", damage: "+cursingWordDamage());
                break;
            case 3:
                System.out.println("Healing Prayer: "+ healingPrayer());
                break;
            case 4:
                System.out.println("Maddening prayer: "+ maddeningPrayerAttack()+", damage: "+maddeningPrayerDamage());
                break ;
            case 5:
                int dice= godsAreaDice();
                System.out.println("Gods area dice roll: "+ dice);
                if(dice >= 5){
                    System.out.println("Gods area healing: "+ godsAreaHealing()+", Gods area damage: "+godsAreaDamage());
                }else{
                    System.out.println("unlucky ur ability failed");
                }
                break;
        }

    }
}
