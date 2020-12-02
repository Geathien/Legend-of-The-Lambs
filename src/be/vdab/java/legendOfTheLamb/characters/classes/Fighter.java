package be.vdab.java.legendOfTheLamb.characters.classes;

import be.vdab.java.legendOfTheLamb.items.armour.Armour;
import be.vdab.java.legendOfTheLamb.items.armour.ChainMail;
import be.vdab.java.legendOfTheLamb.items.packs.Backpack;
import be.vdab.java.legendOfTheLamb.items.packs.Pack;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.items.weapons.Sword;

public class Fighter implements CharacterClass{
    private String characterClass = "Fighter";
    private int armourBase = 8;
    private int lifeDice = 12;
    Backpack backpack= new Backpack();
    private int HP;
    private String description = "Fighters are masters of weapons. Always wearing heavy armour and even lethal with a free fist.";
    RandomNumberGenerator RNG = new RandomNumberGenerator();

    public Fighter(){
        setHP();
        setItems();
    }

    @Override
    public String getCharacterClass() {
        return this.characterClass;
    }

    @Override
    public int getArmourBase() {
        return this.armourBase;
    }

    public int getABItem() {
        Armour armour = (Armour)backpack.getItem(1);
        return armour.armourBase();
    }

    public int getArmour(){
        return getArmourBase()+getABItem();
    }

    @Override
    public int getLifeDice() {
        return this.lifeDice;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public void setArmourBase(int armourBase) {
        this.armourBase = armourBase;
    }

    public void setLifeDice(int lifeDice) {
        this.lifeDice = lifeDice;
    }

    @Override
    public int getHP() {
        return HP;
    }

    public void setHP() {
        this.HP = RNG.generateHP(getLifeDice());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItems(){
       backpack.insertItem(new Sword());
       backpack.insertItem(new ChainMail());
       backpack.addGold(15);

    }
    public Pack getBackpack(){
        return this.backpack;
    }

    @Override
    public String toString() {
        return "Fighter";
    }
}
