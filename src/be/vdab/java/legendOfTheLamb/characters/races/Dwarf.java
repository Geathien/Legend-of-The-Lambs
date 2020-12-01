package be.vdab.java.legendOfTheLamb.characters.races;

public class Dwarf implements Race {
    private String race = "Dwarf";
    private int baseSpeed = 5;
    private String description = "Dwarves are masters of mountain and hills." +
            " They live mostly under ground and are quite grumpy by nature." +
            " But once you have the trust of a dwarf, they do everything for you, albeit with a grumble and a snort.";

    @Override
    public String getRace() {
        return this.race;
    }

    @Override
    public int getBaseSpeed() {
        return this.baseSpeed;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Dwarf";
    }
}
