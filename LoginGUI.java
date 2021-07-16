/**
 * @author tylerburgee
 * Class: LoginGUI   Filename: LoginGUI.java
 * Description: This class creates the login window that enables users to login to their account.
 * Improvements: I have added a Help button to the GUI. In addition, I removed extraneous methods from the program.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI extends GUI implements ActionListener{
    
    //FULL CONSTRUCTOR, USING SUPER() TO REPLACE THE DEFAULT PARENT CONSTRUCTOR
    LoginGUI() {
        super("Login GUI");
    }
    
    // CREATE THE LOGIN GUI FRAME
    @Override
    public void createFrame() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login");
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
        
        // MOOD LABEL AND TEXT FIELD
        JLabel moodLabel = new JLabel("Mood:");
        moodLabel.setBounds(365, 100, 80, 30);
        panel.add(moodLabel);
        moodText = new JTextField();
        moodText.setBounds(440, 100, 165, 30);
        panel.add(moodText);
        JLabel moodOptionsLabel = new JLabel("enter one of the following:");
        moodOptionsLabel.setBounds(440, 120, 200, 30);
        panel.add(moodOptionsLabel);
        JLabel moodOptionsLabel2 = new JLabel("happy, sad, angry or fearful");
        moodOptionsLabel2.setBounds(440, 140, 200, 30);
        panel.add(moodOptionsLabel2);
        
        // LOGIN BUTTON
        loginButton = new JButton("Login");
        loginButton.setBounds(285, 400, 80, 30);
        loginButton.addActionListener(new LoginGUI());
        panel.add(loginButton);
        
        // HELP BUTTON
        helpButton = new JButton("Help");
        helpButton.setBounds(550, 425, 80, 30);
        helpButton.addActionListener(new LoginGUI());
        panel.add(helpButton);
        
        frame.setVisible(true);
    }

    // HANDLE BUTTON-CLICKED EVENTS
    @Override
    public void actionPerformed(ActionEvent e) {
        // IF LOGIN BUTTON IS PRESSED, CHECK USER CREDENTIALS AND CREATE MAIN WINDOW.
        if (e.getSource() == loginButton) {
            user = new Person();
            user.loginUser(fNameText.getText(), lNameText.getText(), moodText.getText());
            if (user.getFirstName().equals(fNameText.getText()) && user.getLastName().equals(lNameText.getText()) && user.getPassword().equals(passwordText.getText())) {
                System.out.println("You have successfully logged in!");
                juke = new Jukebox();
                juke.setRecommendedList(user);
                MainGUI main = new MainGUI();
                main.createFrame();
            } 
        // IF HELP BUTTON IS PRESSED, DISPLAY HELP MESSAGE
        } else if (e.getSource() == helpButton) {
            Help.help(2);
        }
    }
}