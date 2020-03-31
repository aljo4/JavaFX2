package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    //all fields on page

    @FXML
    private TextField DietName;
    @FXML
    private ChoiceBox DietType;
    @FXML
    private DatePicker FinishDate;
    @FXML
    private TextField CaloriesLimit;
    @FXML
    private Button SaveDiet;

    @FXML
    public void initialize() {

        DietType.getItems().add("Paleo");
        DietType.getItems().add("Vegan");
        DietType.getItems().add("Low-Carb");
        DietType.getItems().add("Dukan");
        DietType.getItems().add("Ultra Low Fat");
        DietType.getItems().add("Atkins");
        DietType.getItems().add("HCG");
        DietType.getItems().add("Zone");
        DietType.getItems().add("Intermittent Fasting");

        FinishDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0);
            }
        });

    }

    public void toDietPage(ActionEvent ae) throws Exception {
        if (DietName.getText().trim().isEmpty() || DietType.getSelectionModel().isEmpty()
                || FinishDate.getChronology().equals(null) || CaloriesLimit.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Empty fields, please try again");
            alert.showAndWait();
        }
            else {
               TypeOfDiet SelectedDiet= (TypeOfDiet) DietType.getSelectionModel().getSelectedItem();
               Account.getInstance().setTypeOfDiet(SelectedDiet);
                System.out.println(Account.getInstance());
            Parent DietParent = FXMLLoader.load(getClass().getResource("DietPage.fxml"));
            Scene signUpViewScene = new Scene(DietParent);
            Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.setResizable(true);
            window.setMaximized(true);
            window.show();}

        }
    }
















