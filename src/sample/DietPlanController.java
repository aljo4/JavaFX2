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
    private DatePicker StartDate;
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

        if (FinishDate.getValue() != null) {
            StartDate.setDayCellFactory(picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(StartDate.getValue()) > 0);
                }
            });
        } else {
            StartDate.setDayCellFactory(picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0);
                }
            });
        }
        if (FinishDate.getValue() == null) {
            FinishDate.setDayCellFactory(picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) < 0);
                }

            });
        } else {
            FinishDate.setDayCellFactory(picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(StartDate.getValue()) < 0);
                }
            });
        }
    }
}














