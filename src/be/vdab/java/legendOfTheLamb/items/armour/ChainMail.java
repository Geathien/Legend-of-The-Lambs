package be.vdab.java.legendOfTheLamb.items.armour;

public class ChainMail implements Armour {

    @Override
    public String armourName() {
        return "Chainmail";
    }

    @Override
    public int armourBase() {
        return 10;
    }

    @Override
    public String description() {
        return "Many small rings make one big strong jacket.";
    }
}
