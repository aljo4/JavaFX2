package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

import javax.imageio.IIOException;
import javax.swing.*;
public class JoinGroupPopController {

    @FXML JFXButton cancelJoinGroup;
    @FXML JFXButton joinGroup;
    @FXML JFXTextField joinGroupName;
    @FXML JFXPasswordField joinGroupPass;
    @FXML Label notify;

    public void closeJoinPop(ActionEvent ae){
        Stage w = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        w.close();
    }

    public void joinGroupButton(ActionEvent ae){
        String groupName = joinGroupName.getText();
        String groupPass = joinGroupPass.getText();
        try {
            Group g = Group.findGroup(groupName);
            System.out.println(g);
            if (g!=null) {
                System.out.println(g.getGroupPass());
                if (groupPass.equals(g.groupPass)) {
                    System.out.println("1");
                    g.addMember(LoginController.getCurrentAccount().getUsername());
                    System.out.println("2");
                    LoginController.getCurrentAccount().getGroups().add(groupName);
                    System.out.println("3");
                    notify.setText("Success!");
                    Stage w = (Stage) ((Node) ae.getSource()).getScene().getWindow();
                    w.close();
                }
                else
                    notify.setText("Wrong password");
            }
            else
                notify.setText("No group with that name");
        }
        catch (Exception ioex){
            System.out.println(":(");
        }


    }
}