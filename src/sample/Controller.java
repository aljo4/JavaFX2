package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Controller {
    @FXML private JFXTextField loguser;
    @FXML private JFXPasswordField logpass;

    public Controller() { //constructor

    }
    public void saveToFile(Account p)throws IOException{

        File file = new File("//PATHNAME GOES HERE");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fileWriter);


        out.write();//write to file here
        out.flush();   // Flush the buffer and write all changes to the disk

        out.close();
    }

    @FXML
    public void initialize() {
        // Load model from file (or database if you are using a database)
        try {
            motorcycles = Motorcycle.loadMotorcyclesFromString(readFile("Motorcycles_2018.txt"));
        } catch (IOException e) {
            System.out.println("Could not load motorcycles from file.");
        }
        try {
            bikeFilters = BikeType.loadBikeFiltersFromString(readFile("BikeType.txt"));
        } catch (IOException e) {
            System.out.println("Could not load bike types.");
        }



    public void toSignUp(ActionEvent ae) throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage)((Node)ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }

    //public Account logIn(ActionEvent ae) {}



    public boolean validateLogin(){
        String theuser = loguser.getText();
        //is it in the csv file if yes check password, if correct return true
        return true;
    }
}
