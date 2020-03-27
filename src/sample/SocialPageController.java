package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXListView;

public class SocialPageController {

    @FXML JFXListView groupsList;
    @FXML JFXButton groupSelect;
    @FXML JFXButton leaveGroup1;
    @FXML JFXButton createGroup;
    @FXML JFXButton joinGroup;


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
    public void initialize()throws Exception{

        if (Account.getInstance() != null) {
            if (Account.getInstance().getGroupList().size() > 0)
                groupsList.getItems().addAll(Account.getInstance().getGroupList());
        }
//        else
//            groupsList.getItems().addAll(gA,gB,gC,gD,gE);//as i do not have complete account yet
//        groupsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        LoginController.getCurrentAccount() = new Account("FullName", "email@ma.com",
//                "Nfull", "pass1" );

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
            window.setResizable(false);
            window.show();
        }
        else
            System.out.println("select a group");
    }

    public void leaveGroup1(ActionEvent ae) {

        if (groupsList.getSelectionModel().getSelectedItems().size()>0){
            Group selectedGroup = (Group) groupsList.getSelectionModel().getSelectedItem();
            if (Account.getInstance().getUsername()!=selectedGroup.groupOwner){
                groupsList.getItems().remove(selectedGroup);
                if(selectedGroup.groupAdmins.contains(Account.getInstance().getUsername()))
                    selectedGroup.groupAdmins.remove(Account.getInstance().getUsername());
                Account.getInstance().getGroupList().remove(selectedGroup);
                selectedGroup.groupMembers.remove(Account.getInstance().getUsername());
            }
        }
    }

    public void CreateGroup(ActionEvent ae) throws Exception{
        System.out.println("create group");
        Parent p = FXMLLoader.load(getClass().getResource("newGroupPop.fxml"));
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
        Parent p = FXMLLoader.load(getClass().getResource("joinGroupPop.fxml"));
        Stage w = new Stage();
        w.initModality(Modality.APPLICATION_MODAL);
        w.setTitle("Join Group");
        w.setResizable(false);
        Scene x = new Scene(p);
        w.setScene(x);
        w.showAndWait();
    }


}
