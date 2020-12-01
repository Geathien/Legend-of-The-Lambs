package be.vdab.java.legendOfTheLamb.items.packs;

import be.vdab.java.legendOfTheLamb.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backpack implements Pack {
    Scanner keyboard = new Scanner(System.in);
    List<Item> items = new ArrayList<>();
    int maxSize = 20;
    int maxGold = 500;
    int gold=0;


    @Override
    public void insertItem(Item item) {
        if(items.size()<maxSize) {
            items.add(item);
        }
        else {
            System.out.println("Your bag is already full");
        }
    }

    @Override
    public void addGold(int amount) {
        if(gold< maxGold){
        if(this.gold+amount<maxGold){
            this.gold+=amount;
        }
        else{
            this.gold=maxGold;
        }
        }
    }

    @Override
    public void removeItem(int index) {

        if(items.get(index)!= null){
            if (index == 1){
                System.out.println("you can't remove your armour");
            }
            else{
                items.remove(index);
            }
        }
        else{
            System.out.println("This spot is already empty");
        }

    }

    @Override
    public void removeGold(int amount) {
        if (this.gold>0){
            if (this.gold-amount>0){
                this.gold-=amount;
            }
            else{
                System.out.println("You don't have enough gold");
            }
        }else{
            System.out.println("You don't have enough gold");
        }
    }

    @Override
    public void getItems() {
        items.forEach(System.out::println);
    }
    public Item getItem(int index){
        while(items.get(index) == null){
            System.out.println("choose another spot");
            index = keyboard.nextInt();
        }

        return items.get(index);
    }
}
