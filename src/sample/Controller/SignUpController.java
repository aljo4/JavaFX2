package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Model.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUpController implements Serializable {

    private Account account;

    @FXML
    private JFXButton toLogIn;

    @FXML
    private JFXTextField fullname;

    @FXML
    private JFXTextField email;


    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField confirmPass;


    public SignUpController() {

    }

    @FXML
    private void initialize() {
        fullname.setStyle("-fx-text-inner-color: White;");
        email.setStyle("-fx-text-inner-color: White;");
        username.setStyle("-fx-text-inner-color: White;");
        password.setStyle("-fx-text-inner-color: White;");
        confirmPass.setStyle("-fx-text-inner-color: White;");
    }

    public void toLogIn(ActionEvent ae) throws Exception {
        Parent logInParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene logInViewScene = new Scene(logInParent);

        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(logInViewScene);
        window.show();
    }


    public boolean specialKCheck(String s) { //this needs to allow spaces
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Wrong form of string");
            return false;
        }
        Pattern pat = Pattern.compile("[^ A-Za-z]");
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


    public void signupButton(ActionEvent actionEvent) throws IOException {
        Account account = Account.getInstance();
        if (!password.getText().equals(confirmPass.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Passwords are not the same! Try again");
            alert.close();
        }
        if (fullname.getText().trim().isEmpty() || email.getText().trim().isEmpty() || username.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Empty fields, please try again");
            alert.showAndWait();
        }
//        }else if (emailCheck(email.getText()) == false){
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Dialog");
//            alert.setContentText("Email format wrong. Make sure you put in the '@' sign!");
//            alert.showAndWait();
//        }
        else {
            account.setFullname(fullname.getText());
            account.setEmail(email.getText());
            account.setUsername(username.getText());
            account.setPassword(password.getText());
            boolean addUser = true;

            for (int i = 0; i < Account.getInstance().getAccountLists().getAccounts().size(); i++) {
                if (Account.getInstance().getAccountLists().getAccounts().get(i).getUsername().equals(username.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setContentText("User exists in file");
                    alert.showAndWait();
                }
            }

            if (addUser) {
                account.setFullname(fullname.getText());
                account.setEmail(email.getText());
                account.setUsername(username.getText());
                account.setPassword(password.getText());
//                        account.getAccountLists().addtolist(account);
//                        account.getAccountLists().saveToFile();


                Parent signUpParent = FXMLLoader.load(getClass().getResource("initialHealthOverview.fxml"));
                Scene signUpViewScene = new Scene(signUpParent);

                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(signUpViewScene);
                window.show();
            }

        }
    }
}



