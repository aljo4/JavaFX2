package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;

import java.io.Serializable;
import java.util.ResourceBundle;

public class GoalSettingController implements Serializable {

    @FXML
    private JFXButton confirm;

    @FXML
    private JFXTextField CurrentWeight;

    @FXML
    private JFXTextField TargetWeight;

    @FXML
    private JFXTextField DaysLeft;

    @FXML
    private ComboBox<Goals.goalType> CB;

    @FXML
    private DatePicker datePicker;


    public void initialize() {

        CB.getItems().addAll(Goals.goalType.values());
        CB.setValue(Goals.goalType.DEFAULT);

    }


    public void continueBut(ActionEvent aE) throws IOException {
        Goals goal;
        if (CurrentWeight.getText().equals("") || TargetWeight.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Empty fields, please try again");
            alert.showAndWait();
        }

        if (CB.getSelectionModel().getSelectedItem() == Goals.goalType.DEFAULT) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a Goal Type!");
            alert.showAndWait();
        }

        if (datePicker == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a Target date!");
            alert.showAndWait();
        }

    }
}
