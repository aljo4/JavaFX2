package sample.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import sample.Model.*;

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
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

public class GroupsController {

    public static Group currentGroup;

    @FXML JFXListView groupMembersList;
    @FXML Label groupName;
    @FXML JFXButton backToSocial;
    @FXML JFXButton leaveGroup2;
    @FXML Label grouppasswordforowner;
    @FXML JFXButton toHomePage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toDietPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toYouPage;

    @FXML
    public void initialize(){
        System.out.println(currentGroup.getGroupMembers());
        groupMembersList.getItems().addAll(currentGroup.getGroupMembers());
        groupName.setText(currentGroup.getGroupName());
        if (Account.getInstance().getUsername()==currentGroup.getGroupOwner()){
            grouppasswordforowner.setText("Password is: "+currentGroup.getGroupPass());
        }
    }

    public void backToSocial(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("SocialPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void leaveGroup2(ActionEvent ae) throws Exception{
        try {
            Account.getInstance().getGroupList().remove(currentGroup);
        }
        catch (Exception doesNotExist){
            System.out.println("not a member of this group");
        }
        Parent signUpParent = FXMLLoader.load(getClass().getResource("SocialPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void deleteGroup(ActionEvent ae){
        if (currentGroup.getGroupOwner()==Account.getInstance().getUsername()){
            //delete off of group array list
        }
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
        Parent signUpParent = FXMLLoader.load(getClass().getResource("ActivityPage.fxml"));
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
