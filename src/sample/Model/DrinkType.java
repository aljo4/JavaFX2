package sample.Model;

import java.util.ArrayList;
import java.util.Collections;

public class DrinkType {
    private ArrayList<String>Drinks;

    public DrinkType(){
        Drinks = new ArrayList<String>(7);
        Drinks.add("Water");
        Drinks.add("Coffee");
        Drinks.add("Tea");
        Drinks.add("Alcohol");
        Drinks.add("Soft Drinks");
        Drinks.add("Juices");
        Drinks.add("Energy Drinks");


    }

    public ArrayList<String> getDrinks() {
        return Drinks;
    }

    public void setDrinks(ArrayList<String> drinks) {
        Drinks = drinks;
    }

    public void addToDrinks(String drink){
        Drinks.add(drink);
    }
}
