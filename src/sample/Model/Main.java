package sample.Model;

import com.sun.jdi.PrimitiveValue;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import sample.Controller.*;

import java.util.Objects;


public class Main extends Application {
    private ObservableList<Account> accountData = FXCollections.observableArrayList();
//code for the home screen goes here
    public Main(){
     //accountData.add(new Account("Samuel","nkg17tru@uea.ac.uk","samuel123", "Samuel", "Bedeau"));
    }
    public ObservableList<Account> getAccountData(){
        return accountData;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample/View/sample.fxml")));
        primaryStage.setTitle("Health Tracker");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception{
        Account.getInstance().getAccountLists().saveToFile();
  //      Account.getInstance().getAccountLists().saveMeal();
//        Account.getInstance().getAccountLists().

    }

    @Override
    public void init() throws Exception{
        try{
            Account.getInstance().getAccountLists().checkUserExists();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
