package sample;

public enum Activities {
    RUNNING("Running", 0),
    JOGGING("Jogging", 0),
    SWIMMING("Swimming", 0),
    SQUATS("Sqauts", 0),
    CYCLING("Cycling", 0),
    DEADLIFTS("Deadlifts", 0),
    ROWS("Rows", 0),
    PUSHUPS("Pushups",0),
    PULLUPS("Pullups", 0),
    BICEPCURLS("Bicep Curls", 0),
    CALFRAISES("Calf raises", 0),
    PLANKS("Planks", 0),
    BURPEES("Burpees",0),
    BRIDGEHOLD("Bridgehold", 0),
    SITUPS("Sit ups",0);

    private String title;
    private int duration;

     Activities(String title, int duration){
        this.title= title;
        this.duration = duration;
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
        return "Activities{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
