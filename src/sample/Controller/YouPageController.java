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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
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

    @FXML Label noWorkouts;
    @FXML BarChart goalCharts;
    @FXML Label totalGoals;
    @FXML LineChart activityBarChart;
    @FXML JFXListView Timeline;
    @FXML JFXButton toHomePage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toDietPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toSocialPage;

    @FXML
    public void initialize() throws IOException {
        Account a = Account.getInstance();
        a.getAccountLists().readMeals();
        a.getAccountLists().readGoals();

        ArrayList<Activity> workoutData = a.getAccountLists().readActivities();
        XYChart.Series series = new XYChart.Series();
        series.setName("Activty graph");
        for (int i=0; i<workoutData.size(); i++){
            series.getData().add(new XYChart.Data(workoutData.get(i).getActivitiesEnum().getTitle(), workoutData.get(i).getActivitiesEnum().getRepetitions()));
            }
            activityBarChart.getData().add(series);

        int goalCompleteNumber =0;
        for (Goals g: a.getGoals()){
            if (g.getIsComplete() == true){
                goalCompleteNumber++;
            }
        }
        int numberOfWorkouts =0;
        for (Activity number: a.getWorkouts()){
            numberOfWorkouts++;
        }
        noWorkouts.setText(String.valueOf(numberOfWorkouts));
        totalGoals.setText(String.valueOf(goalCompleteNumber));
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Goals");
        for(int i=0; i<a.getGoals().size(); i++){
            series1.getData().add(new XYChart.Data(a.getGoals().get(i).getGoalType().toString(),a.getGoals().get(i).getGoalWeight()));
        }
        goalCharts.getData().add(series1);
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
