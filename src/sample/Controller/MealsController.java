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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class MealsController {

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private TextField foodCalories;
    @FXML
    private TextField drinkCalories;
    @FXML
    private DatePicker mealDate;
    FoodType aFood = new FoodType();
    DrinkType aDrink = new DrinkType();
    @FXML
    private ChoiceBox<Meal.mealType> mealtype; //for breakfast, lunch, dinner, etc
    ObservableList<Meal.mealType> mealTypeChoice = FXCollections.observableArrayList(Meal.mealType.values());
    @FXML
    private ComboBox<String> foods;
    @FXML
    private ComboBox<String> drink;
    @FXML
    private JFXButton HomePage;

    @FXML
    public void initialize() throws Exception {
        Account a = Account.getInstance();
        ArrayList<Meal> foodData = a.getAccountLists().readMeals();
        System.out.println(foodData.size());
        XYChart.Series series = new XYChart.Series();
        series.setName("Meal Graph");
        for (int i = 0; i < foodData.size(); i++) {
            series.getData().add(new XYChart.Data(foodData.get(i).getMealDate().toString(), foodData.get(i).getCaloricIntake()));
            //lineChart.getData().add(series);
        }

        lineChart.getData().add(series);


        mealtype.setItems(mealTypeChoice);
        foods.getItems().addAll(aFood.getFoods());
        drink.getItems().addAll(aDrink.getDrinks());


    }


    public void saveDiet(javafx.event.ActionEvent actionEvent) {
        Edible eat = new Edible();
        eat.setDrink(drink.getSelectionModel().getSelectedItem());
        eat.setDrinkCalCount(Integer.parseInt(drinkCalories.getText()));
        eat.setFood(foods.getSelectionModel().getSelectedItem());
        eat.setFoodCalCount(Integer.parseInt(foodCalories.getText()));


        Meal aMeal = new Meal(mealtype.getSelectionModel().getSelectedItem(),eat,mealDate.getValue());
        Account.getInstance().setMeal(aMeal);
        Account.getInstance().getMeal().setCaloricIntake(Integer.parseInt(drinkCalories.getText())+ Integer.parseInt(foodCalories.getText()));

        System.out.println(aMeal.toStringForMeals());
        Account.getInstance().getAllMyMeals().add(aMeal);

        Account.getInstance().getAccountLists().saveMeal(aMeal);
        System.out.println(Account.getInstance().getAllMyMeals().size());


    }

    public void homeButton(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }
}













