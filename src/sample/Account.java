package sample;
import java.io.*;
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
    private Diet diet; //user can only have one diet at a time
    private double height; //TODO: have bounds for this
    private double weight; //TODO: have bounds for this
    private double idealWeight;
    private ArrayList<String> groupList;
    private ArrayList friends;
    private AccountLists accountLists = new AccountLists();


    public enum Gender { //enum class for gender
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private final String genderType;
        Gender(String genderType){
            this.genderType = genderType;
        }
    };
    private Gender gender; //instance variable of type enum Gender
//---------------end of gender enum class ------------------

    private static Account anAccount;

    private Account() {
        this.username= username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.fullname = fullname;
        goals = new ArrayList<Goals>();
        diet = diet;
        this.height = height;
        this.weight = weight;
        this.idealWeight = idealWeight;
        groupList = new ArrayList<String>();
        friends = new ArrayList();
        this.gender = gender;
    }

    public static Account getInstance() {
        if(anAccount == null){
            anAccount = new Account();
        }
        return anAccount;
    }

    public Account(String email, String password){
        this();
        this.email = email;
        this.password = password;
    }


    public Account(String fullname, String email, String username, String password) {
        this();
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
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

    public Goals getGoalsAtIndex(int i){
        return goals.get(i);
    }

    public Diet getDiet() {
        return diet;
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

    public Gender getGender() {
        return gender;
    }

    public static Account getAnAccount() {
        return anAccount;
    }

    public void setGoals(ArrayList<Goals> goals) {
        this.goals = goals;
    }

    public void setDiet(Diet diet) {
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


    @Override
    public String toString() {
        return  fullname +
                 ","+  email +
               ","+  username +
             ","+  password +
                "," + height +
                "," + weight +
                "," + idealWeight +
                "," + gender.genderType +
                "," + goals.toString();
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

        public void saveToFile() {
            try {
                File filename = new File("C:\\Users\\Samuel\\Documents\\UEA\\Second Year\\Networks\\JavaFX2\\src\\sample\\Accounts.txt");
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

    public void saveGoalToFile(Goals goal) {
        try {
            File filename = new File("C:\\Users\\Samuel\\Documents\\UEA\\Second Year\\Networks\\JavaFX2\\src\\sample\\Goals.txt");
            if (!filename.exists()) {
                filename.createNewFile();
            }
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0; i< Account.getInstance().getGoals().size(); i++){
                bw.write(goal.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static boolean checkUserExists(String email, String password) throws IOException {
            boolean existingUser = false;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Documents\\UEA\\Second Year\\Networks\\JavaFX2\\src\\sample\\Accounts.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (br != null) {
                String st;
                while ((st = br.readLine()) != null) {
                    String[] splitted = st.split(",");
                   // System.out.println(splitted[1]);
                    if (email.equals(splitted[1]) && password.equals(splitted[3])) {
                        existingUser = true;
                        break;
                    }
                }
//                for (int i = 0; i < accounts.size(); i++)
//                    if (email.equals(accounts.get(i).getEmail()) && password.equals(accounts.get(i).getPassword())) {
//                        existingUser = true;
//                        System.out.println(accounts.get(i).getEmail());
            }
            return existingUser;
        }
        public void checkUserExists() {

            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("C:\\Users\\Samuel\\Documents\\UEA\\Second Year\\Networks\\JavaFX2\\src\\sample\\Accounts.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (br != null)
                for (int i = 0; i < accounts.size(); i++)
                        System.out.println(accounts.get(i));
                    }
        }

    }

