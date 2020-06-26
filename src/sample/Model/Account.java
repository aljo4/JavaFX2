package sample.Model;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;


public class Account implements Serializable {
    //instance variables below
    private String username;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String fullname;
    private ArrayList<Goals> goals;
    private Goals oneGoal;
    private Meal meal;
    private ArrayList<Meal> allMyMeals;
    private ArrayList<Activity.Activities> exercises;
    private Activity.Activities activities;
    private TypeOfDiet diet; //user can only have one diet at a time
    private double height; //TODO: have bounds for this
    private double weight; //TODO: have bounds for this
    private double bmi;
    private double idealWeight;
    private ArrayList<String> groupList;
    private ArrayList friends;
    private AccountLists accountLists = new AccountLists();


    public enum Gender { //enum class for gender
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private final String genderType;

        Gender(String genderType) {
            this.genderType = genderType;
        }
    }

    ;
    private Gender gender; //instance variable of type enum Gender
//---------------end of gender enum class ------------------

    private static Account anAccount;

    private Account() {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.fullname = fullname;
        goals = new ArrayList<Goals>();
        this.oneGoal = oneGoal;
        this.meal = meal;
        this.height = height;
        this.weight = weight;
        this.idealWeight = idealWeight;
        groupList = new ArrayList<String>();
        friends = new ArrayList();
        allMyMeals = new ArrayList<>();
        this.gender = gender;
        exercises = new ArrayList<Activity.Activities>();
        this.activities = activities;
        this.bmi = bmi;
    }

    public static Account getInstance() { //singleton so every class uses the same instantiation of the object at runtime
        if (anAccount == null) {
            anAccount = new Account();
        }
        return anAccount;
    }

    public Account(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }

    public Account(String fullname, String email, String username, String password) { //constructor when creating an account - signing up
        this();
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    //-------------------------------------START OF ACCESSOR METHODS ------------------------------
    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }


    public ArrayList<Activity.Activities> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Activity.Activities> exercises) {
        this.exercises = exercises;
    }

    public Activity.Activities getActivities() {
        return activities;
    }

    public void setActivities(Activity.Activities activities) {
        this.activities = activities;
    }

    public TypeOfDiet getDiet() {
        return diet;
    }


    public void setDiet(TypeOfDiet diet) {
        this.diet = diet;
    }

    public Goals getOneGoal() {
        return oneGoal;
    }

    public void setOneGoal(Goals oneGoal) {
        this.oneGoal = oneGoal;
    }

    public Account(String email) {
        this();
        this.email = email;
    }

    //FitnessRegime fitnessRegime;


    public ArrayList<String> getGroupList() {
        return groupList;
    }

    public AccountLists getAccountLists() {
        return accountLists;
    }


    //UserDetails class with weight height profile pic etc
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Goals> getGoals() {
        return goals;
    }

    public Goals getGoalsAtIndex(int i) {
        return goals.get(i);
    }

    public Meal getMeal() {
        return meal;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getIdealWeight() {
        return idealWeight;
    }

    public ArrayList getFriends() {
        return friends;
    }

    public ArrayList<Meal> getAllMyMeals() {
        return allMyMeals;
    }

    public void setAllMyMeals(ArrayList<Meal> allMyMeals) {
        this.allMyMeals = allMyMeals;
    }

    public TypeOfDiet getTypeOfDiet() {
        return diet;
    }

    public Gender getGender() {
        return gender;
    }

    public static Account getAnAccount() {
        return anAccount;
    }

    public void setGoals(ArrayList<Goals> goals) {
        this.goals = goals;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public void setTypeOfDiet(TypeOfDiet diet) {
        this.diet = diet;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setIdealWeight(double idealWeight) {
        this.idealWeight = idealWeight;
    }

    public void setGroupList(ArrayList<String> groupList) {
        this.groupList = groupList;
    }

    public void setFriends(ArrayList friends) {
        this.friends = friends;
    }

    public void setAccountLists(AccountLists accountLists) {
        this.accountLists = accountLists;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static void setAnAccount(Account anAccount) {
        Account.anAccount = anAccount;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
//-------------------------------------END OF ACCESSOR METHODS --------------------------------

    @Override
    public String toString() {
        return fullname +
                "," + email +
                "," + username +
                "," + password +
                "," + height +
                "," + weight +
                "," + idealWeight +
                "," + gender.genderType;
               // "," + goals.toString() +
               // "," + exercises;
    }

    public String toStringForFileAppend(){
        return fullname;
    }

    //nested static class called AccountLists. This stores accounts objects in arraylists in a file
    public static class AccountLists {
        private ArrayList<Account> accounts;

        public AccountLists() {
            accounts = new ArrayList<>();
        }

        public void addtolist(Account newAccount) {
            accounts.add(newAccount);
        }

        public ArrayList<Account> getAccounts() {
            return accounts;
        }
//method to save account to file
        public void saveToFile() { //make sure to change the path when using this
            try {
                File filename = new File("src\\sample\\Accounts.txt");
                if (!filename.exists()) {
                    filename.createNewFile();
                }
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Account account : accounts) {
                    bw.write(account.toString());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//method to save account's goal to file
        public void saveGoalToFile(Goals goal) {
            try {
                File filename = new File("src\\sample\\Goals.txt");
                if (!filename.exists()) {
                    filename.createNewFile();
                }
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < Account.getInstance().getGoals().size(); i++) {
                    bw.write(goal.toString().trim());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//save activity to file
        public void saveActivityToFile(Activity activities) {
            try {
                File filename = new File("src\\sample\\Activities.txt");
                if (!filename.exists()) {
                    filename.createNewFile();
                }
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < Account.getInstance().getExercises().size(); i++) {
                    bw.write(activities.getActivitiesEnum().toStringtoFile());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//method save meal to file
        public void saveMeal(Meal meal) {
            try {
                File filename = new File("src\\sample\\Meals.txt");
                if (!filename.exists()) {
                    filename.createNewFile();
                }
                FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(meal.toStringForMeals());
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//this method reads meal from file and adds to the Account's arraylist
        public ArrayList<Meal> readMeals() throws IOException {
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader("src\\sample\\Meals.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<Meal> meals = new ArrayList<>();

            if(br!= null) {
                Meal meal;
                Edible eat;
                String drink, food, mealType;
                int drinkCal, foodCal;
                String st;

                try {
                    while ((st = br.readLine()) != null) {
                        String[] splitted = st.split(",");
                       drink = splitted[1];
                       drinkCal = Integer.parseInt(splitted[2]);
                       food = splitted[3];
                       foodCal = Integer.parseInt(splitted[4]);
                       mealType= splitted[5];
                       eat = new Edible(drink,drinkCal,food,foodCal);
                       meal = new Meal(Meal.mealType.valueOf(mealType),eat, LocalDate.parse(splitted[7]));
                       Account.getInstance().setMeal(meal);
                       meals.add(meal);
                       Account.getInstance().setAllMyMeals(meals);

 }
                }catch(NumberFormatException ex){

                }
            }
            return meals;

        }

        public ArrayList<Goals> readGoals() throws IOException {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("src\\sample\\Goals.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<Goals> goalsList = new ArrayList<Goals>();

            if (br == null) {
                return null;
            } else {
                Goals goal;
                String goalType, st;
                double currentWeight, goalWeight;
                LocalDate startDate, endDate;
                try {
                    while ((st = br.readLine()) != null) {
                        String[] splitted = st.split(",");
                        if (Account.getInstance().fullname.equals(splitted[0])) {
                            goalType = splitted[1];
                            currentWeight = Double.parseDouble(splitted[2]);
                            goalWeight = Double.parseDouble(splitted[3]);
                            startDate = LocalDate.parse(splitted[4]);
                            endDate = LocalDate.parse(splitted[5]);
                            goal = new Goals(Goals.goalType.valueOf(goalType.toUpperCase()), currentWeight, goalWeight, startDate, endDate);
                            Account.getInstance().setOneGoal(goal);
                            goalsList.add(goal);
                            Account.getInstance().setGoals(goalsList);
                        }
                    }
                } catch (NumberFormatException ex) {
                }
            }
            System.out.println(goalsList.size());
            return goalsList;
        }

        public void readWeight() throws IOException {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("src\\sample\\Accounts.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (br != null) {
                double weight;
                String st;
                try {
                    while ((st = br.readLine()) != null) {
                        String[] splitted = st.split(",");
                        weight = Double.parseDouble(splitted[5]);
                        Account.getInstance().setWeight(weight);

                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(Account.getInstance().getWeight());
        }


//check if the user exists in file when logging in
        public static boolean checkUserExists(String email, String password) throws IOException {
            boolean existingUser = false;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("src\\sample\\Accounts.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (br != null) {
                String st;
                while ((st = br.readLine()) != null) {
                    String[] splitted = st.split(",");
                    //System.out.println(splitted[1]);
                    if (email.equals(splitted[1]) && password.equals(splitted[3])) {
                        existingUser = true;
                        Account a = Account.getInstance();
                        a.setFullname(splitted[0]);
                        a.setEmail(splitted[1]);
                        a.setUsername(splitted[2]);
                        a.setPassword(splitted[3]);
                        a.setHeight(Double.parseDouble(splitted[4]));
                        a.setWeight(Double.parseDouble(splitted[5]));
                        a.setIdealWeight(Double.parseDouble(splitted[6]));
                       a.setGender(Account.Gender.valueOf(splitted[7].toUpperCase()));
                        break;
                    }
                }
            }
            return existingUser;
        }



//method to display password for existing customer
        public static String forgottenPassword(String email) throws IOException {
            BufferedReader br = null;
            String password ="";
            try{
                br = new BufferedReader((new FileReader("src\\sample\\Accounts.txt")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if(br !=null){
                String st;
                while ((st = br.readLine()) != null){
                    String[] splitted = st.split(",");
                    if(email.equals(splitted[1])){
                        System.out.println(splitted[3]);
                        password = splitted[3];
                        return password;


                    }
                }
            }
          return password;

        }
//checking
        public void checkUserExists() {

            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("src\\sample\\Accounts.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (br != null)
                for (int i = 0; i < accounts.size(); i++)
                    System.out.println(accounts.get(i));
        }
    }

}

