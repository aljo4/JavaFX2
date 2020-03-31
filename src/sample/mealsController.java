package sample;

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




public class mealsController implements Initializable {
         FoodType aFood = new FoodType();

        @FXML
        private ChoiceBox<Diet.mealType> mealtype;
        ObservableList<Diet.mealType> mealTypeChoice = FXCollections.observableArrayList(Diet.mealType.values());

        @FXML private ComboBox<String> foods = new ComboBox<String>(FXCollections.observableArrayList(aFood.getFoods()));

        @FXML
        private ComboBox<DrinkType> drink;
//        ObservableList<DrinkType> drinkChoice = FXCollections.observableList(drink.getItems());



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            //foods.getItems().addAll(aFood.getFoods())

           // drink.setItems(drinkChoice);
            mealtype.setItems(mealTypeChoice);
            //foodChoice.addAll(aFood.getFoods());
            foods.getItems().addAll(aFood.getFoods());

        }


    }













