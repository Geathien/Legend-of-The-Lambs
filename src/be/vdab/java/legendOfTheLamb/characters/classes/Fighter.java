package be.vdab.java.legendOfTheLamb.characters.classes;

import be.vdab.java.legendOfTheLamb.items.Item;
import be.vdab.java.legendOfTheLamb.items.armour.Armour;
import be.vdab.java.legendOfTheLamb.items.armour.ChainMail;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;
import be.vdab.java.legendOfTheLamb.items.weapons.Sword;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Fighter implements CharacterClass{
    private String characterClass = "Fighter";
    private int armourBase = 8;
    private int lifeDice = 12;
    List<Item> items = new ArrayList<>();
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
        Armour armour = (Armour)items.get(1);
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
        items.add(new Sword());
        items.add(new ChainMail());

    }

    public List<Item> getItems() {
        return items;
    }

    //TODO setAbilities


    @Override
    public String toString() {
        return "Fighter";
    }
}
