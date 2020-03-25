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

public class DietPlanController<JFXTextField> {

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
    }


    //save to CSV


    //WRITE TO CSV


//    public void pickDiet(ActionEvent ae) throws Exception {
//
//    }
//
//    public static boolean pickDate(Date t) {
//        if (t == null || t.trim().isEmpty()) {
//            System.out.println("Please fill in date");
//            return false;
//        }
//
//        Date StartDate = s
//        if (t < s || s.trim().isEarlier) {
//            System.out.println("Please pick later date")
//            retrun false;
//        } else
//            return true;
//    }
}











