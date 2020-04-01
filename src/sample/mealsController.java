package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.*;





public class mealsController implements Initializable {

        FoodType aFood = new FoodType();
        @FXML
        private ChoiceBox<Meal.mealType> mealtype;
        ObservableList<Meal.mealType> mealTypeChoice = FXCollections.observableArrayList(Meal.mealType.values());
    @FXML private ComboBox<String> foods;
   // private ObservableList<FoodType> listFoods = FXCollections.observableArrayList(aFood.getFoods());

        @FXML
        private ComboBox<DrinkType> drink;
//        ObservableList<DrinkType> drinkChoice = FXCollections.observableList(drink.getItems());



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            //  String[] array = aFood.getFoods().toArray(new String[aFood.getFoods().size()]);
            // for(int i = 0; i < aFood.getFoods().size(); i++){
            //    array[i] = aFood.getFoods().get(i);
            //     foods.getItems().add(array[i]);
            //}
            //foods.getItems().addAll(aFood.getFoods())
            //  listFoods.
            // drink.setItems(drinkChoice);
            mealtype.setItems(mealTypeChoice);
            //foodChoice.addAll(aFood.getFoods());
            foods.getItems().addAll(aFood.getFoods());

        }




    }













