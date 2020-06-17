package sample.Model;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.delete;
import static java.nio.file.Files.readAllLines;

public class Group {
    String groupName;
    String groupPass;
    String groupOwner;
    ArrayList<String> groupMembers;
    ArrayList<String> groupAdmins;
    Goals groupGoal;
    //object containing past successful goals

    public Group() {
    }

    public Group(Account creator, String gName, String pass) {
        this.groupOwner = creator.getUsername();
        this.groupName = gName;
        this.groupAdmins = new ArrayList<>();
        this.groupMembers = new ArrayList<>();
        groupAdmins.add(creator.getUsername());
        groupMembers.add(creator.getUsername());
        this.groupPass = pass;
    }

    //constructors
    public Group(String groupName, String groupPass, String groupOwner, String groupMembers, String groupAdmins) {
        this.groupName = groupName;
        this.groupPass = groupPass;
        this.groupOwner = groupOwner;
        this.groupAdmins = new ArrayList<>();
        this.groupMembers = new ArrayList<>();


        ArrayList<String> groupMems = new ArrayList<>();
        groupMembers = groupMembers.replaceAll("[\\[\\]]", "");
        for (String s : groupMembers.split("/.")) {
            groupMems.add(s);
        }
        this.groupMembers = groupMems;

        ArrayList<String> groupAdms = new ArrayList<>();
        groupAdmins = groupAdmins.replaceAll("[\\[\\]]", "");
        for (String s : groupAdmins.split("/.")) {
            groupAdms.add(s);
        }
        this.groupAdmins = groupAdms;

    }




//manipulate storage file for groups
    public static void clearGroupFile()throws IOException{
        Path groupsPath = Paths.get("src/csv/GroupsFile.csv");
        Path tempPath = Paths.get("src/csv/TempFile.csv");
        Path tempFile = Files.createFile(tempPath);
        Files.copy(tempPath, groupsPath, StandardCopyOption.REPLACE_EXISTING);
        delete(tempPath);
    }

    public static void addGroup(Group newGroup) throws IOException {
    //open file and add as single line
    Path groupsFile = Paths.get("src/csv/GroupsFile.csv");
    Files.write(groupsFile, newGroup.toStringForFile().getBytes(), StandardOpenOption.APPEND);
    }

    public static void deleteGroup(Group aGroup)throws IOException{
        Path groupsFile = Paths.get("src/csv/GroupsFile.csv");
        Path tempPath = Paths.get("src/csv/TempFile.csv");
        Path tempFile = Files.createFile(tempPath);
        BufferedReader reader = Files.newBufferedReader(groupsFile, Charset.defaultCharset());
        String line = null;
        Scanner x = new Scanner(groupsFile);
        String groupName, password, groupOwner, groupMembers, groupAdmins;
        x.useDelimiter("[,|\n]");
        while (x.hasNext()){
            groupName = x.next();
            password = x.next();
            groupOwner = x.next();
            groupMembers = x.next();
            groupAdmins = x.next();
            if(!groupName.equals(aGroup.groupName)){
                line = groupName + "," + password + "," + groupOwner + "," + groupMembers + "," + groupAdmins +"\n";
                Files.write(tempFile, line.getBytes(), StandardOpenOption.APPEND);
            }
        }
        x.close();
        reader.close();
        Files.copy(tempPath, groupsFile, StandardCopyOption.REPLACE_EXISTING);
        delete(tempPath);
    }

    public void addAdmin(String newAdm) {
    this.groupAdmins.add(newAdm);
}

    public static void addMember(String newMem) throws IOException {
        Path groupsPath = Paths.get("src/csv/GroupsFile.csv");
        Path tempPath = Paths.get("src/csv/TempFile.csv");
        Path newTempPath = Files.createFile(tempPath);
        BufferedWriter writer = Files.newBufferedWriter(newTempPath, Charset.defaultCharset());
        PrintWriter pw = new PrintWriter(writer);
        String groupName, password, groupOwner, groupMembers, groupAdmins;
        Scanner x = new Scanner(groupsPath);
        x.useDelimiter("[,\n]");
        while (x.hasNext()) {
            groupName = x.next();
            password = x.next();
            groupOwner = x.next();
            groupMembers = x.next();
            groupAdmins = x.next();
            if (groupName.equals(groupName)) {
                groupMembers += "," + newMem;
            }
            pw.println(groupName + "," + password + " " + groupOwner + " " + groupMembers + " " + groupAdmins);
        }
        x.close();
        pw.flush();
        pw.close();
        writer.close();
        try {
            Files.copy(tempPath, groupsPath, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(tempPath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Group findGroup(String groupName) throws IOException {
        FileReader fr = new FileReader("src/csv/GroupsFile.csv");
        BufferedReader br = new BufferedReader(fr);
        String row = "";
        while ((row = br.readLine()) != null) {
            String[] sArr = row.split(",");
            if (sArr[0].equals(groupName))
                return new Group(sArr[0], sArr[1], sArr[2], sArr[3], sArr[4]);
        }
        br.close();
        fr.close();
        return null;
    }

    public static ArrayList<Group> loadGroups() throws IOException {
        ArrayList<Group> someGroups = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/csv/GroupsFile.csv"));
        String row = "";
        while ((row = br.readLine()) != null) {
            System.out.println(" line: " + row);
            String[] sArr = row.split(",");
            Group temp = new Group(sArr[0], sArr[1], sArr[2], sArr[3], sArr[4]);
            someGroups.add(temp);
            System.out.println(temp);
        }
        System.out.println(someGroups);
        return someGroups;

    }

    public static void deleteGroup(String gn) throws IOException {
        //open file and delete groupName
        String filePath = "src/csv/GroupsFile.csv";
        String tempFile = "src/csv/TempFile.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String groupName, password, groupOwner, groupMembers, groupAdmins;
        Scanner x;
        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        x = new Scanner(new File(filePath));
        x.useDelimiter("[,\n]");
        while (x.hasNext()) {
            groupName = x.next();
            password = x.next();
            groupOwner = x.next();
            groupMembers = x.next();
            groupAdmins = x.next();
            if (!groupName.equals(gn)) {
                pw.print(groupName + "," + password + "," + groupOwner + "," + groupMembers + "," + groupAdmins + "\n");
            }
        }
        x.close();
        pw.flush();
        pw.close();
        oldFile.delete();
        File dump = new File(filePath);
        newFile.renameTo(dump);
    }

//different toString methods

    @Override
    public String toString() {
        return "Group name: " + groupName + '\n' +
                "Group owner: " + groupOwner + '\n' +
                "Number of members: " + groupMembers.size();

    }

    public String toStringForObject() {
        return "Group name: " + groupName + ", Group owner: " + groupOwner + ", Group password: " + groupPass +
                ", Group members: " + aListToString(groupMembers) + ", Group admins: " + aListToString(groupAdmins) + "\n";
    }

    public String toStringForFile() {
        return groupName + "," + groupPass + "," + groupOwner + "," + aListToString(groupMembers) +
                "," + aListToString(groupAdmins)+"\n";//and then also group goals
    }

    public static String aListToString(ArrayList<String> strings) {
        String outStr = "";
        for (int i = 0; i < strings.size(); i++) {
            if (i == strings.size() - 1) {
                outStr += strings.get(i);
                continue;
            }
            outStr += strings.get(i) + ".";
        }
        return outStr;
    }

    //setters

    public void setGroupMembers(ArrayList<String> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public void setGroupAdmins(ArrayList<String> groupAdmins) {
        this.groupAdmins = groupAdmins;
    }

    public void setGroupGoal(Goals groupGoal) {
        this.groupGoal = groupGoal;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupPass(String groupPass) {
        this.groupPass = groupPass;
    }

    public void setGroupOwner(String groupOwner) {
        this.groupOwner = groupOwner;
    }

// getters

    public ArrayList<String> getGroupMembers() {
        return groupMembers;
    }

    public ArrayList<String> getGroupAdmins() {
        return groupAdmins;
    }

    public Goals getGroupGoal() {
        return groupGoal;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupPass() {
        return groupPass;
    }

    public String getGroupOwner() {
        return groupOwner;
    }

    public static void main(String[] args)throws Exception {
        // a test Accoutn
        Account aUser = new Account("Lawrence","lol@mail.com","LozaJ","Pass1");
        //some test groups:
        Group group1 = new Group(aUser, "London Runners", "ldnrn1");
        Group group2 = new Group(aUser, "Couch to Clouds", "Potato");
        Group group3 = new Group(aUser, "Corona Loners", "v1ru5");
        Group group4 = new Group(aUser, "Bottlejob Boys", "boots");
        //adding a single group
        addGroup(group1);
        //clearing the file
        clearGroupFile();
        //adding multiple groups
        addGroup(group1);
        addGroup(group2);
        addGroup(group3);
        addGroup(group4);
        //testing delete line
        deleteGroup(group2);


    }
}
