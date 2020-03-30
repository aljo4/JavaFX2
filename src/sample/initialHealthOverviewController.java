package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class initialHealthOverviewController implements Initializable, Serializable {



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

    public void proceedButton(ActionEvent actionEvent) {
        Account anAccount = null;
        anAccount = Account.getInstance();
        System.out.println(anAccount.getEmail());
        anAccount.setIdealWeight(Double.parseDouble(height.getText()));
        Account.getInstance().setHeight(Double.parseDouble(weight.getText()));
        Account.getInstance().setWeight(Double.parseDouble(idealWeight.getText()));
        if (male.isSelected()) {
            Account.getInstance().setGender(Account.Gender.MALE);
            Account.getInstance().getAccountLists().addtolist(Account.getInstance());
            Account.getInstance().getAccountLists().saveToFile();
            //TODO: saving to file goes here
        } else if (female.isSelected()){
            Account.getInstance().setGender(Account.Gender.FEMALE);
            Account.getInstance().getAccountLists().addtolist(Account.getInstance());
            Account.getInstance().getAccountLists().saveToFile();
        }

    }
}




