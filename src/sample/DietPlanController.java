package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
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

public class DietPlanController {

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


    @FXML
    public void initialize(){
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Paleo", "Vegan", "Low-carb", "Dukan", "Ultra Low Fat", "Atkins", "HCG", "Zone", "Intermittent Fasting");
        DietType.setItems(list);
    }
//            ChoiceBox choiceBox = new ChoiceBox();
//
//            choiceBox.getItems().add("Paleo");
//            choiceBox.getItems().add("Vegan");
//            choiceBox.getItems().add("Low-Carb");
//            choiceBox.getItems().add("Dukan");
//            choiceBox.getItems().add("Ultra Low Fat");
//            choiceBox.getItems().add("Atkins");
//            choiceBox.getItems().add("HCG");
//            choiceBox.getItems().add("Zone");
//            choiceBox.getItems().add("Intermittent Fasting");


}







