package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class mealTracker implements Initializable {
    @FXML private ChoiceBox<Diet.mealType> mealtype;
    ObservableList<Diet.mealType> mealTypeChoice = FXCollections.observableArrayList(Diet.mealType.values());
    @FXML private ComboBox<FoodType.Foods> food;
    ObservableList<FoodType.Foods> foodChoice = FXCollections.observableArrayList(FoodType.Foods.values());
    @FXML
    private ComboBox<DrinkType.Drinks> drink;
    ObservableList<DrinkType.Drinks> drinkChoice = FXCollections.observableArrayList(DrinkType.Drinks.values());



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FoodType.Foods aFood;
        food.setItems(foodChoice);
        food.setPromptText("Other");
        food.setEditable(true);
        food.valueProperty().addListener(new ChangeListener<FoodType.Foods>() {
            @Override
            public void changed(ObservableValue<? extends FoodType.Foods> observableValue, FoodType.Foods foods, FoodType.Foods t1) {

            }
        });
        drink.setItems(drinkChoice);
        mealtype.setItems(mealTypeChoice);
    }

    
}











