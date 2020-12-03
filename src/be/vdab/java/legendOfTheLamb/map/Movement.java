package be.vdab.java.legendOfTheLamb.map;

public enum Movement {
    Z("north"),
    S("south"),
    Q("west"),
    D("east");

    String direction;

    Movement(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return this.direction;
    }
}
