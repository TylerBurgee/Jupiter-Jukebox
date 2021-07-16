/**
 * @author tylerburgee
 * Class: GUI   Filename: GUI.java
 * Description: This is the parent class for the access, login, and sign-up GUIs.
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI {  
    // TEXT FIELDS
    public static JTextField fNameText;
    public static JTextField lNameText;
    public static JPasswordField passwordText;
    public static JTextField moodText;
    public static JButton loginButton;
    public static JTextField genresText;
    
    // BUTTONS
    public static JButton loginOptionButton;
    public static JButton signupOptionButton;
    public static JButton signupButton;
    public static JButton playButton; 
    public static JButton skipButton; 
    public static JButton stopButton; 
    public static JButton rewindButton; 
    public static JButton helpButton; 
    public static JButton aboutButton; 
    public static JButton shuffleButton;
    public static JButton favoriteButton;
    public static JButton favoritePlaylistButton;
    public static JButton recommendedPlaylistButton;
    
    // LABELS
    public static JLabel nowPlayingLabel;
    public static JLabel songsLabel;
    public static JLabel songsLabel2;
    public static JLabel songsLabel3;
    public static JLabel songsLabel4;
    public static JLabel songsLabel5;
    public static JLabel songsLabel6;
    
    // JFRAME AND JPANEL
    public static JPanel panel;
    public static JFrame frame;
    
    // PERSON AND JUKEBOX OBJECTS
    public static Person user;
    public static Jukebox juke;
    
    private static String windowName;
    
    //FULL CONSTRUCTOR
    GUI(String windowName) {
        this.windowName = "GUI";
    }
    
    // CREATE A FRAME
    public void createFrame() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login or Sign-up");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    }
}
