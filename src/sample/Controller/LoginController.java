package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import sample.Model.*;
import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private JFXButton forgotpwdButton;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;

    public void initialize() throws IOException {
        Account.getInstance().getAccountLists().readMeals();
        email.setStyle("-fx-text-inner-color: White;");
        password.setStyle("-fx-text-inner-color: White;");

    }

    public void validateLogin(ActionEvent ae) throws IOException {
        if (Account.AccountLists.checkUserExists(email.getText(), password.getText())) {
            Account account = Account.getInstance();
            account.setEmail(email.getText());
            account.setPassword(password.getText());
            System.out.println(account.getEmail());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Welcome");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Parent signUpParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene signUpViewScene = new Scene(signUpParent);

                Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                window.setScene(signUpViewScene);
                window.setResizable(true);
                window.setMaximized(true);
                window.show();
            }else{
                alert.close();
            }


        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "User does not exist. Please sign up");
            alert.showAndWait();
        }
    }

    public void toSignUp(ActionEvent ae) throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("View/signup.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);

        Stage window = (Stage)((Node)ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.show();
    }

    public void showPassword(ActionEvent actionEvent) throws IOException {
       String password = Account.getInstance().getAccountLists().forgottenPassword(email.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "PASSWORD: " + password);
        alert.showAndWait();
    }
}
