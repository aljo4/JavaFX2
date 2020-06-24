package sample.Model;

import java.time.LocalDate;

public class Goals {

    public enum goalType {
        WEIGHTGAIN("Weight-Gain".trim()), WEIGHTLOSS("Weight-Loss".trim()), DEFAULT("-Select-".trim());

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
    private static double initialWeight = Account.getInstance().getWeight();
    private double goalWeight;
    private double goalNutritionalAmount;
    private goalType GoalType;
    private double currentWeight;
    private boolean isComplete;

    //Constructors
    public Goals() {
    }

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
    public Boolean goalCompletion(double currentWeight, double goalWeight, LocalDate endDate) {
        if (currentWeight >= goalWeight && LocalDate.now().isBefore(endDate)) {
            isComplete = true;
            setInitialWeight(currentWeight);
        }
        return true;
    }

    //Setters
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public static void setInitialWeight(double initialWeight) {
        Goals.initialWeight = initialWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public void setGoalNutritionalAmount(double goalNutritionalAmount) {
        this.goalNutritionalAmount = goalNutritionalAmount;
    }

    public void setGoalType(goalType goalType) {
        GoalType = goalType;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
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

    public goalType getGoalType() {
        return GoalType;
    }

    public double getGoalNutritionalAmount() {
        return goalNutritionalAmount;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    //Progression calculator
//    public  double goalPercentage(double currentWeight, double goalWeight) {
//        double limit;
//        double tracker;
//        limit = goalWeight - initialWeight;
//        tracker = goalWeight - currentWeight;
//        double percentage = tracker
//    }

    public String toString() {
        return
                (Account.getInstance().getName() + "," + GoalType + ","
                        + currentWeight + ","
                        + +goalWeight + ","
                        + startDate + ","
                        + endDate);
    }

    public String stringForTimeline() {
        return "Target Date: " + endDate + "\n"
                + "Starting Weight: " + initialWeight + "\n"
                + "Target Weight: " + goalWeight + "\n";
    }

}
