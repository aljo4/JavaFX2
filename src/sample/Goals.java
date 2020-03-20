package sample;

public class Goals {
    //Fields
    public enum goalType {
        WEIGHTGAIN("Weight Gain"), WEIGHTLOSS("Weight Lost"), DEFAULT("-Select-");

        private String type;

        goalType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }
    private int daysLeftTarget;
    private double initialWeight;
    private double goalWeight;
    private double goalNutritionalAmount;
    private goalType GoalType;

    //Constructor
    Goals(goalType GoalType, double initialWeight, double goalWeight, int daysLeftTarget, double goalNutritionalAmount){
        this.initialWeight = initialWeight;
        this.daysLeftTarget = daysLeftTarget;
        this.GoalType = GoalType;
        this.goalNutritionalAmount = goalNutritionalAmount;
        this.goalWeight = goalWeight;
    }

    //Getters
    public double getInitialWeight(){
        return initialWeight;
    }
    public int getDaysLeftTarget(){
        return daysLeftTarget;
    }
    public double getGoalWeight(){
        return goalWeight;
    }
    public goalType getGoalType(){
        return GoalType;
    }

    public double getGoalNutritionalAmount(){
        return goalNutritionalAmount;
    }

    //Setters
    public void setInitialWeight(){this.initialWeight = initialWeight;}
    public void setDaysLeftTarget(){this.daysLeftTarget = daysLeftTarget;}
    public void setGoalWeight(){this.goalWeight = goalWeight;}
    public void setGoalType(){this.GoalType = GoalType;}
    public void setGoalNutritionalAmount(){this.goalNutritionalAmount = goalNutritionalAmount;}

    //Progression calculator
    public static void goalPercentage(){
        //int x = goalWeight - initialWeight;
        //int y = currentWeight - initialWeight;
        //int calculator = (y*100)/x;
        //System.out.print("Goal progression is " +calculator+"%");
    }
    public String toString(){
        return
                "Goals {"+"Goal Type = " + GoalType + "\'"
                        +"Goal Weight = " + goalWeight + "\'"
                        +"Days Left to Fulfill Goal = " + daysLeftTarget + "\'"
                        +"Nutritional goal = " + goalNutritionalAmount +"}";
    }
}
