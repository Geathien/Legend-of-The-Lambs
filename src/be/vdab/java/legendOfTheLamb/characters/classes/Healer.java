package be.vdab.java.legendOfTheLamb.characters.classes;

import be.vdab.java.legendOfTheLamb.items.Item;
import be.vdab.java.legendOfTheLamb.items.armour.Armour;
import be.vdab.java.legendOfTheLamb.items.armour.Clothes;
import be.vdab.java.legendOfTheLamb.items.packs.ClericalBackpack;
import be.vdab.java.legendOfTheLamb.items.weapons.Dagger;
import be.vdab.java.legendOfTheLamb.items.weapons.HolySymbol;
import be.vdab.java.legendOfTheLamb.randomNumberGenerator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Healer implements CharacterClass {
    ClericalBackpack backpack = new ClericalBackpack();
    private String characterClass = "Healer";
    private int armourBase = 4;
    private int lifeDice = 6;
 //   List<Item> items = new ArrayList<>();
    private int HP;
    private String description = "The healer is a support class that can not take many hits, but can support other creatures," +
            " or release the wrath of the gods on monsters." +
            " A Healer casts spells instead of using weapons.";
    RandomNumberGenerator RNG = new RandomNumberGenerator();

    public Healer(){
        setHP();
        setItems();
    }

    @Override
    public String getCharacterClass() {
        return this.characterClass;
    }

    public int getABItem() {
        Armour armour = (Armour)backpack.getItem(1);
        return armour.armourBase();
    }

    public int getArmour(){
        return getArmourBase()+getABItem();
    }

    @Override
    public int getArmourBase() {
        return this.armourBase;
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

//    public List<Item> getItems() {
//        return items;
//    }

    public void setItems() {
        backpack.insertItem(new HolySymbol());
        backpack.insertItem(new Clothes());
        backpack.insertItem(new Dagger());
        backpack.addGold(15);
    }

    // TODO setAbilities


    @Override
    public String toString() {
        return "Healer";
    }
}
