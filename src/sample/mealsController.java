package sample;

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

import java.io.IOException;
import java.net.URL;
import java.util.*;





public class mealsController implements Initializable {

        FoodType aFood = new FoodType();
        DrinkType aDrink = new DrinkType();
        @FXML
        private ChoiceBox<Meal.mealType> mealtype;
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
            eat.setfName(foods.getSelectionModel().getSelectedItem());
    }

    public void homeButton(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }
}













