package sample.Controller;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.javatuples.Quartet;
import sample.Model.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class YouPageController {

    @FXML JFXListView Timeline;
    @FXML JFXButton toHomePage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toDietPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toSocialPage;

    @FXML
    public void initialize() throws IOException {
        Account a = Account.getInstance();

        ArrayList<LocalDate> timeLineDates = new ArrayList<>(); //an arraylist of datetime objects
        LocalDate firstDateOnLine = LocalDate.now().minusDays(11); //this is what the start date will be on the screen
        a.getAccountLists().readMeals();
        System.out.println(a.getAllMyMeals().size());
        for (int i = 0; i <= 21; i++) {//3 week timespan
            timeLineDates.add(firstDateOnLine.plusDays(i));
            a.getAllMyMeals().clear();
            for (Meal m : a.getAllMyMeals()) {
                if (m.getMealDate().compareTo(timeLineDates.get(i)) == 0) {
                    a.getAllMyMeals().add(m);
                }
            }

        }

        // tying to make a arraylist of quartets
        ArrayList<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>> QuadList = new ArrayList<>();
        ArrayList<Goals> goalsTemp = new ArrayList<>();
        ArrayList<Activity.Activities> activitiesTemp = new ArrayList<>();

        for (LocalDate d : timeLineDates) {
            goalsTemp.clear();
            a.getMeal().getListOfFoods().clear();
            activitiesTemp.clear();
            if (a.getGoals().size() > 0) {
                for (Goals g : a.getGoals()) {
                    if (g.getEndDate().compareTo(d) == 0) {
                        goalsTemp.add(g);
                    } else goalsTemp.add(null);
                }
            }
            if (a.getMeal().getListOfFoods().size() > 0) {
                for (Meal m : a.getAllMyMeals()) {//TODO: create date data
                    if (m.getMealDate().compareTo(d) == 0) {
                        a.getAllMyMeals().add(m);
                    } else a.getMeal().getListOfFoods().add(null);
                }
            }
            //need Activities to be a class
//            if (a.getExercises().size()>0){
//                for(Activities ac: a.getExercises()) {
//                    if (ac.g(d) == 0) {
//                        activitiesTemp.add(ac);
//                    }
//                    else activitiesTemp.add(null);
//                }
//            }
            QuadList.add(new Quartet(d, new ArrayList<Goals>(goalsTemp), new ArrayList<>(a.getMeal().getListOfFoods()),
                    new ArrayList<Activity.Activities>(/*activitiesTemp*/)));
        }

        ObservableList<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>> ol;
        ol = FXCollections.observableArrayList(QuadList);
        System.out.println(QuadList);
        Timeline.setItems(ol);
        Timeline.setCellFactory(new Callback<JFXListView<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>>,
                ListCell<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>>>() {
            @Override
            public JFXListCell<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>>
            call(JFXListView<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>> p) {
                final JFXListCell<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>> cell
                        = new JFXListCell<Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>>>() {
                    @FXML
                    StackPane theStack;
                    @FXML
                    VBox mainV;
                    @FXML
                    VBox topV;
                    @FXML
                    VBox midV;
                    @FXML
                    VBox botV;

                    @FXML
                    Label dayLabel;
                    @FXML
                    Label dateLabel;


                    @FXML
                    Label goalType;
                    @FXML
                    Label goalStart;

                    @FXML
                    Label goalGoal;

                    @FXML
                    Label goalStatus;
                    @FXML
                    Label bCalLabel;

                    @FXML
                    Label lCalLabel;

                    @FXML
                    Label dCalLabel;

                    @FXML
                    Label sCalLabel;

                    @FXML
                    Label tCalLabel;

                    @FXML
                    Label actTotal;

                    @FXML
                    Label burntCals;


                    @FXML
                    private GridPane gridPane;

                    private FXMLLoader mLLoader;

                    @Override
                    public void updateItem(Quartet<LocalDate, ArrayList<Goals>, ArrayList<Meal>, ArrayList<Activity.Activities>> item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty || item == null) {

                            setText(null);
                            setGraphic(null);

                        } else {
                            if (mLLoader == null) {
                                mLLoader = new FXMLLoader(getClass().getResource("../View/MealListView.fxml"));
                                mLLoader.setController(this);

                                try {
                                    mLLoader.load();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                            String today = item.getValue0().getDayOfWeek().toString();
                            today = today.substring(0, 1) + today.substring(1).toLowerCase();
                            dayLabel.setText(today);
                            dateLabel.setText(item.getValue0().format(DateTimeFormatter.ofPattern("dd/MM")));
                            boolean onlynull = true;
                            if (item.getValue2() != null) {
                                for (Meal m : item.getValue2())
                                    if (m != null) onlynull = false;
                            }

                            System.out.println(item.getValue1());
                            if (!onlynull) {
                                int b = 0, l = 0, d = 0, s = 0, t = 0;
                                for (Meal m : item.getValue2()) {
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
                            setGraphic(theStack);
                        }
                    }
                };
                return cell;
            }
        });
        // MealTimeline.setMouseTransparent( true );
        Timeline.setFocusTraversable(false);
        Timeline.getSelectionModel().select(11);
        Timeline.scrollTo(12); //3 week scrollable period
    }

    public void toHomePage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toGoalsPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/GoalsSetting.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toSocialPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/SocialPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toDietPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/DietPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toActivityPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/ActivityPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void logOutButton (ActionEvent ae)throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
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
