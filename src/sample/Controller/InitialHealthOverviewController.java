package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InitialHealthOverviewController implements Initializable, Serializable {



    @FXML
    private JFXTextField idealWeight;
    @FXML
    private JFXTextField height;
    @FXML
    private JFXTextField weight;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private Button cancelButton;
    @FXML
    private JFXButton ectmorph;
    @FXML
    private JFXButton endomorph;
    @FXML
    private JFXButton mesomorph;
    @FXML
    private Slider activitylevels;
    @FXML
    private JFXButton proceedbutton;

    public Slider getActivitylevels() {
        activitylevels.setMin(0);
        activitylevels.setMax(10);
        activitylevels.setValue(5);
        activitylevels.setShowTickLabels(true);
        activitylevels.setShowTickMarks(true);
        activitylevels.setMajorTickUnit(10);
        activitylevels.setMinorTickCount(0);
        activitylevels.setBlockIncrement(1);
        return activitylevels;
    }


    public double calcBMI() {
        int h = Integer.parseInt(height.getText()); //in cm
        int w = Integer.parseInt(weight.getText()); //kilos
        //bmi = Kg/m^2
        h = h / 100; //for metres
        h = h ^ 2; //find square of height
        double bmi = w / h;
        return bmi;

    }
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fill the combobox
    }

    public void proceedButton(ActionEvent actionEvent) throws IOException {
        Account anAccount = null;
        anAccount = Account.getInstance();
        System.out.println(anAccount.getEmail());
        anAccount.setIdealWeight(Double.parseDouble(idealWeight.getText()));
        Account.getInstance().setHeight(Double.parseDouble(height.getText()));
        Account.getInstance().setWeight(Double.parseDouble(weight.getText()));
        if (male.isSelected()) {
            Account.getInstance().setGender(Account.Gender.MALE);
            Account.getInstance().getAccountLists().addtolist(Account.getInstance());
            Account.getInstance().getAccountLists().saveToFile();
            Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
            Scene signUpViewScene = new Scene(signUpParent);

            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.show();
        } else if (female.isSelected()){
            Account.getInstance().setGender(Account.Gender.FEMALE);
            Account.getInstance().getAccountLists().addtolist(Account.getInstance());
            Account.getInstance().getAccountLists().saveToFile();
            Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
            Scene signUpViewScene = new Scene(signUpParent);

            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.show();
        }


    }

    public void calculateBMI(ActionEvent actionEvent) {
        int h = Integer.parseInt(height.getText()); //in cm
        int w = Integer.parseInt(weight.getText()); //kilos
        //bmi = Kg/m^2
        h = h / 100; //for metres
        h = h ^ 2; //find square of height
        double bmi = w / h;
        Account.getInstance().setBmi(bmi);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"This is your BMI: " + bmi);
        alert.showAndWait();
    }

    public void returnHome(ActionEvent actionEvent) throws IOException {
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }
}




