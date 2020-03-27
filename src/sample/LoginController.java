package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML private JFXTextField email;
    @FXML private JFXPasswordField password;




    public void validateLogin(ActionEvent ae) throws IOException {
        if (Account.AccountLists.checkUserExists(email.getText(), password.getText())) {
            Account account = Account.getInstance();
            account.setEmail(email.getText()); account.setPassword(password.getText());
            System.out.println(account.getEmail());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Welcome");
            alert.showAndWait();
            Parent signUpParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene signUpViewScene = new Scene(signUpParent);

            Stage window = (Stage)((Node)ae.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.show();

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "User does not exist. Please sign up");
            alert.showAndWait();
        }
    }



    public void toSignUp(ActionEvent ae) throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage)((Node)ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }

}
