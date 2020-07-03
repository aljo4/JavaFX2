package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Date;

public class DietPlanController<JFXTextField> {
    @FXML private Button homeButton;
    @FXML private ChoiceBox DietType;
    ObservableList<TypeOfDiet.Diets>ChoiceOfDiet = FXCollections.observableArrayList(TypeOfDiet.Diets.values());
    @FXML private Button SaveDiet;

    @FXML
    public void initialize() {
        DietType.setItems(ChoiceOfDiet);
    }

    public void toDietPage(ActionEvent ae) throws Exception {
        if (DietType.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Empty fields, please try again");
            alert.showAndWait();
        }
            else {
               TypeOfDiet diet = new TypeOfDiet((TypeOfDiet.Diets) DietType.getValue());
                Account.getInstance().setTypeOfDiet(diet);
               Account.getInstance().getAccountLists().saveDietToFile(diet);
                System.out.println(Account.getInstance().getTypeOfDiet());
                Parent DietParent = FXMLLoader.load(getClass().getResource("../View/DietPage.fxml"));
                Scene signUpViewScene = new Scene(DietParent);
                Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                window.setScene(signUpViewScene);
                window.setResizable(true);
                window.setMaximized(true);
                window.show();
            }

        }

    public void goHome(ActionEvent actionEvent) throws IOException {
        Parent DietParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
        Scene signUpViewScene = new Scene(DietParent);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();}

    }

















