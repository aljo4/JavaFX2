package sample;



public class Meal {
    public enum mealType{
        BREAKFAST,
        LUNCH,
        DINNER;
        mealType() {
        }
    }
    private mealType mealtype;
    private FoodType foods;
    private DrinkType drinks;
    private int portionSize; //will this be used?
    private int caloricIntake; //will this be used?

    public Meal() {
        this.foods = foods;
        this.drinks = drinks;
        this.portionSize = portionSize;
        this.caloricIntake = caloricIntake;
        this.mealtype = mealtype;
    }


    public FoodType getFoods() {
        return foods;
    }

    public mealType getMealtype() {
        return mealtype;
    }

    public void setMealtype(mealType mealtype) {
        this.mealtype = mealtype;
    }

    public void setDrinks(DrinkType drinks) {
        this.drinks = drinks;
    }

    public DrinkType getDrinks() {
        return drinks;
    }

    public void setFoods(FoodType foods) {
        this.foods = foods;
    }

    public int getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(int portionSize) {
        this.portionSize = portionSize;
    }

    public int getCaloricIntake() {
        return caloricIntake;
    }

    public void setCaloricIntake(int caloricIntake) {
        this.caloricIntake = caloricIntake;

    }

    public void calculateCaloriesLeftForDay(){

    }

    public void calculateDailyCaloricIntake(){}

    @Override
    public String toString() {
        return "Meal{" +
                "mealtype=" + mealtype +
                ", foods=" + foods +
                ", drinks=" + drinks +
                ", portionSize=" + portionSize +
                ", caloricIntake=" + caloricIntake +
                '}';
    }
}
