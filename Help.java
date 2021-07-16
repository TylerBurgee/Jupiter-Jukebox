/**
 * @author tylerburgee
 * Class: Help   Filename: Help.java
 * Description: This class displays help and about messages.
 * Improvements: I updated the HelpText String and added relevant information.
 */

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Help {
    public static final int GENERAL = 0;
    public static final int CREATE = 1;
    public static final int LOGIN = 2;
    public static final int UPDATE = 3;
    public static final int JUKEBOX = 4;

    public static void help(int helpContext) {
        String helpText = "";
        String context="Help";
        String title="Help";
        switch (helpContext) {
           case GENERAL:
              helpText = "Creating an account:"
                + "\nIn order to receive and listen to your reccomended list of songs, you must first create an account. "
                + "\nCreating an account will require you to input your first name, last name, password, and 3 preferred music genres.\n\n" 
                + "Logging into your account:"
                + "\nOnce you have created an account, you must login to your account to start listening to music. "
                + "\nThe login process only requires you to input your first name, last name, password, and current mood.\n\n"
                + "Listening to music:"
                + "\nBased on the current mood you selected, and your previously selected music genres, Jupiter's Jukebox will compile a custom list of songs just for you!"
                + "\nThis program gives you the ability to play/pause, skip, rewind, and shuffle your list of songs.\n\n";
              context="General Information";
              break;
           case CREATE:
               helpText = "Creating an account:\nIn order to receive and listen to your reccomended list of songs, you must first create an account.\nCreating an account will require you to input your first name, last name, password, and 3 preferred music genres.";
              context="Creating An Account";
              break;
           case LOGIN:
               helpText = "Logging into your account:\nOnce you have created an account, you must login to your account to start listening to music.\nThe login process only requires you to input your first name, last name, password, and current mood.\n\n";
              context="Logging In To Your Account";
              break;
           case UPDATE:
              context="Updating Music Genre Preferences";
              break;
           case JUKEBOX:
               helpText = "Based on the current mood you selected, and your three previously selected music genres, Jupiter's Jukebox will compile a custom list of songs just for you!\nThis program gives you the ability to play/pause, skip, rewind, and shuffle your list of songs.";
              context="Using Jupiter's Jukebox";
              break;
        }
        
        JOptionPane.showMessageDialog(null, helpText, context, JOptionPane.PLAIN_MESSAGE, 
         new ImageIcon("JupitersJukeboxHelp_Splash.png"));
    }
   
   public static void about() {
      String aboutText = "Jupiter's Jukebox is a music streaming application that will recommend a list of songs to the user, based on their current mood and preferred music genres."
              + "\nThe goal of Jupiter's Jukebox is to provide musicians and songwriters with fresh, innovative music that will inspire their next hit single. "
              + "\nJupiter's Jukebox will primarily recommend indie/underground artists to ensure users will be presented with music that is new to their ears.";
      JOptionPane.showMessageDialog(null, aboutText, "About Jupiter's Jukebox", JOptionPane.PLAIN_MESSAGE, 
         new ImageIcon("JupitersJukebox_Splash.png"));
   }
}