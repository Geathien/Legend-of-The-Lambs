package be.vdab.java.legendOfTheLamb.items.armour;

public class LeatherArmour implements Armour {
    @Override
    public String armourName() {
        return "LeatherArmour";
    }

    @Override
    public int armourBase() {
        return 8;
    }

    @Override
    public String description() {
        return "A rough animal hide that is tanned and tailored to the user. Great for agile work.";
    }

}
