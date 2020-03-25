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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GoalSettingController implements Serializable {

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

    }

        public boolean fieldCheck(String s){
            Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher mat = pat.matcher(s);
            boolean boo = mat.matches();
            if(boo){
                return false;
            }
            else
                return true;
        }

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
        } else if (datePicker.getChronology().equals(LocalDate.now())) {
            System.out.println(datePicker.getChronology());
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

        else{
                goal = new Goals(CB.getSelectionModel().getSelectedItem(), Double.parseDouble(CurrentWeight.getText()), Double.parseDouble(TargetWeight.getText()), LocalDate.now(), datePicker.getValue());
        }
    }
}
