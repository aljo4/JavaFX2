package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import org.w3c.dom.Text;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class activitiesController implements Initializable {
    public Button activityButton;

    public activitiesController() {

    }
    @FXML
    private JFXButton HomePage;
    @FXML
    private DatePicker activityDate;
    @FXML
    private ComboBox<Activity.Activities> activity;
    ObservableList<Activity.Activities> exerciseChoice = FXCollections.observableArrayList(Activity.Activities.values());
    @FXML
    private TextField duration;

    @FXML
    private TextField reps;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        activityDate.setValue(LocalDate.now());
        activityDate.setDayCellFactory(datePicker1 -> new DateCell() {
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        LocalDate today = LocalDate.now();

                        setDisable(empty || date.compareTo(today) < 0);
                    }
                }

        );
        activity.setItems(exerciseChoice); //the Observable list like array is used to add to the comboBox activity
    }


    public void saveActivity(ActionEvent actionEvent) {
        if (duration.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Empty fields, please try again");
            alert.showAndWait();
        }
        Activity activity1 = new Activity(activity.getSelectionModel().getSelectedItem(),activityDate.getValue());
        Account.getInstance().setActivities(activity.getSelectionModel().getSelectedItem());
        Account.getInstance().getActivities().setDuration(Integer.parseInt(duration.getText()));
        Account.getInstance().getActivities().setRepetitions(Integer.parseInt(reps.getText()));
        Account.getInstance().getExercises().add(Account.getInstance().getActivities());
        System.out.println(activity1.getActivitiesEnum());
        activity1.getActivitiesEnum().setDuration(Integer.parseInt(duration.getText()));
        activity1.getActivitiesEnum().setRepetitions(Integer.parseInt(reps.getText()));
        Account.getInstance().getAccountLists().saveActivityToFile(activity1);



//        activity.getSelectionModel().getSelectedItem();
//        System.out.println(activity.getSelectionModel().getSelectedItem());
////        Account.getInstance().getActivities().getActivitiesEnum().setDuration(Integer.parseInt(duration.getText()));
////        Account.getInstance().getActivities().getActivitiesEnum().setRepetitions(Integer.parseInt(reps.getText()));
////        Account.getInstance().getExercises().add(Account.getInstance().getActivities().getActivitiesEnum());
////        Account.getInstance().getAccountLists().saveActivityToFile(Account.getInstance().getActivities());

    }

    public void homeButton(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }
}
