//package sample;
//
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXPasswordField;
//import com.jfoenix.controls.JFXTextField;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.Parent;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import com.jfoenix.controls.JFXListView;
//import javafx.event.ActionEvent;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
//import javafx.scene.control.SelectionMode;
//
//import javax.imageio.IIOException;
//import javax.swing.*;
//import java.io.IOException;
//
//public class NewGroupPopController {
//
//    @FXML JFXButton cancelNewGroup;
//    @FXML JFXTextField newGroupName;
//    @FXML JFXPasswordField newGroupPass;
//    @FXML JFXButton submitGroup;
//    @FXML Label notify2;
//
//    public void closePop(ActionEvent ae){
//        Stage w = (Stage) ((Node) ae.getSource()).getScene().getWindow();
//        w.close();
//    }
//    public void createGroupButton(ActionEvent ae)throws IOException {
//        String groupName = newGroupName.getText();
//        String groupPass = newGroupPass.getText();
//        boolean isAvailable = false;
//        boolean validPass = false;
//            Group g = Group.findGroup(groupName);
//            System.out.println(g);
//            if (g==null)
//                isAvailable = true;
//            if (groupPass.length()>2)
//                validPass = true;
//            if (validPass && isAvailable){
//                notify2.setText("Success");
//                Group newGroup = new Group(LoginController.currentAccount, groupName, groupPass);
//                Group.addGroup(newGroup);
//                LoginController.currentAccount.groupList.add(groupName);
//            }
//            else if(!isAvailable)
//                notify2.setText("Group name taken");
//            else if(!validPass)
//                notify2.setText("Really?");
//            Stage w = (Stage) ((Node) ae.getSource()).getScene().getWindow();w.close();
//    }
//}
//
