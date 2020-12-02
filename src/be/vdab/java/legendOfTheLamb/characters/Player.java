package be.vdab.java.legendOfTheLamb.characters;

import be.vdab.java.legendOfTheLamb.characters.abilities.Ability;
import be.vdab.java.legendOfTheLamb.characters.abilities.FighterAbility;
import be.vdab.java.legendOfTheLamb.characters.abilities.HealerAbility;
import be.vdab.java.legendOfTheLamb.characters.abilities.RangerAbility;
import be.vdab.java.legendOfTheLamb.characters.classes.CharacterClass;
import be.vdab.java.legendOfTheLamb.characters.classes.Fighter;
import be.vdab.java.legendOfTheLamb.characters.classes.Healer;
import be.vdab.java.legendOfTheLamb.characters.classes.Ranger;
import be.vdab.java.legendOfTheLamb.characters.races.Dwarf;
import be.vdab.java.legendOfTheLamb.characters.races.Elf;
import be.vdab.java.legendOfTheLamb.characters.races.Human;
import be.vdab.java.legendOfTheLamb.characters.races.Race;

public class Player {
    private Race race;
    private CharacterClass characterClass;
    private String name;
    private Ability ability;
    private int[] standardArray = new int[]{16, 14, 14, 13, 11, 8};

    public Player(String race, String characterClass, String name){
        setName(name);
        setRace(race);
        setCharacterClass(characterClass);
        setStats();
        setHP();
        setLvl(1);
        setAC();
        setSpeed();
        setAbility();
    }

    int HP;
    int AC;
    int speed;
    int initiative;
    int lvl;
    int xp = 0;

    int strength;
    int constitution;
    int dexterity;
    int wisdom;
    int intelligence;
    int charisma;

    public void setStats(){
        checkCharacterClass();
        checkRace();
    }

    public void checkRace(){
        switch (race.getRace()){
            case "Human":
                strength += 1;
                constitution += 1;
                dexterity += 1;
                wisdom += 1;
                intelligence += 1;
                charisma += 1;
                break;
            case "Elf":
                dexterity += 2;
                intelligence += 2;
                break;
            case "Dwarf":
                strength += 2;
                constitution += 2;
                break;
        }
    }

    public void checkCharacterClass(){
        switch (characterClass.getCharacterClass()){
            case "Fighter":
                strength += standardArray[0];
                constitution += standardArray[1];
                wisdom += standardArray[2];
                charisma += standardArray[3];
                dexterity += standardArray[4];
                intelligence += standardArray[5];
                break;
            case "Ranger":
                dexterity += standardArray[0];
                intelligence += standardArray[1];
                constitution += standardArray[2];
                wisdom += standardArray[3];
                charisma += standardArray[4];
                strength += standardArray[5];
                break;
            case "Healer":
                wisdom += standardArray[0];
                charisma += standardArray[1];
                constitution += standardArray[2];
                intelligence += standardArray[3];
                dexterity += standardArray[4];
                strength += standardArray[5];
                break;
        }
    }

    public void setRace(String race) {
        switch (race){
            default:
                System.out.println("Please choose Human, Dwarf or Elf");
                break;
            case "Human":
                this.race = new Human();
                break;
            case "Dwarf":
                this.race = new Dwarf();
                break;
            case "Elf":
                this.race = new Elf();
                break;
        }
    }

    public void setCharacterClass(String characterClass) {
        switch (characterClass){
            default:
                System.out.println("Please choose Fighter, Ranger or Healer");
                break;
            case "Fighter":
                this.characterClass = new Fighter();
                break;
            case "Ranger":
                this.characterClass = new Ranger();
                break;
            case "Healer":
                this.characterClass = new Healer();
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;

    }

    public void setAC() {
        int adjective =0;
        switch (characterClass.getCharacterClass()) {
            case "Fighter":
                adjective = (int) Math.floor((strength - 10) / 2);
                break;
            case "Ranger":
                adjective = (int) Math.floor((dexterity - 10) / 2);
                break;
            case "Healer":
                adjective = (int) Math.floor((dexterity - 5) / 2);
                break;
        }
        this.AC = characterClass.getArmour() + adjective;
    }

    public void setSpeed(){
        int adjective = Math.max(getDexterity(),getConstitution());
        this.speed = race.getBaseSpeed()+(int) Math.floor((adjective-10)/2);
    }

    public Race getRace() {
        return race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public int[] getStandardArray() {
        return standardArray;
    }

    public void setHP() {
        this.HP = characterClass.getHP();
    }
    public void newHP(int HP){ this.HP= HP;}

    public int getHP() {
        return HP;
    }

    public int getAC() {
        return AC;
    }

    public int getSpeed() {
        return speed;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getStrength() {
        return strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setAbility(){
        switch (characterClass.getCharacterClass()){
            case "Fighter":
                this.ability=new FighterAbility(this);
                break;
            case "Ranger":
                this.ability=new RangerAbility(this);
                break;
            case "Healer":
                this.ability=new HealerAbility(this);
                break;

        }
    }
    public Ability getAbility(){
        return this.ability;
    }

    @Override
    public String toString() {
        return name + "{"+
                "race=" + race +
                ", characterClass=" + characterClass +
                ", HP=" + HP +
                ", AC=" + AC +
                ", speed=" + speed +
                ", lvl=" + lvl +
                ", xp=" + xp +
                ", strength=" + strength +
                ", constitution=" + constitution +
                ", dexterity=" + dexterity +
                ", wisdom=" + wisdom +
                ", intelligence=" + intelligence +
                ", charisma=" + charisma +
                '}';
    }
}
