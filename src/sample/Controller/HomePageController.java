package sample.Controller;
import java.io.*;
import java.time.LocalDate;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.*;

public class HomePageController {

    @FXML JFXButton toSocialPage;
    @FXML JFXButton toGoalsPage;
    @FXML JFXButton toDietPage;
    @FXML JFXButton toActivityPage;
    @FXML JFXButton toYouPage;
    @FXML JFXButton updateWeightButton;
    @FXML Label currentWeight;
    @FXML Label newTarget;
    @FXML Label calInToday;
    @FXML Label calBurnToday;
    @FXML MenuItem manageAccountButton;
    @FXML MenuItem logOut;
    @FXML JFXTextField newWeight;

    @FXML
    public void initialize()throws Exception{
       Account a = Account.getInstance();
        Account.getInstance().getAccountLists().readWeight();
        Account.getInstance().getAccountLists().readMeals();
        a.getAccountLists().readActivities();
        a.getAccountLists().readGoals();
        double targetWeight= 0.0;

        targetWeight = a.getOneGoal().getGoalWeight();
        System.out.println(a.getOneGoal().getGoalWeight());
        newTarget.setText(String.valueOf(targetWeight));
        int calin = 0;
        for (Meal m:a.getAllMyMeals()) {
            if(m.getMealDate().compareTo(LocalDate.now())==0){
                calin += m.getCaloricIntake();
            }
        }
        double curWeight = 0.0;
        curWeight = a.getWeight();
        currentWeight.setText(String.valueOf(Double.parseDouble(String.valueOf(curWeight))));
        calInToday.setText(String.valueOf(calin));
        //when activites is done do calburnToday
        newWeight.setStyle("-fx-text-inner-color: White;");
    }

    public void toSocialPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/SocialPage.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }



    public void toGoalsPage(ActionEvent ae)throws Exception{
        Parent signUpParent = FXMLLoader.load(getClass().getResource("../View/GoalsSetting.fxml"));
        Scene signUpViewScene = new Scene(signUpParent);
        Stage window = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        window.setScene(signUpViewScene);
        window.setResizable(true);
        window.show();
    }

    public void toYouPage(ActionEvent ae)throws Exception {
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

    public void updateWeight(ActionEvent ae) throws IOException {
        Account a = Account.getInstance();
        double i = Double.parseDouble(newWeight.getText());
        //a.pastweights.add i + localdate.now
        a.setWeight(i);
//        BufferedReader br = null;
//        try{
//            br = new BufferedReader((new FileReader("src\\sample\\Goals.txt")));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if(br !=null) {
//            String st;
//            while ((st = br.readLine()) != null) {
//                String[] splitted = st.split(",");
//                if (a.getFullname().equals(splitted[0])) {
//                    splitted[2].replace(newWeight.getText());
//                Account.getInstance().getWeight();
//                }
//            }
//        }
    }


//    public void makeMan(){
//
//        Edible e1 = new Edible(Edible.foodType.FOOD, "chicken", 200);
//        Edible e2 = new Edible(Edible.foodType.FOOD, "potato", 150);
//        Edible e3 = new Edible(Edible.foodType.DRINK, "Banana Milkshake", 180);
//        Edible e4 = new Edible(Edible.foodType.FOOD, "pork", 203);
//        Edible e5 = new Edible(Edible.foodType.FOOD, "hummus", 171);
//        Edible e6 = new Edible(Edible.foodType.DRINK, "beer", 302);
//        Edible e7 = new Edible(Edible.foodType.FOOD, "biscuits", 428);
//        Edible e8 = new Edible(Edible.foodType.FOOD, "sweets", 150);
//        Edible e9 = new Edible(Edible.foodType.DRINK, "protein shake", 111);
//        Edible e10 = new Edible(Edible.foodType.FOOD, "slops", 010);
//        Edible e11 = new Edible(Edible.foodType.FOOD, "chips", 210);
//        Edible e12 = new Edible(Edible.foodType.DRINK, "gravy", 180);
//
//        ArrayList<Edible> a1 = new ArrayList<>();
//        a1.add(e1);a1.add(e3);a1.add(e8);a1.add(e2);
//        Meal m1 = new Meal(Meal.mealType.LUNCH, a1);
//        m1.setMealDate(m1.getMealDate().minusDays(1));
//
//        ArrayList<Edible> a2 = new ArrayList<>();
//        a2.add(e2);a2.add(e3);a2.add(e8);a2.add(e2);
//        Meal m2 = new Meal(Meal.mealType.BREAKFAST, a2);
//        m2.setMealDate(m2.getMealDate().minusDays(5));
//
//        ArrayList<Edible> a3 = new ArrayList<>();
//        a3.add(e4);a3.add(e9);a3.add(e1);a3.add(e6);
//        Meal m3 = new Meal(Meal.mealType.DINNER, a3);
//        m3.setMealDate(m3.getMealDate().minusDays(4));
//
//
//        ArrayList<Edible> a4 = new ArrayList<>();
//        a4.add(e5);a4.add(e12);a4.add(e7);a4.add(e4);
//        Meal m4 = new Meal(Meal.mealType.SNACK, a4);
//        m4.setMealDate(m4.getMealDate().minusDays(3));
//
//        ArrayList<Edible> a5 = new ArrayList<>();
//        a5.add(e10);a5.add(e7);a5.add(e2);a5.add(e5);
//        Meal m5 = new Meal(Meal.mealType.LUNCH, a5);
//        m5.setMealDate(m5.getMealDate().minusDays(2));
//
//        ArrayList<Edible> a6 = new ArrayList<>();
//        a6.add(e6);a6.add(e7);a6.add(e4);a6.add(e11);
//        Meal m6 = new Meal(Meal.mealType.BREAKFAST, a6);
//
//        ArrayList<Meal> myMeals = new ArrayList<>();
//        myMeals.add(m1);myMeals.add(m2);myMeals.add(m3);myMeals.add(m4);myMeals.add(m5);myMeals.add(m6);
//        Account.getInstance().setMeals(myMeals);
//
//        Goals g1 = new Goals(Goals.goalType.WEIGHTLOSS, 95, 75, LocalDate.now().minusDays(5), LocalDate.now().plusDays(1));
//        Goals g2 = new Goals(Goals.goalType.WEIGHTGAIN, 60, 75, LocalDate.now().minusDays(4), LocalDate.now().plusDays(2));
//        Goals g3 = new Goals(Goals.goalType.WEIGHTLOSS, 95, 94, LocalDate.now().minusDays(3), LocalDate.now().plusDays(3));
//        Goals g4 = new Goals(Goals.goalType.WEIGHTGAIN, 30, 26, LocalDate.now().minusDays(2), LocalDate.now().plusDays(4));
//        Goals g5 = new Goals(Goals.goalType.WEIGHTLOSS, 95, 75, LocalDate.now().minusDays(1), LocalDate.now().plusDays(5));
//        ArrayList<Goals> ga = new ArrayList<>();
//        ga.add(g1);ga.add(g2);ga.add(g3);ga.add(g4);ga.add(g5);
//        Account.getInstance().setGoals(ga);
//
//    }
}

