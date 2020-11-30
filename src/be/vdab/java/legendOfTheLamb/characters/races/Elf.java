package be.vdab.java.legendOfTheLamb.characters.races;

public class Elf implements Race {
    private String race = "Elf";
    private int baseSpeed = 7;
    private String description = "Elves are majestic beings who live in the higher spheres of longevity." +
            " An elf can get up to 2000years before perishing of this world." +
            " This makes them look down upon humans as these races struggle with meaningless wars that last only a couple of years.";

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
        return "Elf";
    }
}
