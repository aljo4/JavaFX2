package sample;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Meal {
    public enum mealType{
        BREAKFAST,
        LUNCH,
        DINNER,
        SNACK;
        mealType() {
        }
    }
    private mealType mealtype;
    private ArrayList<Edible> food;
    private int caloricIntake; //will this be used?
    private LocalDate mealDate;

    public Meal() {
        this.food = food;
        this.caloricIntake = caloricIntake;
        this.mealtype = mealtype;
    }

    public Meal(mealType mealtype, ArrayList<Edible> food){
        this.mealtype = mealtype;
        this.food = food;
        this.mealDate = LocalDate.now();
        int cals = 0;
        for (Edible e:food){
            cals+=e.getCalCount();
        }
        this.caloricIntake = cals;
    }


    public ArrayList<Edible> getFood() {
        return food;
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

    public void setFood(ArrayList<Edible> food) {
        this.food = food;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public void calculateCaloriesLeftForDay(){
    }

    public void calculateDailyCaloricIntake(){
    }

    @Override
    public String toString() {
        return "some text here";
    }

    public String toStringForMeals(){
        return "Type of Meal: " + mealtype + "\n"+ "Total Calories: " + caloricIntake;
    }
}
