package sample.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.scene.control.*;
import sample.Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;

import javax.swing.*;

public class SocialPageController {

    @FXML JFXListView groupsList;
    @FXML JFXButton groupSelect;
    @FXML JFXButton viewFriend;
    @FXML JFXButton delFriend;
    @FXML JFXButton addFriend;
    @FXML JFXButton toHomePage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toDietPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toYouPage;


    //groupsList.getItems().addAll(LoginController.currentAccount.groupList); //when login is working tis will use the



    @FXML
    public void initialize()throws Exception {
        Account a = Account.getInstance();
        ArrayList<String> fr = a.getAccountLists().readFriends();
        System.out.println(fr);
        ObservableList<String> olf = FXCollections.observableArrayList(fr);
        groupsList.setItems(olf);
    }

    public void delFriend(ActionEvent ae) throws Exception {
        Account a = Account.getInstance();

        if (groupsList.getSelectionModel().getSelectedItems().size()>0){
            String selecteduser = (String) groupsList.getSelectionModel().getSelectedItem();
            groupsList.getItems().remove(selecteduser);
            ArrayList<String> b = a.getFriends();
            b.remove(selecteduser);
            a.setFriends(b);
        }
    }

    public void addFriend(ActionEvent ae) throws Exception{
        Account a = Account.getInstance();
        TextInputDialog td = new TextInputDialog("Username?");
        td.setHeaderText("enter a username");
        td.showAndWait();
        String name = td.getEditor().getText();
        System.out.println(name);
        if (Account.AccountLists.checkUsernameExists(name)){
            a.getAccountLists().saveFriendToFile(name);
            ArrayList<String> b =  a.getFriends();
            b.add(name);
            a.setFriends(b);
            groupsList.getItems().add(name);
        }

    }

    public void viewFriend(ActionEvent ae)throws Exception{

    }

    public void toHomePage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }



    public void toGoalsPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/GoalsPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toYouPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/YouPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toDietPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/DietPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toActivityPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/Activity.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void logOutButton (ActionEvent ae)throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            Scene signUpViewScene = new Scene(signUpParent, 600, 400);
            Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.setResizable(false);
            window.show();
        }
    }

}
