package sample;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
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

    @FXML
    public void initialize(){
        System.out.println(currentGroup.groupMembers);
        groupMembersList.getItems().addAll(currentGroup.groupMembers);
        groupName.setText(currentGroup.groupName);
        if (LoginController.getCurrentAccount().getUsername()==currentGroup.groupOwner){
            grouppasswordforowner.setText("Password is: "+currentGroup.groupPass);
        }
    }

    public void backToSocial(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("SocialPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(false);
        window.show();
    }

    public void leaveGroup2(ActionEvent ae) throws Exception{
        try {
            LoginController.getCurrentAccount().getGroups().remove(currentGroup);
        }
        catch (Exception doesnotexist){
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
        if (currentGroup.groupOwner==LoginController.getCurrentAccount().getUsername()){
            //delete off of group array list
        }
    }

}
