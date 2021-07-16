/**
 * @author tylerburgee
 * Class: SignupGUI   Filename: SignupGUI.java
 * Description: This class creates the sign-up window that enables users to sign-in to their account.
 * Improvements: I have added a Help button to the GUI.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignupGUI extends GUI implements ActionListener{
    
    //FULL CONSTRUCTOR, USING SUPER() TO REPLACE THE DEFAULT PARENT CONSTRUCTOR
    SignupGUI() {
        super("Sign-up GUI");
    }

    // CREATE THE SIGN-UP GUI FRAME
    @Override
    public void createFrame() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Sign-up");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        panel.setLayout(null);
        
        // FIRST NAME LABEL AND TEXT FIELD
        JLabel fNameLabel = new JLabel("First Name:");
        fNameLabel.setBounds(40, 20, 80, 30);
        panel.add(fNameLabel);
        fNameText = new JTextField();
        fNameText.setBounds(125, 20, 165, 30);
        panel.add(fNameText);
        
        // LAST NAME LABEL AND TEXT FIELD
        JLabel lNameLabel = new JLabel("Last Name:");
        lNameLabel.setBounds(365, 20, 80, 30);
        panel.add(lNameLabel);
        lNameText = new JTextField();
        lNameText.setBounds(440, 20, 165, 30);
        panel.add(lNameText);
        
        // PASSWORD LABEL AND TEXT FIELD
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 100, 80, 30);
        panel.add(passwordLabel);
        passwordText = new JPasswordField();
        passwordText.setBounds(125, 100, 165, 30);
        panel.add(passwordText);
        
        // PREFERRED GENRES LABEL AND TEXT FIELD
        JLabel genresLabel = new JLabel("Enter your preferred genres:");
        genresLabel.setBounds(150, 180, 200, 30);
        panel.add(genresLabel);
        genresText = new JTextField();
        genresText.setBounds(325, 180, 165, 30);
        panel.add(genresText);
        
        // GENRES EXAMPLES LABELS
        JLabel genreOptionsLabel = new JLabel("List of genres to choose from");
        genreOptionsLabel.setBounds(225, 220, 500, 30);
        panel.add(genreOptionsLabel);
        JLabel genreOptionsLabel3 = new JLabel("(Select three genres and enter a space between each genre):");
        genreOptionsLabel3.setBounds(150, 240, 500, 30);
        panel.add(genreOptionsLabel3);
        JLabel genreOptionsLabel2 = new JLabel("rock, pop, hiphop, country, rb, blues, alternative, folk");
        genreOptionsLabel2.setBounds(165, 280, 350, 30);
        panel.add(genreOptionsLabel2);
        
        // SIGN-UP BUTTON
        signupButton = new JButton("Sign-up");
        signupButton.setBounds(285, 400, 80, 30);
        signupButton.addActionListener(new SignupGUI());
        panel.add(signupButton);
        
        // HELP BUTTON
        helpButton = new JButton("Help");
        helpButton.setBounds(550, 425, 80, 30);
        helpButton.addActionListener(new SignupGUI());
        panel.add(helpButton);
        
        frame.setVisible(true);
    }

    // HANDLE BUTTON-CLICKED EVENTS
    @Override
    public void actionPerformed(ActionEvent e) {
        // IF SIGN-UP BUTTON IS PRESSED, CREATE LOGIN WINDOW
        if (e.getSource() == signupButton) {
            Person user = new Person();
            String[] strGenres = genresText.getText().split(" ");
            user.createUser(fNameText.getText(), lNameText.getText(), passwordText.getText(), strGenres);
            System.out.println("You have successfully logged in!");
            LoginGUI login = new LoginGUI();
            login.createFrame();
        
        // IF HELP BUTTON IS PRESSED, DISPLAY HELP MESSAGE
        } else if (e.getSource() == helpButton) {
            Help.help(1);
        }
    }
}