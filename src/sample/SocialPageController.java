package sample;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

public class SocialPageController{

    @FXML JFXListView groupsList;

    @FXML
    public void initialize(){
        //groupsList.getItems().addAll(LoginController.currentAccount.groupList); //when login is working tis will use the
        //global variable currentUser
        //for now just fill with test data
        Account a = new Account("FullName", "Email.com","userN","pass1");
        Account b = new Account("FullName2", "Email.com2","userN2","pass2");
        Account c = new Account("FullName3", "Email.com3","userN3","pass3");

        Group gA = new Group(a,"group1");
        Group gB = new Group(b,"group2");
        Group gC = new Group(c,"group3");

        groupsList.getItems().addAll(gA.toString(),gB.toString(),gC.toString());
        groupsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
