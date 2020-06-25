package sample.Model;


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
    private ArrayList<Edible> listOfFoods; //arraylist of edible which that class has enum to specify whether food or drink
    private int caloricIntake; //combine calorie for meal
    private LocalDate mealDate; //when you ate
    private Edible eat;
    private Account account = Account.getInstance();


    public Meal(mealType mealtype, Edible eat, LocalDate mealDate){
        this.mealtype = mealtype;
        listOfFoods = new ArrayList<>(43);
        this.mealDate = mealDate;
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

    public ArrayList<Edible> getListOfFoods() {
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

    public void setListOfFoods(ArrayList<Edible> listOfFoods) {
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
    public void addToMeals(Edible edible){
        listOfFoods.add(edible);
    }

    public Meal(mealType mealtype, ArrayList<Edible> listOfFoods, int caloricIntake, LocalDate mealDate) {
        this.mealtype = mealtype;
        this.listOfFoods = listOfFoods;
        this.caloricIntake = caloricIntake;
        this.mealDate = mealDate;
    }

    public String toStringForMeals(){
         return Account.getInstance().toStringForFileAppend() + "," + eat + "," + mealtype + "," + caloricIntake +  "," + mealDate;
    }


}
