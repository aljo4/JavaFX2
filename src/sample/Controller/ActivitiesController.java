package sample.Controller;
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
import sample.Model.*;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class ActivitiesController implements Initializable {
    public Button activityButton;

    public ActivitiesController() {

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
        Account.getInstance().setActivity(activity1);
        Account.getInstance().getActivity().getActivitiesEnum().setDuration(Integer.parseInt(duration.getText()));
        Account.getInstance().getActivity().getActivitiesEnum().setRepetitions(Integer.parseInt(reps.getText()));
        Account.getInstance().getWorkouts().add(activity1);
        System.out.println(Account.getInstance().getActivity().getActivitiesEnum());
        Account.getInstance().getAccountLists().saveActivityToFile(activity1);


    }

    public void homeButton(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }
}
