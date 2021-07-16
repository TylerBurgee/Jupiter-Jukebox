/**
 * @author tylerburgee
 * Class: AccessGUI   Filename: LoginGUI.java
 * Description: This class creates the access window that gives users the ability to either login or sign-up.
 * Improvements: I have added About and Help buttons to the GUI.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccessGUI extends GUI implements ActionListener{

    //FULL CONSTRUCTOR, USING SUPER() TO REPLACE THE DEFAULT PARENT CONSTRUCTOR
    AccessGUI() {
        super("Access GUI");
    }
    
    @Override
    // CREATE THE ACCESS GUI FRAME
    public void createFrame() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login or Sign-up");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        frame.getContentPane().setBackground( Color.red );
        
        panel.setLayout(null);
        
        // WELCOME LABEL
        JLabel welcomeLabel = new JLabel("Welcome to Jupiter's Jukebox!");
        welcomeLabel.setBounds(100, 20, 500, 45);
        welcomeLabel.setFont(welcomeLabel.getFont().deriveFont (32.0f));
        panel.add(welcomeLabel);
        
        // RETURNING USER LABEL
        JLabel returningUserLabel = new JLabel("Returning user?");
        returningUserLabel.setBounds(280, 100, 150, 30);
        panel.add(returningUserLabel);
        
        // LOGIN BUTTON
        loginOptionButton = new JButton("Login");
        loginOptionButton.setBounds(285, 120, 80, 30);
        loginOptionButton.addActionListener(new AccessGUI());
        panel.add(loginOptionButton);
        
        // NEW USER LABEL
        JLabel newUserLabel = new JLabel("New user?");
        newUserLabel.setBounds(295, 200, 80, 30);
        panel.add(newUserLabel);
        
        // SIGN-UP BUTTON
        signupOptionButton = new JButton("Sign-up");
        signupOptionButton.setBounds(285, 220, 80, 30);
        signupOptionButton.addActionListener(new AccessGUI());
        panel.add(signupOptionButton);
        
        // HELP BUTTON
        helpButton = new JButton("Help");
        helpButton.setBounds(550, 425, 80, 30);
        helpButton.addActionListener(new AccessGUI());
        panel.add(helpButton);
        
        // ABOUT BUTTON
        aboutButton = new JButton("About");
        aboutButton.setBounds(15, 425, 80, 30);
        aboutButton.addActionListener(new AccessGUI());
        panel.add(aboutButton);
        
        frame.setVisible(true);
    }

    // HANDLE BUTTON-CLICKED EVENTS
    @Override
    public void actionPerformed(ActionEvent e) {
        // IF LOGIN BUTTON IS PRESSED, CREATE LOGIN WINDOW
        if(e.getSource() == loginOptionButton) {
            LoginGUI login = new LoginGUI();
            login.createFrame();
            
        // IF SIGN-UP BUTTON IS PRESSED, CREATE SIGN-UP WINDOW
        } else if (e.getSource() == signupOptionButton) {
            SignupGUI signup = new SignupGUI();
            signup.createFrame();
            
        // IF HELP BUTTON IS PRESSED, DISPLAY HELP MESSAGE
        } else if (e.getSource() == helpButton) {
            Help.help(0);
            
        // IF ABOUT BUTTON IS PRESSED, DISPLAY ABOUT MESSAGE
        } else if (e.getSource() == aboutButton) {
            Help.about();
        } 
    }    
}