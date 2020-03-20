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

public class DietPlanController {

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


    //save to CSV


    //WRITE TO CSV

    public class DietName {

            TextArea textArea = new TextArea();

            VBox vbox = new VBox(textArea);

            Scene scene = new Scene(vbox, 200, 100);
            primaryStage.setScene(scene);
            primaryStage.show();

        }

        public static void main(String[] args) {
            DietPlanController.launch(args);
        }
    }

    public class DietType {

            ChoiceBox choiceBox = new ChoiceBox();

            choiceBox.getItems().add("Paleo");
            choiceBox.getItems().add("Vegan");
            choiceBox.getItems().add("Low-Carb");
            choiceBox.getItems().add("Dukan");
            choiceBox.getItems().add("Ultra Low Fat");
            choiceBox.getItems().add("Atkins");
            choiceBox.getItems().add("HCG");
            choiceBox.getItems().add("Zone");
            choiceBox.getItems().add("Intermittent Fasting");

            HBox hbox = new HBox(choiceBox);

            Scene scene = new Scene(hbox, 200, 100);
            primaryStage.setScene(scene);
            primaryStage.show();

        }

        public static void main(String[] args) {
            DietPlanController.launch(args);
        }
    }


    public class FinishDate {

            DatePicker datePicker = new DatePicker();

            Button button = new Button("Read Date");

            button.setOnAction(action -> {
            LocalDate value = datePicker.getValue();
             });

            HBox hbox = new HBox(datePicker);

            Scene scene = new Scene(hbox, 300, 240);
            primaryStage.setScene(scene);
            primaryStage.show();

            }

            public void pickDate(){
                if ((date FinishDate) < (date StartDate)) {
                    System.out.println("Please Try again");
                }

    public static void main(String[] args) {
        DietPlanController.launch(args);
            }
        }


    public class CaloriesLimit {

        TextArea textArea = new TextArea();

        VBox vbox = new VBox(textArea);

        Scene scene = new Scene(vbox, 200, 100);
            primaryStage.setScene(scene);
            primaryStage.show();

}

    public static void main(String[] args) {
        DietPlanController.launch(args);
    }
}







