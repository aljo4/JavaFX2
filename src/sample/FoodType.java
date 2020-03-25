package sample;

public class FoodType {
    public enum Foods {
        LEGUMES(0),
        NUTS(0),
        SEEDS(0),
        BREADS(0),
        DAIRYPRODUCTS(0),
        EGGS(0),
        CHICKEN(0),
        BEEF(0),
        LAMB(0),
        LIVER(0),
        PORK(0),
        CEREALS(0),
        SEAFOODS(0),
        SOUPS(0),
        PIES(0),
        STEWS(0),
        PASTAS(0),
        RICE(0);

        private int calories;

        Foods(int calories) {
            this.calories = calories;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }
    }

    private Foods food;

    public Foods getFood() {
        return food;
    }

    public void setFood(Foods food) {
        this.food = food;
    }

    public FoodType(Foods food) {
        this.food = food;
    }



    public void displayCaloriesForFood() {

    }//returns the ordinal value of enum


    public static void main(String[] args) {
        System.out.println("hello");
        FoodType aFood = new FoodType(Foods.SEAFOODS);
        aFood.getFood().SEAFOODS.setCalories(43);//you don't even have to call seafoods here it has already been assigned
        System.out.println(aFood.getFood().SEAFOODS.getCalories());

    }
}