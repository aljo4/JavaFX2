package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Controller {
    public void toSignUp(ActionEvent ae) throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage)((Node)ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }
}
