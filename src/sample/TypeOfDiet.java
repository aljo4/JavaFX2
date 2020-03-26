package sample;


public class TypeOfDiet{
    public enum Diets {
        Paleo(0),
        Vegan(0),
        LowCarb(0),
        Dukan(0),
        UltraLowFat(0),
        Atkins(0),
        HCG(0),
        Zone(0),
        IntermittentFasting(0);

        private int calories;

        Diets(int calories) {
            this.calories = calories;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }
    }
    private Diets diet;
    public TypeOfDiet(Diets diet){this.diet= diet;}


















    }
