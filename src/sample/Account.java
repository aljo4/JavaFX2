package sample;

public class Account {

    //fields
    String username;
    String email;
    String password;
    String name;
    String surname;
    //FitnessRegime fitnessRegime;
    enum Sex{MALE, FEMALE};
    //goals Goal
    //diet Diet
    AccountDetails details;
    //UserDetails class with weight height profile pic etc

    public Account(String username, String email, String password, String name, String surname, AccountDetails details) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.details = details;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public AccountDetails getDetails() {
        return details;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDetails(AccountDetails details) {
        this.details = details;
    }
}
