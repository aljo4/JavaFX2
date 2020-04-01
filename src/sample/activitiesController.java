package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class activitiesController implements Initializable {
    @FXML
    private ComboBox<Activities> activity;
    ObservableList<Activities> exerciseChoice = FXCollections.observableArrayList(Activities.values());
    @FXML
    private TextField duration;

    @FXML
    private TextField reps;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        activity.setItems(exerciseChoice);
    }


    public void saveActivity(ActionEvent actionEvent) {
        if (duration.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Empty fields, please try again");
            alert.showAndWait();
        }
        Account.getInstance().setActivities(activity.getSelectionModel().getSelectedItem());
        Account.getInstance().getActivities().setDuration(Integer.parseInt(duration.getText()));
        Account.getInstance().getActivities().setRepetitions(Integer.parseInt(reps.getText()));
        Account.getInstance().getExercises().add(Account.getInstance().getActivities());
        Account.getInstance().getAccountLists().saveActivityToFile(Account.getInstance().getActivities());

    }
}
