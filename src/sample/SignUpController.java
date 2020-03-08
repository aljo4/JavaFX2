package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    public void toLogIn(ActionEvent ae) throws Exception{
        Parent logInParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene logInViewScene = new Scene(logInParent);

        Stage window = (Stage)((Node)ae.getSource()).getScene().getWindow();
        window.setScene(logInViewScene);
        window.show();
    }

    public void signUpButtonClicked(){
        //need to validate inputs, check for duplicates and input data if correct to a file?
    }
}
