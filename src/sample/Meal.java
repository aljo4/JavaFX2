package sample;


import java.time.LocalDate;
import java.util.ArrayList;

public class Meal {
    public enum mealType{
        BREAKFAST,
        LUNCH,
        DINNER,
        SNACK;
        mealType() {
        }
    }
    private mealType mealtype; //every meal object will have an enum
    private ArrayList<Meal> listOfFoods; //arraylist of edible which that class has enum to specify whether food or drink
    private int caloricIntake; //combine calorie for meal
    private LocalDate mealDate; //when you ate
    private Edible eat;


    public Meal(mealType mealtype, Edible eat){
        this.mealtype = mealtype;
        listOfFoods = new ArrayList<>(43);
        this.mealDate = LocalDate.now();
        this.eat = eat;
//        int cals = 0;
//        for (Edible e:food){
//            cals+=e.getDrinkCalCount()+e.getFoodCalCount();
//        }
//        this.caloricIntake = cals;
    }

    public Meal() {
        this.mealtype = mealtype;
        listOfFoods = new ArrayList<>();
        this.mealDate = LocalDate.now();
        this.eat = eat;

    }

    public ArrayList<Meal> getListOfFoods() {
        return listOfFoods;
    }

    public LocalDate getMealDate() {
        return mealDate;
    }

    public mealType getMealtype() {
        return mealtype;
    }

    public void setMealtype(mealType mealtype) {
        this.mealtype = mealtype;
    }

    public int getCaloricIntake() {
        return caloricIntake;
    }

    public void setCaloricIntake(int caloricIntake) {
        this.caloricIntake = caloricIntake;
    }

    public void setListOfFoods(ArrayList<Meal> listOfFoods) {
        this.listOfFoods = listOfFoods;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public void calculateCaloriesLeftForDay(){
    }

    public Edible getEat() {
        return eat;
    }

    public void setEat(Edible eat) {
        this.eat = eat;
    }

    public void calculateDailyCaloricIntake(){
    }
    public void addToMeals(Meal meal){
        listOfFoods.add(meal);
    }

    public Meal(mealType mealtype, ArrayList<Meal> listOfFoods, int caloricIntake, LocalDate mealDate) {
        this.mealtype = mealtype;
        this.listOfFoods = listOfFoods;
        this.caloricIntake = caloricIntake;
        this.mealDate = mealDate;
    }

    public String toStringForMeals(){
        return eat + "," + mealtype + "," + caloricIntake;
    }


}
