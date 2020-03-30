package sample;

import java.time.LocalDate;
public class Goals {

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

    //Fields
    private LocalDate startDate;
    private LocalDate endDate;
    private static double initialWeight;
    private double goalWeight;
    private double goalNutritionalAmount;
    private goalType GoalType;
    private double currentWeight;


    //Constructors
    public Goals(){}

    public Goals(goalType GoalType, double currentWeight, double goalWeight, LocalDate startDate, LocalDate endDate) {
        this.GoalType = GoalType;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Goals(goalType GoalType, double initialWeight, double goalWeight, LocalDate startDate, LocalDate endDate, double goalNutritionalAmount) {
        this.initialWeight = initialWeight;
        this.startDate = startDate;
        this.endDate = endDate;
        this.GoalType = GoalType;
        this.goalNutritionalAmount = goalNutritionalAmount;
        this.goalWeight = goalWeight;
    }

    //Method
    public static boolean goalCompletion(double currentWeight, double goalWeight, LocalDate endDate) {
        boolean isCompleted = false;
        if (currentWeight == goalWeight && LocalDate.now().isBefore(endDate)) {
            isCompleted = true;
        }
        return isCompleted;
    }


    //Getters
    public double getInitialWeight() {
        return initialWeight;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getGoalWeight() {
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
    public static double goalPercentage(double initialWeight, double goalWeight) {
        return initialWeight * 100 / goalWeight;
    }

    public String toString() {
        return
                "Goals {" + "Goal Type = " + GoalType + "  ,  "
                        + "Current Weight = " + currentWeight + "kg  ,  "
                        + "Goal Weight = " + goalWeight + "kg  ,  "
                        + "Start Date = " + startDate + "  ,  "
                        + "End Date = " + endDate + "  ,  "
                        + "Nutritional goal = " + goalNutritionalAmount + "}";
    }
}
