package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

import java.io.Serializable;

public class GoalSettingController implements Serializable {

    @FXML
    private JFXButton confirm;

    @FXML
    private JFXTextField CurrentWeight;

    @FXML
    private JFXTextField TargetWeight;

    @FXML
    private JFXTextField DaysLeft;

    ComboBox<Goals.goalType> comboBox = new ComboBox<>();



public void confirm(ActionEvent actionEvent){}

}
