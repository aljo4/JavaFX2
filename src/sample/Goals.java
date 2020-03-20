package sample;

import java.util.Date;

public class Goals {
    //Fields
    public enum goalType {
        WEIGHTGAIN("Weight Gain"), WEIGHTLOSS("Weight Loss"), DEFAULT("-Select-");

        private String type;

        goalType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    private Date startDate;
    private Date endDate;
    private double initialWeight;
    private double goalWeight;
    private double goalNutritionalAmount;
    private goalType GoalType;
    boolean isCompleted = false;

    //Constructor
    Goals(goalType GoalType, double initialWeight, double goalWeight, Date startDate, Date endDate, double goalNutritionalAmount) {
        this.initialWeight = initialWeight;
        this.startDate = startDate;
        this.endDate = endDate;
        this.GoalType = GoalType;
        this.goalNutritionalAmount = goalNutritionalAmount;
        this.goalWeight = goalWeight;
    }

    //Getters
    public double getInitialWeight(){
        return initialWeight;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
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

    public void setEndDate() {
        this.endDate = endDate;
    }

    public void setStartDate() {
        this.startDate = startDate;
    }
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
                        + "Start Date = " + startDate + "\'"
                        + "End Date = " + endDate + "\'"
                        +"Nutritional goal = " + goalNutritionalAmount +"}";
    }
}
