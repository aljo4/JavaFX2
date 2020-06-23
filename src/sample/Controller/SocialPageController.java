package sample.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

import javax.swing.*;

public class SocialPageController {

    @FXML JFXListView groupsList;
    @FXML JFXButton groupSelect;
    @FXML JFXButton leaveGroup1;
    @FXML JFXButton createGroup;
    @FXML JFXButton joinGroup;
    @FXML JFXButton toHomePage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toDietPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toYouPage;


    //groupsList.getItems().addAll(LoginController.currentAccount.groupList); //when login is working tis will use the
    //for now just fill with test data
    Account a = new Account("FullName", "Email.com","userN","pass1");
    Account b = new Account("FullName2", "Email.com2","userN2","pass2");
    Account c = new Account("FullName3", "Email.com3","userN3","pass3");


    Group gA = new Group(a,"group1","a");
    Group gB = new Group(b,"group2","b");
    Group gC = new Group(c,"group3","c");
    Group gD = new Group(a,"group4","d");
    Group gE = new Group(b,"group5","e");



    @FXML
    public void initialize()throws Exception {
        ArrayList<Group> gr = new ArrayList<>();
        gr.add(gA);gr.add(gB);gr.add(gC);gr.add(gD);gr.add(gE);
        ObservableList<Group> olg = FXCollections.observableArrayList(gr);
        groupsList.setItems(olg);
        //get the list of strings from current account
        //read these from the file
        //populate the listview with the matching objects
    }

    public void selectGroup(ActionEvent ae)throws Exception{
        if (groupsList.getSelectionModel().getSelectedItems().size() > 0) {
            Group selectedGroup = (Group) groupsList.getSelectionModel().getSelectedItem();
            System.out.println(selectedGroup);
            GroupsController.currentGroup = selectedGroup;
            Parent signUpParent = FXMLLoader.load(getClass().getResource("Groups.fxml"));
            Scene signUpViewScene = new Scene(signUpParent);
            Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.setResizable(true);
            window.setMaximized(true);
            window.show();
        }
        else
            System.out.println("select a group");
    }

    public void leaveGroup1(ActionEvent ae) {

        if (groupsList.getSelectionModel().getSelectedItems().size()>0){
            Group selectedGroup = (Group) groupsList.getSelectionModel().getSelectedItem();
            if (Account.getInstance().getUsername()!=selectedGroup.getGroupOwner()){
                groupsList.getItems().remove(selectedGroup);
                if(selectedGroup.getGroupAdmins().contains(Account.getInstance().getUsername()))
                    selectedGroup.getGroupAdmins().remove(Account.getInstance().getUsername());
                Account.getInstance().getGroupList().remove(selectedGroup);
                selectedGroup.getGroupMembers().remove(Account.getInstance().getUsername());
            }
        }
    }

    public void CreateGroup(ActionEvent ae) throws Exception{
        System.out.println("create group");
        Parent p = FXMLLoader.load(getClass().getResource("NewGroupPop.fxml"));
        Stage w = new Stage();
        w.initModality(Modality.APPLICATION_MODAL);
        //w = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        w.setTitle("New Group");
        w.setResizable(false);
        Scene x = new Scene(p);
        w.setScene(x);
        w.showAndWait();
    }

    public void joinGroup(ActionEvent ae)throws Exception{
        Parent p = FXMLLoader.load(getClass().getResource("JoinGroupPop.fxml"));
        Stage w = new Stage();
        w.initModality(Modality.APPLICATION_MODAL);
        w.setTitle("Join Group");
        w.setResizable(false);
        Scene x = new Scene(p);
        w.setScene(x);
        w.showAndWait();
    }

    public void toHomePage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }



    public void toGoalsPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("GoalsPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void toYouPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("YouPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void toDietPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("DietPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void toActivityPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("Activity.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.setMaximized(true);
        window.show();
    }

    public void logOutButton (ActionEvent ae)throws Exception{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Parent signUpParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene signUpViewScene = new Scene(signUpParent, 600, 400);
            Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            window.setScene(signUpViewScene);
            window.setResizable(false);
            window.show();
        }
    }

}
