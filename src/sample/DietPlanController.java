package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Date;
import java.util.TextField;

public class DietPlanController {

    //all fields on page

    @FXML
    private JFXTextField DietName;
    @FXML
    private ChoiceBox DietType;
    @FXML
    private DatePicker StartDate;
    @FXML
    private DatePicker FinishDate;
    @FXML
    private JFXTextField CaloriesLimit;
    @FXML
    private JFXButton SaveDiet;


    //save to CSV


    //WRITE TO CSV

    public void pickDiet(ActionEvent ae) throws Exception {

        choiceBox.getItems().add("Paleo");
        choiceBox.getItems().add("Vegan");
        choiceBox.getItems().add("Low-Carb");
        choiceBox.getItems().add("Dukan");
        choiceBox.getItems().add("Ultra Low Fat");
        choiceBox.getItems().add("Atkins");
        choiceBox.getItems().add("HCG");
        choiceBox.getItems().add("Zone");
        choiceBox.getItems().add("Intermittent Fasting");

        HBox hbox = new HBox(choiceBox);

        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static boolean pickDate(Date t) {
        if (t == null || t.trim().isEmpty()) {
            System.out.println("Please fill in date");
            return false;
        }

        Date StartDate = s
        if (t < s || s.trim().isEarlier) {
            System.out.println("Please pick later date")
            retrun false;
        } else
            return true;
    }











