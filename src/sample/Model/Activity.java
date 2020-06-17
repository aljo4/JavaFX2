package sample.Model;

import java.time.LocalDate;

public class Activity {

    private Activities activitiesEnum;
    private LocalDate dayCreated;

    public enum Activities {
        RUNNING("Running", 0, 0),
        JOGGING("Jogging", 0, 0),
        SWIMMING("Swimming", 0, 0),
        SQUATS("Sqauts", 0, 0),
        CYCLING("Cycling", 0, 0),
        DEADLIFTS("Deadlifts", 0, 0),
        ROWS("Rows", 0, 0),
        PUSHUPS("Pushups", 0, 0),
        PULLUPS("Pullups", 0, 0),
        BICEPCURLS("Bicep Curls", 0, 0),
        CALFRAISES("Calf raises", 0, 0),
        PLANKS("Planks", 0, 0),
        BURPEES("Burpees", 0, 0),
        BRIDGEHOLD("Bridgehold", 0, 0),
        SITUPS("Sit ups", 0, 0);

        public int getRepetitions() {
            return repetitions;
        }

        public void setRepetitions(int repetitions) {
            this.repetitions = repetitions;
        }

        private String title;
        private int duration;
        private int repetitions;

        Activities(String title, int duration, int repetitions) {
            this.title = title;
            this.duration = duration;
            this.repetitions = repetitions;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getDuration() {
            return duration;
        }

        public int setDuration(int duration) {
            return this.duration = duration;
        }

        @Override
        public String toString() {
            return title;
        }


        public String toStringtoFile() {
            return "Exercise: " + title + " " + " duration: " + duration + "," + " Number of reps: " + repetitions;
        }
    }

    public Activity(Activities activities, LocalDate day) {
        this.activitiesEnum = activities;
        this.dayCreated = LocalDate.now();
    }

    public Activities getActivitiesEnum() {
        return activitiesEnum;
    }

    public void setActivitiesEnum(Activities activities) {
        this.activitiesEnum = activities;
    }

    public LocalDate getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(LocalDate dayCreated) {
        this.dayCreated = dayCreated;
    }
}