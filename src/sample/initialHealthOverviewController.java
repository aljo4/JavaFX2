package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;

public class initialHealthOverviewController {

    //all fields on page

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
    private ChoiceBox currentdiet;
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


    public double calcBMI(){
        int h = Integer.parseInt(height.getText()); //in cm
        int w = Integer.parseInt(weight.getText()); //kilos
        //bmi = Kg/m^2
        h= h / 100; //for metres
        h=h^2; //find square of height
        double bmi = w/h;
        return  bmi;



    }

    public void proceedButton(ActionEvent actionEvent){
        String idealwei =  idealWeight.getText();
        String hei = height.getText();
        String wei = weight.getText();
        if(male.isSelected())
        {
            //Account.Gender.isMale();
        }
        else{
            //gender.isFemale();
        }
        boolean m  = male.isSelected();
        //female = female.isSelected();
        activitylevels = activitylevels;



    }}





