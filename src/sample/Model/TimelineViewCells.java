package sample.Model;

import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.util.Pair;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class TimelineViewCells extends JFXListCell<Pair<LocalDate, ArrayList<Meal>>> {


    @FXML VBox base;
    @FXML HBox tophb;
    @FXML Label dayLabel;
    @FXML Label dateLabel;
    @FXML Line crossLine;

    @FXML HBox bothb;
    @FXML Label bCalLabel;

    @FXML Label lCalLabel;

    @FXML Label dCalLabel;

    @FXML Label sCalLabel;

    @FXML Label tCalLabel;

    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Pair<LocalDate, ArrayList<Meal>> meal, boolean empty) {
        super.updateItem(meal, empty);

        if(empty || meal == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("MealListView.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            dayLabel.setText(String.valueOf(meal.getKey()));
            dateLabel.setText(meal.getKey().getDayOfWeek().toString());


            int b=0,l=0,d=0,s=0,t=0;
            for(Meal m: meal.getValue()) {
                if(m.getMealtype() == Meal.mealType.BREAKFAST) {
                    bCalLabel.setText(String.valueOf(m.getCaloricIntake()));
                    b += m.getCaloricIntake();
                }
                if(m.getMealtype() == Meal.mealType.LUNCH){
                    lCalLabel.setText((String.valueOf(m.getCaloricIntake())));
                    l += m.getCaloricIntake();
                }
                if(m.getMealtype() == Meal.mealType.DINNER){
                    dCalLabel.setText((String.valueOf(m.getCaloricIntake())));
                    d += m.getCaloricIntake();
                }
                if(m.getMealtype() == Meal.mealType.SNACK) {
                    s += m.getCaloricIntake();
                }

            }
            sCalLabel.setText(String.valueOf(s));
            tCalLabel.setText(String.valueOf(b+l+d+s));
            setText(null);
            setGraphic(gridPane);

        }

    }

//    @FXML VBox base;
//    @FXML HBox tophb;
//    @FXML Label dayLabel;
//    @FXML Label dateLabel;
//    @FXML Line crossLine;
//
//    @FXML HBox bothb;
//    @FXML Label bCalLabel;
//
//    @FXML Label lCalLabel;
//
//    @FXML Label dCalLabel;
//
//    @FXML Label sCalLabel;
//
//    @FXML Label tCalLabel;
//    private FXMLLoader loader;

/*
    @Override
    protected void updateItem(Pair<LocalDate, ArrayList<Meal>> viewMeals, boolean empty) {
        super.updateItem(viewMeals, empty);
        if(empty || viewMeals == null) {

            setText(null);
//            String today = viewMeals.getKey().getDayOfWeek().toString();
//            today = today.substring(0,1) + today.substring(1).toLowerCase();
//            dayLabel.setText(today);
//            dateLabel.setText(viewMeals.getKey().format(DateTimeFormatter.ofPattern("dd/MM")));
            setGraphic(base);
        }
        else{
            if (loader == null) {
                loader = new FXMLLoader(getClass().getResource("MealListView.fxml"));
                loader.setController(this);

                try {
                    loader.load();
                    System.out.println("ye");
                } catch (IOException e) {
                    System.out.println("ohno");
                }
            }
//            String today = viewMeals.getKey().getDayOfWeek().toString();
//            today = today.substring(0,1) + today.substring(1).toLowerCase();
//            dayLabel.setText(today);
//            dateLabel.setText(viewMeals.getKey().format(DateTimeFormatter.ofPattern("dd/MM")));

            int t = 1;
            int snackCal = 0;
            for (Meal m : viewMeals.getValue()) {
//                if (m.getMealtype() == Meal.mealType.BREAKFAST)
//                   bCalLabel.setText(String.valueOf(m.getCaloricIntake()));
//                else if (m.getMealtype() == Meal.mealType.LUNCH)
//                   lCalLabel.setText(String.valueOf(m.getCaloricIntake()));
//                else if (m.getMealtype() == Meal.mealType.DINNER)
//                   dCalLabel.setText(String.valueOf(m.getCaloricIntake()));
//                else
                   //snackCal += m.getCaloricIntake();
              //  t += m.getCaloricIntake();
           }
            tCalLabel.setText(String.valueOf(t));
            sCalLabel.setText(String.valueOf(snackCal));

            setText(null);
            setGraphic(base);
        }

        }
*/

}

