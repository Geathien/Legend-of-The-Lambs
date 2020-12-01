package be.vdab.java.legendOfTheLamb.items.packs;

import be.vdab.java.legendOfTheLamb.items.Item;

import java.util.List;

public interface Pack extends Item {

    void insertItem(Item item);
    void addGold(int amount);
    void removeItem(int index);
    void removeGold(int amount);
    void getItems();

}
