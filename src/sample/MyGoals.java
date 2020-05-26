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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyGoals {
    @FXML
    private ListView<String> listView;
    @FXML
    private JFXButton goBackbut;

    public MyGoals() {

    }


    public void initialize() throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < Account.getInstance().getGoals().size(); i++) {
            list.add(Account.getInstance().getGoals().get(i).toString());
        }
        listView.getItems().addAll(list);
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
