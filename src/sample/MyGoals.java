package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MyGoals {
    @FXML
    private ListView<String> listView;
    @FXML
    private JFXButton goBack;

    MyGoals() {

    }

    public void initialize() {
        listView.getItems().addAll(Account.getInstance().getGoals().toString());
    }

    public void goBackbut(ActionEvent aE) throws IOException {
        Parent myGoalsParent = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        Scene signUpViewScene = new Scene(myGoalsParent);
        Stage window = (Stage) ((Node) aE.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }
}
