package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public boolean specialKCheck(String s){
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
        }
        else
            return true;
    }

    public static boolean emailCheck(String t){
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
        }
        else
            return true;
    }
}
public static void main(String[] args){

        }
