package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Account {
    enum Sex {
        MALE, FEMALE

    }
    enum BodyType{
        ECTOMORPH, ENDOMORPH, MESOMORPH
    }

    //fields
    private String username;
    private String email;
    private String password;
    private String name;
    private String surname;
    private JFXTextField fullname;
    private Sex sex;
    private BodyType bodyType;

    public Account(JFXTextField email, JFXTextField username, JFXPasswordField password, JFXTextField fullname, JFXPasswordField confirmPass, Sex x) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        sex = x;
    }

    //another constructor
    public Account(JFXTextField email, JFXTextField username, JFXPasswordField password, JFXTextField fullname, JFXPasswordField confirmPass, Sex x, BodyType y,  ){
    public Account(String fullname, String email, String username, String password) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        x = null;
        y = null;
    }

    public Account(String email) {
        this.email = email;
    }


    //FitnessRegime fitnessRegime;
    enum Sex {MALE, FEMALE}

    ;
    //goals Goal
    //diet Diet
    AccountDetails details;
    //UserDetails class with weight height profile pic etc

    //GETTERS & SETTERS
    public JFXTextField getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public JFXTextField getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public AccountDetails getDetails() {
        return details;
    }

    public void setDetails(AccountDetails details) {

        this.details = details;
    }
//
//    public ArrayList<Account> accountArrayList(){
//       accountArrayList().add(this.fullname)
//        account[0] = this.fullname;
//        account[1] = this.email;
//        account[2] = this.username;
//        account[3]= this.password;
//
//    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +

                '}';
    }
}