package de.hftstuttgart.frontend;

import java.io.Serializable;

public class Person implements Serializable {

    public int id;
    public String name;

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}
