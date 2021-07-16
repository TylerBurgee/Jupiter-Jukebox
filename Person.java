/**
 * @author tylerburgee
 * Class: Person   Filename: Person.java
 * Description: This class is responsible for creating and logging into user accounts
 * Improvements: I added a method that saves the user's favorite songs.
 */

import java.io.*;
import java.util.*;

public class Person {
    // DECLARE PRIVATE VARIABLES
    private static String firstName, lastName, password, mood;
    private static String[] preferredGenres, favoriteSongs;
    
    // FULL CONSTRUCTOR
    public Person(String firstName, String lastName, String password, String[] preferredGenres, String mood, String[] favoriteSongs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.preferredGenres = preferredGenres;
        this.mood = mood;
        this.favoriteSongs = favoriteSongs;
    }
    
    // DEFAULT CONSTRUCTOR
    public Person() {
        
    }
    
    // CREATE A USER ACCOUNT BY STORING THE USER'S INFORMATION IN A .txt FILE
    public static void createUser(String fName, String lName, String password, String[] genres) {
        try {
            File file = new File(fName + lName + ".txt");
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(fName + lName + ".txt");
                
                String userInfo = 
                        "First Name: " + fName
                        + "\nLast Name: " + lName
                        + "\nPassword: " + password
                        + "\nPreferred Genres: " + genres[0] + " " + genres[1] + " " + genres[2];
                
                fileWriter.write(userInfo);
                fileWriter.close();
                
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } 
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    // LOGIN A USER ACCOUNT BY READING THE CONTENTS OF THE USER'S .txt FILE
    public static void loginUser(String fName, String lName, String currentMood) {
        mood = currentMood;
        
        try {
            File file = new File(fName + lName + ".txt");
            Scanner scan = new Scanner(file);
            
            int i = 0;
            
            while (scan.hasNextLine()) {
                switch (i) {
                    case 0:
                        String[] loginFirstName = scan.nextLine().split(": ", 0);
                        firstName = loginFirstName[1];
                        break;
                    case 1:
                        String[] loginLastName = scan.nextLine().split(": ", 0);
                        lastName = loginLastName[1];
                        break;
                    case 2:
                        String[] loginPassword = scan.nextLine().split(": ", 0);
                        password = loginPassword[1];
                        break;
                    case 3:
                        String[] loginGenres = scan.nextLine().split(": ", 0);
                        preferredGenres = loginGenres[1].split(" ", 0);
                        break;
                    default:
                        break;
                }
                i++;
            }
            scan.close();
        }
        catch (Exception e){
            System.out.println("An error ocurred.");
        }
    }
    
    public static void saveFavoriteSong(String song) {
        try {
            File file = new File(firstName + lastName + "-favorites.txt");
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(firstName + lastName + "-favorites.txt");
                
                String userInfo = 
                        "Favorites:\n" + song;
                
                fileWriter.write(userInfo);
                fileWriter.close();
                
                System.out.println("File created: " + file.getName());
            } else {
                
                FileWriter fileWritter = new FileWriter(file.getName(),true);
                BufferedWriter bw = new BufferedWriter(fileWritter);
                bw.write("\n" + song);
                bw.close();
                System.out.println("Data appended to file.");
            }
        } 
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    // SET FIRST NAME
    public void setFirstName(String fName) {
        firstName = fName;
    }
    
    // SET LAST NAME
    public void setLastName(String lName) {
        lastName = lName;
    }
    
    // SET PASSWORD
    public void setPassword(String pass) {
        password = pass;
    }
    
    // SET CURRENT MOOD
    public void setMood(String currentMood) {
        mood = currentMood;
    }
    
    // SET PREFERRED MUSIC GENRES
    public void setPreferredGenres(String[] genres) {
        preferredGenres = genres;
    }
    
    // GET FIRST NAME
    public static String getFirstName() {
        return firstName;
    }
    
    // GET LAST NAME
    public static String getLastName() {
        return lastName;
    }
    
    // GET PASSWORD
    public static String getPassword() {
        return password;
    }
    
    // GET CURRENT MOOD
    public static String getMood() {
        return mood;
    }
    
    // GET PREFERRED MUSIC GENRES
    public static String[] getPreferredGenres() {
        return preferredGenres;
    }
    
    public static String[] getFavoriteSongs() {
        return favoriteSongs;
    }
}