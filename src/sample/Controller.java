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

public class Controller {
    @FXML private JFXTextField loguser;
    @FXML private JFXPasswordField logpass;
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
