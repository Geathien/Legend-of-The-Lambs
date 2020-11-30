package be.vdab.java.legendOfTheLamb.items.armour;

public class Clothes implements Armour {
    @Override
    public String armourName() {
        return "Clothes";
    }

    @Override
    public int armourBase() {
        return 4;
    }

    @Override
    public String description() {
        return "A linen or woollen tunic that will rip with the slightest touch.";
    }
}
