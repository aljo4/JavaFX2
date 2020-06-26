package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyGoalsController {
    @FXML
    private ListView<String> listView;
    @FXML
    private JFXButton goBackbut;

    public MyGoalsController() {

    }


    public void initialize() throws IOException {
        Account.getInstance().getAccountLists().readGoals();
        System.out.println(Account.getInstance().getGoals().size());
        ArrayList<Goals> list = new ArrayList<>();
        for (int i = 0; i < Account.getInstance().getGoals().size(); i++) {
            listView.getItems().add(Account.getInstance().getGoals().get(i).toString());
        }
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
