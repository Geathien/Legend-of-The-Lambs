package be.vdab.java.legendOfTheLamb.characters.races;

public class Human implements Race {
    private String race = "Human";
    private int baseSpeed = 6;
    private String description = "The human race can be found everywhere in the world of Letla." +
        " They have multiple cultures and are aligned to the entire spectrum of good and evil." +
        " There are many noble Paladin warriors, Holy Clerical men and ruthless fighters to choose from.";


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
        return "Human";
    }
}
