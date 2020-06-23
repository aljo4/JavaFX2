package sample.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class MealsController implements Initializable {

    @FXML private TextField foodCalories;
    @FXML private TextField drinkCalories;

    FoodType aFood = new FoodType();
        DrinkType aDrink = new DrinkType();
        @FXML
        private ChoiceBox<Meal.mealType> mealtype; //for breakfast, lunch, dinner, etc
        ObservableList<Meal.mealType> mealTypeChoice = FXCollections.observableArrayList(Meal.mealType.values());
    @FXML private ComboBox<String> foods;
   // private ObservableList<FoodType> listFoods = FXCollections.observableArrayList(aFood.getFoods());

        @FXML
        private ComboBox<String> drink;
//        ObservableList<DrinkType> drinkChoice = FXCollections.observableList(drink.getItems());

        @FXML
        private JFXButton HomePage;


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
            drink.getItems().addAll(aDrink.getDrinks());

        }



    public void saveDiet(javafx.event.ActionEvent actionEvent) {
        Edible eat = new Edible();
        eat.setDrink(drink.getSelectionModel().getSelectedItem());
        eat.setDrinkCalCount(Integer.parseInt(drinkCalories.getText()));
        eat.setFood(foods.getSelectionModel().getSelectedItem());
        eat.setFoodCalCount(Integer.parseInt(foodCalories.getText()));


        Meal aMeal = new Meal(mealtype.getSelectionModel().getSelectedItem(),eat);

        Account.getInstance().setMeal(aMeal);
        Account.getInstance().getMeal().setCaloricIntake(Integer.parseInt(drinkCalories.getText())+ Integer.parseInt(foodCalories.getText()));
        System.out.println(aMeal.toStringForMeals());
        Account.getInstance().getMeal().addToMeals(aMeal);

        Account.getInstance().getAccountLists().saveMeal(aMeal);
        System.out.println(Account.getInstance().getMeal().getListOfFoods().size());


    }

    public void homeButton(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }
}













