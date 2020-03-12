package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;


public class SignUpController {
    @FXML
    private JFXButton toLogIn;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField confirmPass;

    @FXML
    private JFXTextField fullname;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField username;

    public SignUpController() {

    }

    @FXML
    private void initialize() {

    }

    public void toLogIn(ActionEvent ae) throws Exception {
        Parent logInParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene logInViewScene = new Scene(logInParent);

        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(logInViewScene);
        window.show();
    }




    public boolean specialKCheck(String s) {
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Wrong form of string");
            return false;
        }
        Pattern pat = Pattern.compile("[^A-Za-z]");
        Matcher mat = pat.matcher(s);
        boolean boo = mat.find();
        if (boo) {
            System.out.println("no special characters please or numbers");
            return false;
        } else
            return true;
    }

    public static boolean emailCheck(String t) {
        if (t == null || t.trim().isEmpty()) {
            System.out.println("Wrong form of string");
            return false;
        }
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\\\.\"+ \n" +
                "\"[a-zA-Z0-9_+&*-]+)*@\" + \n" +
                "\"(?:[a-zA-Z0-9-]+\\\\.)+[a-z\" + \n" +
                "\"A-Z]{2,7}$\"; ");
        Matcher mat = pat.matcher(t);
        boolean boo = mat.matches();
        if (boo) {
            System.out.println("not valid email format");
            return false;
        } else
            return true;
    }

    public static void main(String[] args) {

    }

    public void signupButton(ActionEvent actionEvent) {
       Account account;
        email.getText();
        username.getText();
        password.getText();
        fullname.getText();
        confirmPass.getText();
        account = new Account(email,username,password, fullname,confirmPass);
        System.out.println(confirmPass.getText());
        System.out.println(account.toString());



            }
}