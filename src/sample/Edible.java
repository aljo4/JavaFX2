package sample;

import java.util.ArrayList;

public class Edible<FoodType,DrinkType> {
    private String Drink;
    private int drinkCalCount;
    private String Food;
    private int foodCalCount;

    public Edible(){
        this.Drink = "null";
        this.Food = "null";
        this.drinkCalCount =0;
        this.foodCalCount = 0;
    }

    public Edible(String drink, int drinkCalCount, String food, int foodCalCount) {
        Drink = drink;
        this.drinkCalCount = drinkCalCount;
        Food = food;
        this.foodCalCount = foodCalCount;
    }


    public String getDrink() {
        return Drink;
    }

    public void setDrink(String drink) {
        Drink = drink;
    }

    public int getDrinkCalCount() {
        return drinkCalCount;
    }

    public void setDrinkCalCount(int drinkCalCount) {
        this.drinkCalCount = drinkCalCount;
    }

    public String getFood() {
        return Food;
    }

    public void setFood(String food) {
        Food = food;
    }

    public int getFoodCalCount() {
        return foodCalCount;
    }

    public void setFoodCalCount(int foodCalCount) {
        this.foodCalCount = foodCalCount;
    }

    @Override
    public String toString() {
        return Drink + "," + drinkCalCount + "," +Food + "," +  foodCalCount;
    }



    public String foodForTimeline(){
        return Food + ", calories = " + foodCalCount +"\n";
    }
}
