package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import sample.Model.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class DietPageController {

    @FXML Label currentCal;
    @FXML Label dietName;
    @FXML Label totalCal;
    @FXML JFXButton toHomePage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toSocialPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toYouPage;
    @FXML MenuButton logout;
    @FXML BarChart barChart;


    @FXML
    public void initialize()throws Exception{
        Account a = Account.getInstance();
        a.getAccountLists().readDietPlan();

        String nameOfDiet;

        nameOfDiet = a.getTypeOfDiet().toStringForScreen();
        dietName.setText(nameOfDiet);
        totalCal.setText(String.valueOf(a.getTypeOfDiet().getChosenDiet().getCalories()));

        int currentCalorie =0;
        for (Meal m:a.getAllMyMeals()) {
            if(m.getMealDate().compareTo(LocalDate.now())==0){
                currentCalorie += m.getCaloricIntake();
            }
        }
        currentCal.setText(String.valueOf(currentCalorie));

        if (currentCalorie > a.getTypeOfDiet().getChosenDiet().getCalories()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("You have eaten more calories than prescribed diet!");
            alert.showAndWait();
        }
        ArrayList<Meal> foodData = a.getAccountLists().readMeals();
        XYChart.Series series = new XYChart.Series<>();
        series.setName("Calories");
        for (int i =0; i<foodData.size(); i++){
            series.getData().add(new XYChart.Data(foodData.get(i).getMealDate().toString(),foodData.get(i).getCaloricIntake()));
        }
        barChart.getData().add(series);

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

    public void toYouPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/YouPage.fxml"));
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

    public void toDietSelection(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/DietCreatePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent, 600, 400);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(false);
        window.show();
    }

    public void toEatPage(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/MealsInput.fxml"));
        Scene signUpViewScene = new Scene(signUpParent, 640, 600);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(false);
        window.show();
    }
}
