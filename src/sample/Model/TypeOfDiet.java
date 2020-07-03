package sample.Model;


import jdk.jfr.Description;

public class TypeOfDiet{
    public enum Diets {
        NoDiet(0,"N/A"),
        Paleo(1200,"no bread,no sugar, not milk, no rice, no corn, no beans, no potatoes"),
        Vegan(1500,"no meat,no chicken, no fish, no dairy, no animal based products"),
        LowCarb(1800,"no bread, no oils, no fruit, no juice, no fizzy drinks, no fats, no pasta"),
        Dukan(1000,"no red meat, no dairy, no processed foods, no refined sugars, no fats"),
        UltraLowFat(1800,"mainly plant-based foods, reduce intake of animal products"),
        Atkins(1800,"no sugar, no grains, no vegetable oils"),
        HCG(500,"no butter, no oils,no sugar"),
        Zone(1500,"no processed grains, no potatoes, no egg yolks, no organ meets, no soda"),
        IntermittentFasting(3000,"eating full meals every other day");

        //TODO: display diet on homepage



        private int calories;
        private String description;


        Diets(int calories,String description){
            this.calories = calories;
            this.description =description;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    private Diets chosenDiet;


    public TypeOfDiet(Diets diet){
        this.chosenDiet= diet;
    }

    @Override
    public String toString() {
        return Account.getInstance().getFullname() + ","+ chosenDiet + "," + chosenDiet.calories;
    }

    public String toStringForScreen(){
        return chosenDiet + "";
    }


    public Diets getChosenDiet() {
        return chosenDiet;
    }

    public void setChosenDiet(Diets chosenDiet) {
        this.chosenDiet = chosenDiet;
    }
}
