package sample;

import java.util.ArrayList;

public class FoodType {
    private static ArrayList<String> Foods;

    public FoodType() {
        Foods = new ArrayList<String>(18);
        Foods.add("Legumes");
        Foods.add("Nuts");
        Foods.add("Seeds");
        Foods.add("Breads");
        Foods.add("Dairy Products");
        Foods.add("Eggs");
        Foods.add("Chicken");
        Foods.add("Beef");
        Foods.add("Lamb");
        Foods.add("Liver");
        Foods.add("Pork");
        Foods.add("Cereals");
        Foods.add("Seafoods");
        Foods.add("Soups");
        Foods.add("Pies");
        Foods.add("Stews");
        Foods.add("Pastas");
        Foods.add("Rice");
    }


    public ArrayList<String> getFoods() {
        return Foods;
    }

    public void setFoods(ArrayList<String> foods) {
        Foods = foods;
    }

    public void addToFoods(String food){
        Foods.add(food);
    }

    @Override
    public String toString() {
        return "Food: " + Foods.toString();
    }
}