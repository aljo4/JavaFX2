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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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






public void initialize(){

    CB.getItems().addAll(Goals.goalType.values());

}



public void confirm(ActionEvent actionEvent){}

}
