package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.*;
import java.time.LocalDate;


public class GoalSettingController implements Serializable {

    //Fields
    @FXML
    private JFXButton confirm;

    @FXML
    private JFXTextField TargetWeight;

    @FXML
    private ComboBox<Goals.goalType> CB;

    @FXML
    private DatePicker datePicker;

    @FXML
    private JFXButton gotoMyGoals;

    @FXML
    private JFXButton goBackbut;

    public GoalSettingController() {

    }


    public void initialize() throws IOException {
        Account.getInstance().getWeight();
        CB.getItems().addAll(Goals.goalType.values());
        CB.setValue(Goals.goalType.DEFAULT);
        datePicker.setValue(LocalDate.now());
        datePicker.setDayCellFactory(datePicker1 -> new DateCell() {
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        LocalDate today = LocalDate.now();

                        setDisable(empty || date.compareTo(today) < 0);
                    }
                }

        );
        TargetWeight.setStyle("-fx-text-inner-color: Black;");
    }

    //Action after the continue button is clicked
    public void continueBut(ActionEvent aE) throws IOException {
        Goals goal = null;
        if (TargetWeight.getText().isEmpty() || TargetWeight.getText().equals("Please insert weight")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please input Target Weight.");
            alert.showAndWait();
        } else if (CB.getSelectionModel().getSelectedItem() == Goals.goalType.DEFAULT) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a Goal Type!");
            alert.showAndWait();
        } else if (datePicker.getValue().equals(LocalDate.now())) {
            System.out.println(datePicker);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a Target date that is not today!");
            alert.showAndWait();
        } else if ((Account.getInstance().getWeight() == Double.parseDouble(TargetWeight.getText())) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTLOSS && !TargetWeight.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Goal reached");
            alert.setContentText(("If you want to set a new goal, you can make your target weight lower. Recommendation: 5-10kg lower"));
//            goal.CheckGoalCompletion(Account.getInstance().getWeight(),Double.parseDouble(TargetWeight.getText()),datePicker.getValue());
            goal = new Goals(CB.getSelectionModel().getSelectedItem(), Account.getInstance().getWeight(), Double.parseDouble(TargetWeight.getText()), LocalDate.now(), datePicker.getValue(), true);
            Account.getInstance().getAccountLists().saveCompleteGoalsToFile(goal);
            alert.showAndWait();
        } else if (Account.getInstance().getWeight() == Double.parseDouble(TargetWeight.getText()) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTGAIN && !TargetWeight.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Goal reached");
            alert.setContentText(("If you want to set a new goal, you can increase your target. Recommendation: 5-10kg higher"));
//            goal.setComplete(true);
            goal = new Goals(CB.getSelectionModel().getSelectedItem(), Account.getInstance().getWeight(), Double.parseDouble(TargetWeight.getText()), LocalDate.now(), datePicker.getValue(), true);
            Account.getInstance().getAccountLists().saveCompleteGoalsToFile(goal);
            alert.showAndWait();
        } else if ((Account.getInstance().getWeight() > Double.parseDouble(TargetWeight.getText())) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTGAIN) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Current weight can not be higher than Target weight!");
            alert.showAndWait();
        } else if (Account.getInstance().getWeight() < Double.parseDouble(TargetWeight.getText()) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTLOSS) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Current weight can not be lower than Target weight!");
            alert.showAndWait();
        } else {
            goal = new Goals(CB.getSelectionModel().getSelectedItem(), Account.getInstance().getWeight(), Double.parseDouble(TargetWeight.getText()), LocalDate.now(), datePicker.getValue(), false);
            Account.getInstance().getGoals().add(goal);
            Account.getInstance().getAccountLists().saveGoalToFile(goal);
            Account.getInstance().getAccountLists().saveToFile();
            Parent GoalsParent = FXMLLoader.load(getClass().getResource("../View/MyGoals.fxml"));
            Scene signUpViewScene = new Scene(GoalsParent);

            Stage window = (Stage) ((Node) aE.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.setResizable(true);
            window.show();
        }
    }

    public void gotoMyGoals(ActionEvent actionEvent) throws Exception {
        Parent myGoalsParent = FXMLLoader.load(getClass().getResource("../View/MyGoals.fxml"));
        Scene signUpViewScene = new Scene(myGoalsParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();

    }

    public void goBackbut(ActionEvent aE) throws IOException {
        Parent myGoalsParent = FXMLLoader.load(getClass().getResource("../View/Homepage.fxml"));
        Scene signUpViewScene = new Scene(myGoalsParent);
        Stage window = (Stage) ((Node) aE.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }
}
