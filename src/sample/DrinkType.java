package sample;

public class DrinkType {
     public enum Drinks{
         WATER(0),
         COFFEE(0),
         TEA(0),
         ALCOHOL(0),
         SOFTDRINKS(0),
         JUICES(0),
         ENERGYDRINKS(0);

         private int calories;

         Drinks(int calories){
             this.calories = calories;
         }

         public int getCalories() {
             return calories;
         }

         public void setCalories(int calories) {
             this.calories = calories;
         }
     }
     private Drinks drink;

    public DrinkType(Drinks drink) {
        this.drink = drink;
    }

    public Drinks getDrink() {
        return drink;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    public static void main(String[] args) {
        DrinkType aDrink = new DrinkType(Drinks.WATER);
        aDrink.getDrink().WATER.setCalories(23);//water has already been assigned
        System.out.println(aDrink.getDrink().WATER.getCalories());
    }
}
