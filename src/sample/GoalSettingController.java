package sample;

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

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;



public class GoalSettingController implements Serializable {

    //Fields
    @FXML
    private JFXButton confirm;

    @FXML
    private JFXTextField CurrentWeight;

    @FXML
    private JFXTextField TargetWeight;

    @FXML
    private ComboBox<Goals.goalType> CB;

    @FXML
    private DatePicker datePicker;

    public GoalSettingController(){

    }

    public void initialize() {

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

    }

    //Action after the continue button is clicked
    public void continueBut(ActionEvent aE) throws IOException {
        Goals goal;

        if (CurrentWeight.getText().isEmpty() || TargetWeight.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please input Current weight or Target Weight.");
            alert.showAndWait();
        } else if (CB.getSelectionModel().getSelectedItem() == Goals.goalType.DEFAULT) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a Goal Type!");
            alert.showAndWait();
        } else if (datePicker.equals(LocalDate.now())) {
            System.out.println(datePicker);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a Target date that is not today!");
            alert.showAndWait();
        } else if (CurrentWeight.getText().equals(TargetWeight.getText()) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTLOSS && !CurrentWeight.getText().isEmpty() && !TargetWeight.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Goal reached");
            alert.setContentText(("If you want to set a new goal, you can make your target weight lower. Recommendation: 5-10kg lower"));
            alert.showAndWait();
        } else if (CurrentWeight.getText().equals(TargetWeight.getText()) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTGAIN && !CurrentWeight.getText().isEmpty() && !TargetWeight.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Goal reached");
            alert.setContentText(("If you want to set a new goal, you can increase your target. Recommendation: 5-10kg higher"));
            alert.showAndWait();
        } else if (Integer.parseInt(CurrentWeight.getText()) > Integer.parseInt(TargetWeight.getText()) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTGAIN) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Current weight can not be higher than Target weight!");
            alert.showAndWait();
        } else if (Integer.parseInt(CurrentWeight.getText()) < Integer.parseInt(TargetWeight.getText()) && CB.getSelectionModel().getSelectedItem() == Goals.goalType.WEIGHTLOSS) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Current weight can not be lower than Target weight!");
            alert.showAndWait();
        }
        else {
            goal = new Goals(CB.getSelectionModel().getSelectedItem(), Double.parseDouble(CurrentWeight.getText()), Double.parseDouble(TargetWeight.getText()), LocalDate.now(), datePicker.getValue());
            Account.getInstance().getGoals().add(goal);

            Parent GoalsParent = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
            Scene signUpViewScene = new Scene(GoalsParent);

            Stage window = (Stage) ((Node) aE.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.show();

        }
    }
}
