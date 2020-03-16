package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

import java.io.File;

public class Account {
    enum Sex {
        MALE, FEMALE

    }
    enum BodyType{
        ECTOMORPH, ENDOMORPH, MESOMORPH
    }

    //fields
    private JFXTextField username;
    private JFXTextField email;
    private JFXPasswordField password;
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
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        x = null;
        y = null;
    }

    AccountDetails details;
    //UserDetails class with weight height profile pic etc

    //GETTERS & SETTERS
    public JFXTextField getUsername() {
        return username;
    }

    public void setUsername(JFXTextField username) {
        this.username = username;
    }

    public JFXTextField getEmail() {
        return email;
    }

    public void setEmail(JFXTextField email) {
        this.email = email;
    }

    public JFXPasswordField getPassword() {
        return password;
    }

    public void setPassword(JFXPasswordField password) {
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

    public void setFullname(JFXTextField fullname) {
        this.fullname = fullname;
    }

    public AccountDetails getDetails() {

        return details;
    }

    public void setDetails(AccountDetails details) {

        this.details = details;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return
                username.getText() +
                "," + email.getText() +
                "," + password.getText() +
                "," + name +
                "," + surname +
                "," + fullname.getText();
    }
}