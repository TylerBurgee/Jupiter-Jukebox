/**
 * @author tylerburgee
 * Class: MainGUI   Filename: MainGUI.java
 * Description: This class creates the main program window that enables users to see and interact with their list of recommended songs. 
 * This class will enable users to play, pause, and skip, their music.
 * Improvements: I have added Shuffle and Favorite capabilities to this GUI.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class MainGUI extends GUI implements ActionListener{
    // DECLARE PRIVATE VARIABLES
    private static final String[] strList = juke.getSongList();
    public static int i = 0;
    public static String[] currentSongList;
    
    // FULL CONSTRUCTOR, USING SUPER() TO REPLACE THE DEFAULT PARENT CONSTRUCTOR
    MainGUI() {
        super("Main GUI");
        currentSongList = strList;
    }
    
    // CREATE THE MAIN GUI FRAME
    @Override
    public  void createFrame() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Jupiter's Jukebox");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        panel.setLayout(null);
        
        // YOUR SONG LIST LABEL
        JLabel yourSongsLabel = new JLabel("Your Song List:");
        yourSongsLabel.setBounds(280, 20, 200, 30);
        panel.add(yourSongsLabel);
      
        // LABELS THAT SHOW THE LIST OF RECOMMENDED SONGS
        songsLabel = new JLabel("1." + strList[0]);
        songsLabel.setBounds(100, 80, 275, 30);
        panel.add(songsLabel);
        songsLabel2 = new JLabel("2." + strList[1]);
        songsLabel2.setBounds(100, 100, 275, 30);
        panel.add(songsLabel2);
        songsLabel3 = new JLabel("3." + strList[2]);
        songsLabel3.setBounds(100, 120, 275, 30);
        panel.add(songsLabel3);
        songsLabel4 = new JLabel("4." + strList[3]);
        songsLabel4.setBounds(350, 80, 275, 30);
        panel.add(songsLabel4);
        songsLabel5 = new JLabel("5." + strList[4]);
        songsLabel5.setBounds(350, 100, 275, 30);
        panel.add(songsLabel5);
        songsLabel6 = new JLabel("6." + strList[5]);
        songsLabel6.setBounds(350, 120, 275, 30);
        panel.add(songsLabel6);
        
        // NOW PLAYING LABEL
        nowPlayingLabel = new JLabel("Now Playing:");
        nowPlayingLabel.setBounds(225, 250, 400, 30);
        panel.add(nowPlayingLabel);
        
        // MUSIC CONTROL BUTTONS
        rewindButton = new JButton("Rewind");
        rewindButton.setBounds(75, 400, 80, 30);
        rewindButton.addActionListener(new MainGUI());
        panel.add(rewindButton);
        playButton = new JButton("Play");
        playButton.setBounds(150, 400, 80, 30);
        playButton.addActionListener(new MainGUI());
        panel.add(playButton);
        stopButton = new JButton("Stop");
        stopButton.setBounds(225, 400, 80, 30);
        stopButton.addActionListener(new MainGUI());
        panel.add(stopButton);
        skipButton = new JButton("Skip");
        skipButton.setBounds(300, 400, 80, 30);
        skipButton.addActionListener(new MainGUI());
        panel.add(skipButton);
        shuffleButton = new JButton("Shuffle");
        shuffleButton.setBounds(375, 400, 80, 30);
        shuffleButton.addActionListener(new MainGUI());
        panel.add(shuffleButton);
        favoriteButton = new JButton("Like");
        favoriteButton.setBounds(450, 400, 80, 30);
        favoriteButton.addActionListener(new MainGUI());
        panel.add(favoriteButton);
        frame.setVisible(true);
        
        // YOUR PLAYLISTS LABEL
        JLabel playlistsLabel = new JLabel("Your Playlists:");
        playlistsLabel.setBounds(75, 325, 100, 30);
        panel.add(playlistsLabel);
        
        // PLAY FAVORITE PLAYLIST BUTTON
        favoritePlaylistButton = new JButton("Songs You've Liked");
        favoritePlaylistButton.setBounds(175, 325, 150, 30);
        favoritePlaylistButton.addActionListener(new MainGUI());
        panel.add(favoritePlaylistButton);
        frame.setVisible(true);
        
        // PLAY RECOMMENDED PLAYLIST BUTTON
        recommendedPlaylistButton = new JButton("Recommended Song List");
        recommendedPlaylistButton.setBounds(335, 325, 200, 30);
        recommendedPlaylistButton.addActionListener(new MainGUI());
        panel.add(recommendedPlaylistButton);
        frame.setVisible(true);
    }
    
    // DISPLAY THE LIST OF RECOMMENDED SONGS
    public static void displaySongList(String[] songList) {
        songsLabel.setText("1." + songList[0]);
        songsLabel2.setText("2." + songList[1]);
        songsLabel3.setText("3." + songList[2]);
        songsLabel4.setText("4." + songList[3]);
        songsLabel5.setText("5." + songList[4]);
        songsLabel6.setText("6." + songList[5]);
    }
    
    public static void displayFavSongs(String[] songList) {
        songsLabel.setText("1." + songList[0]);
        songsLabel2.setText("2." + songList[1]);
        songsLabel3.setText("3.");
        songsLabel4.setText("4.");
        songsLabel5.setText("5.");
        songsLabel6.setText("6.");
    }
    
    // PLAY CURRENTLY SELECTED SONG
    public static void playSong(Jukebox juke, String[] songList) {
        if (i < 6 && i >= 0) {
            juke.play("/Users/tylerburgee/Documents/JupitersJukebox/Music/" + songList[i].replaceAll("\\s+","") + ".wav");
            nowPlayingLabel.setText("Now Playing: " + songList[i]);
        } else if (i == 6) {
            i = 0;
            juke.play("/Users/tylerburgee/Documents/JupitersJukebox/Music/" + songList[i].replaceAll("\\s+","") + ".wav");
            nowPlayingLabel.setText("Now Playing: " + songList[i]);
        } else if (i == -1) {
            i = 5;
            juke.play("/Users/tylerburgee/Documents/JupitersJukebox/Music/" + songList[i].replaceAll("\\s+","") + ".wav");
            nowPlayingLabel.setText("Now Playing: " + songList[i]);
        }
    }

    // HANDLE BUTTON-CLICKED EVENTS
    @Override
    public void actionPerformed(ActionEvent e) {
        // IF PLAY BUTTON IS PRESSED, PLAY THE SELECTED SONG
        if (e.getSource() == playButton) {
            playSong(juke, currentSongList);
            
        // IF STOP BUTTON IS PRESSED, TERMINATE THE CURRENTLY PLAYING SONG
        } else if (e.getSource() == stopButton) {
            juke.stop();
            
        // IF SKIP BUTTON IS PRESSED, INCREMENT SONG SELECTION VARIABLE
        } else if (e.getSource() == skipButton) {
            juke.stop();
            i++;
            playSong(juke, currentSongList);
            
        // IF REWIND BUTTON IS PRESSED, DECREMENT SONG SELECTION VARIABLE
        } else if (e.getSource() == rewindButton) {
            juke.stop();
            i--;
            playSong(juke, currentSongList);
            
        // IF SHUFFLE BUTTON IS PRESSED, SHUFFLE SONG LIST
        } else if (e.getSource() == shuffleButton) {
            juke.shuffleArray(currentSongList);
            
        // IF FAVORITE BUTTON IS PRESSED, SAVE SONG TO USER .TXT FILE
        } else if (e.getSource() == favoriteButton) {
            user.saveFavoriteSong(strList[i]);
            JOptionPane.showMessageDialog(null, strList[i] + "has been saved to your playlist of liked songs.", "Song Saved Successfully", JOptionPane.PLAIN_MESSAGE, 
         new ImageIcon("JupitersJukebox_Splash.png"));
            
        // IF FAVORITE PLAYLIST BUTTON IS PRESSED, LOAD FAVORITE SONGS AND UPDATE SONG LIST
        } else if (e.getSource() == favoritePlaylistButton) {
            String[] favList = {"Riding With The King", "Mr Blue Sky"};
            currentSongList = favList;
            displayFavSongs(currentSongList);
            i = 0;
            
        // IF RECOMMENDED PLAYLIST BUTTON IS PRESSED, LOAD RECOMMENDED SONGS AND UPDATE SONG LIST
        } else if (e.getSource() == recommendedPlaylistButton) {
            currentSongList = strList;
            displaySongList(currentSongList);
            i = 0;
        }
    }
}