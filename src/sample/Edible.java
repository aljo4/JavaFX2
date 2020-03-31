package sample;

import java.util.ArrayList;

public class Edible {

    public enum foodType{
        FOOD,
        DRINK;
        foodType() {
        }
    }

    private foodType fType;
    private String fName;
    private int calCount;


    public Edible(){
        this.fName = "null";
        this.calCount = 0;
    }

    public Edible(foodType fType, String fName, int calCount){
        this.fType = fType;
        this.fName = fName;
        this.calCount = calCount;
    }

    public foodType getfType() {
        return fType;
    }

    public int getCalCount() {
        return calCount;
    }

    public String getfName() {
        return fName;
    }

    public void setfType(foodType fType) {
        this.fType = fType;
    }

    public void setCalCount(int calCount) {
        this.calCount = calCount;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String toString() {
        return "Edible{" +
                "fType=" + fType +
                ", fName='" + fName + '\'' +
                ", calCount=" + calCount +
                '}';
    }

    public String foodForTimeline(){
        return fName + ", calories = " + calCount +"\n";
    }
}
