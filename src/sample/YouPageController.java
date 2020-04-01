package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

public class YouPageController {

    @FXML JFXListView goalsTimeline;
    @FXML JFXListView MealTimeline;
    @FXML JFXListView ActivityTimeline;
    @FXML JFXButton toHomePage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toDietPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toSocialPage;
    ObservableList<ArrayList<Meal>> mealpop = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        //test data
        Edible e1 = new Edible(Edible.foodType.FOOD, "chicken", 200 );
        Edible e2 = new Edible(Edible.foodType.FOOD, "potato", 150 );
        Edible e3 = new Edible(Edible.foodType.DRINK, "Banana Milkshake", 180 );
        ArrayList<Edible> es = new ArrayList<>();
        es.add(e1);
        es.add(e3);
        es.add(e2);
        Meal aMeal = new Meal(Meal.mealType.LUNCH, es);
        Account.getInstance().getMeals().add(aMeal);
        //end of adding test object
        ArrayList<String> goalsList = new ArrayList<>();
        ArrayList<String> activitiesList = new ArrayList<>();

        Account a = Account.getInstance();

        ArrayList<LocalDate> timeLineDates= new ArrayList<>();
        LocalDate firstDateOnLine = LocalDate.now().minusDays(11);
        ArrayList<ArrayList<Meal>> mealsList = new ArrayList<>();
        ArrayList<Meal> temp = new ArrayList<>();
        for (int i = 0; i <= 21; i++){
            timeLineDates.add(firstDateOnLine.plusDays(i));
            temp.clear();
            for(Meal m: a.getMeals()){
                if (m.getMealDate().compareTo(timeLineDates.get(i))== 0){
                    temp.add(m);
                }
            }
            mealsList.add(temp);
            if(temp.size()>0)System.out.println(temp.get(0));
        }

        // tying to make a arraylist of pairs
        ArrayList<Pair<LocalDate, ArrayList<Meal>>> pairList = new ArrayList<>();
        ArrayList<Meal> tempForPairs = new ArrayList<>();
        for (LocalDate d: timeLineDates){
            tempForPairs.clear();
            if (a.getMeals().size()>0){
                for(Meal m: a.getMeals()) {
                    if (m.getMealDate().compareTo(d) == 0) {
                        tempForPairs.add(m);
                    }
                    else tempForPairs.add(null);
                }
            }
            pairList.add(new Pair(d, new ArrayList<>(tempForPairs)));
        }
        System.out.println(pairList);
        System.out.println(pairList.get(0));
        System.out.println(pairList.get(0).getKey());
        ObservableList<Pair<LocalDate, ArrayList<Meal>>> ol = FXCollections.observableArrayList(pairList);
        MealTimeline.setItems(ol);
       System.out.println( MealTimeline.getMaxHeight());
        MealTimeline.setCellFactory(new Callback<JFXListView<Pair<LocalDate, ArrayList<Meal>>>, ListCell<Pair<LocalDate, ArrayList<Meal>>>>() {
                                        @Override
                                        public JFXListCell<Pair<LocalDate, ArrayList<Meal>>> call(JFXListView<Pair<LocalDate, ArrayList<Meal>>> p) {
                                            final JFXListCell<Pair<LocalDate, ArrayList<Meal>>> cell = new JFXListCell<Pair<LocalDate, ArrayList<Meal>>>() {
                                                @FXML
                                                VBox base;

                                                @FXML
                                                Label dayLabel;
                                                @FXML Label dateLabel;

                                                @FXML Label bCalLabel;

                                                @FXML Label lCalLabel;

                                                @FXML Label dCalLabel;

                                                @FXML Label sCalLabel;

                                                @FXML Label tCalLabel;

                                                @FXML
                                                private GridPane gridPane;

                                                private FXMLLoader mLLoader;
                                                @Override
                                                public void updateItem (Pair<LocalDate, ArrayList<Meal>> item, boolean empty){
                                                    super.updateItem(item, empty);

                                                    if(empty || item == null) {

                                                        setText(null);
                                                        setGraphic(null);

                                                    }else {
                                                        if (mLLoader == null) {
                                                            mLLoader = new FXMLLoader(getClass().getResource("MealListView.fxml"));
                                                            mLLoader.setController(this);

                                                            try {
                                                                mLLoader.load();
                                                            } catch (IOException e) {
                                                                e.printStackTrace();
                                                            }

                                                        }

                                                        String today = item.getKey().getDayOfWeek().toString();
                                                        today = today.substring(0,1) + today.substring(1).toLowerCase();
                                                        dayLabel.setText(today);
                                                        dateLabel.setText(item.getKey().format(DateTimeFormatter.ofPattern("dd/MM")));
                                                        boolean onlynull = true;
                                                        if(item.getValue() != null)
                                                        {
                                                            for(Meal m : item.getValue())
                                                                if(m != null) onlynull = false;
                                                        }

                                                        System.out.println(item.getValue());
                                                        if (!onlynull) {
                                                            int b = 0, l = 0, d = 0, s = 0, t = 0;
                                                            for (Meal m : item.getValue()) {
                                                                if (m.getMealtype() == Meal.mealType.BREAKFAST) {
                                                                    bCalLabel.setText(String.valueOf(m.getCaloricIntake()));
                                                                    b += m.getCaloricIntake();
                                                                }
                                                                if (m.getMealtype() == Meal.mealType.LUNCH) {
                                                                    lCalLabel.setText((String.valueOf(m.getCaloricIntake())));
                                                                    l += m.getCaloricIntake();
                                                                }
                                                                if (m.getMealtype() == Meal.mealType.DINNER) {
                                                                    dCalLabel.setText((String.valueOf(m.getCaloricIntake())));
                                                                    d += m.getCaloricIntake();
                                                                }
                                                                if (m.getMealtype() == Meal.mealType.SNACK) {
                                                                    s += m.getCaloricIntake();
                                                                }

                                                            }
                                                            sCalLabel.setText(String.valueOf(s));
                                                            tCalLabel.setText(String.valueOf(b + l + d + s));

                                                        }
                                                        setText(null);
                                                        setGraphic(base);
                                                    }
                                                }
                                            };
                                            return cell;
                                        }
                                    });
                // MealTimeline.setMouseTransparent( true );
                MealTimeline.setFocusTraversable(false);
    }


    public void toHomePage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void toGoalsPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("GoalsPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void toSocialPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("SocialPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void toDietPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("DietPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void toActivityPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("ActivityPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void logOutButton (ActionEvent ae)throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Parent signUpParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene signUpViewScene = new Scene(signUpParent, 600, 400);
            Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.setResizable(false);
            window.show();
        }
    }

    public void populateMealsTimeline(ArrayList<Meal> dayMeals){

    }
}
