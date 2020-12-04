package be.vdab.java.legendOfTheLamb.characters.races;

import java.io.Serializable;

public interface Race extends Serializable {

    String getRace();

    int getBaseSpeed();

    String getDescription();

}
