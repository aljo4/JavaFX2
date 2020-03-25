package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;
import java.util.*;

public class DietPlanController implements Initializable {
    @FXML private ChoiceBox<FoodType.Foods> food;
    ObservableList<FoodType.Foods> foodChoice = FXCollections.observableArrayList(FoodType.Foods.values());
    @FXML
    private ChoiceBox<DrinkType.Drinks> drink;
    ObservableList<DrinkType.Drinks> drinkChoice = FXCollections.observableArrayList(DrinkType.Drinks.values());



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        food.setItems(foodChoice);
        drink.setItems(drinkChoice);
    }

    
}











