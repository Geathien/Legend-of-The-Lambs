package be.vdab.java.legendOfTheLamb.characters.classes;

import be.vdab.java.legendOfTheLamb.items.Item;
import be.vdab.java.legendOfTheLamb.items.armour.Armour;
import be.vdab.java.legendOfTheLamb.items.armour.LeatherArmour;
import be.vdab.java.legendOfTheLamb.items.weapons.Bow;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ranger implements CharacterClass {
    private String characterClass = "Ranger";
    private int armourBase = 6;
    private int lifeDice = 8;
    List<Item> items = new ArrayList<>();
    private int HP;
    private String description = "Rangers are one with nature and masters of the bow. With their light leather armour, they are agile and lean.";
    RandomNumberGenerator RNG = new RandomNumberGenerator();

    public Ranger(){
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems() {
        items.add(new Bow());
        items.add(new LeatherArmour());
    }

    // TODO setAbilities


    @Override
    public String toString() {
        return "Ranger";
    }
}
