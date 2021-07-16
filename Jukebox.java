/**
 * @author tylerburgee
 * Class: Jukebox   Filename: Jukebox.java
 * Description: This class is responsible for initializing and playing the list of songs.
 * Improvements: I created shuffle and swap methods that shuffle the user's song list. The setRecommendedList method has been improved and refined; the code is far more concise than it used to be.
 */
import java.io.*;
import java.util.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Jukebox implements LineListener{
    // DECLARE PRIVATE VARIABLES
    private static final ArrayList<String> recommendedSongs = new ArrayList<String>();
    private static final String[] songList = new String[6];
    private static final String[] genreList = {"rock", "pop", "hiphop", "country", "rb", "blues", "alternative", "folk"};
    private static int genreListCounter = 0;
    
    private static String[][] happySongs;
    private static String[][] sadSongs;
    private static String[][] angrySongs;
    private static String[][] fearfulSongs;
    
    private static Clip audioClip;
    boolean playCompleted = true;

    // DEFAULT CONSTRUCTOR
    public Jukebox() {
        // INITIALIZE THE LIST OF SONGS FOR EACH MOOD
        // NOTE: THESE SONGS ARE FOR TESTING PURPOSES ONLY. THE OFFICIAL SONG LISTS WILL CONTAIN MUSIC FROM INDIE/UNDERGROUND ARTISTS.
        this.happySongs = new String[][] {
            { "rock", "Don't Stop Me Now ", "Livin On A Prayer " },
            { "pop", "Staring At The Sun ", "Fireflies " },
            { "hiphop", "Wow ", "Up Up And Away " },
            { "country", "Chicken Fried ", "Days Go By " },
            { "rb", "The Way You Make Me Feel ", "Uptown Funk " },
            { "blues", "Change The World ", "Riding With The King " },
            { "alternative", "Smells Like Teen Spirit ", "Mr Blue Sky " },
            { "folk", "The 59th Bridge Street Song ", "You've Got A Friend "}
        };
        this.sadSongs = new String[][] {
            { "rock", "November Rain ", "Faithfully " },
            { "pop", "Someone Like You ", "When I Was Your Man " },
            { "hiphop", "Jocelyn Flores ", "Praying To The Sky " },
            { "country", "What Hurts the Most ", "If I Die Young " },
            { "rb", "Wicked Games ", "Marvins Room " },
            { "blues", "Yer Blues ", "Woke Up This Morning " },
            { "alternative", "Leave the City ", "Fallingforyou " },
            { "folk", "The Lonesome Death of Hattie Carroll ", "Richard Cory "}
        };
        this.angrySongs = new String[][] {
            { "rock", "Lithium ", "Thunderstruck " },
            { "pop", "Weightless ", "Nine In The Afternoon " },
            { "hiphop", "CONFUSED! ", "All Girls Are the Same " },
            { "country", "Gunpowder & Lead ", "Before He Cheats " },
            { "rb", "4th Dimension ", "Heartless " },
            { "blues", "How Do You Sleep? ", "Angry Blues " },
            { "alternative", "One Minute ", "Papercut " },
            { "folk", "Idiot Wind ", "House Of The Rising Sun "}
        };
        this.fearfulSongs = new String[][] {
            { "rock", "Just Keep Breathing ", "Friends Will Be Friends " },
            { "pop", "No Place In Heaven ", "In My Blood " },
            { "hiphop", "Righteous ", "Hold On We're Going Home " },
            { "country", "Take It Easy ", "Live Like You Were Dying " },
            { "rb", "You Are Not Alone ", "Lately " },
            { "blues", "Running On Faith ", "The Wind Cries Mary " },
            { "alternative", "Basket Case ", "Before I Close My Eyes " },
            { "folk", "Blackbird ", "The Meeting Of The Waters "}
        };
    }
    
    // PLAY THE CURRENTLY SELECTED SONG
    public void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
 
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
 
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            audioClip.start();
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }
    
    // PAUSE THE CURRENTLY SELECTED SONG
    public void stop() {
        //playCompleted = true;
        audioClip.stop();
    }

    // ADD SONGS TO recommendedSongs
    public static void addToRecommendedList(Person user, String[][] moodSongList, String genre) {
        for (int g = 0; g < user.getPreferredGenres().length; g++) {
            if (genre.equals(user.getPreferredGenres()[g])) {
                for (int row = 0; row < moodSongList.length; row++) { // ITERATE THROUGH SAD SONGS LIST TO FIND SONGS OF THE USER'S PREFERRED GENRES.
                    for (int col = 0; col < moodSongList[row].length; col++) {
                        if (recommendedSongs.contains(moodSongList[row][col])) { // IF RECOMMENDED SONGS LIST ALREADY CONTAINS THE SONG, BREAK.
                            break;
                        } else if (moodSongList[row][0].equals(genre)) {
                            recommendedSongs.add(moodSongList[row][col]); // ADD SONGS TO RECOMMENDED SONGS LIST.
                        } 
                    }
                }
            } 
        }
    }
    
    // SET THE LIST OF RECOMMENDED SONGS
    public static void setRecommendedList(Person user) {
        for (int i = 0; i < songList.length; i++) { 
            switch(user.getMood()) {
                case "happy":
                    for (int j = 0; j < genreList.length; j++) {
                    addToRecommendedList(user, happySongs, genreList[j]);
                }
                case "sad":
                    for (int j = 0; j < genreList.length; j++) {
                    addToRecommendedList(user, sadSongs, genreList[j]);
                }
                case "angry":
                    for (int j = 0; j < genreList.length; j++) {
                    addToRecommendedList(user, angrySongs, genreList[j]);
                }
                case "fearful":
                    for (int j = 0; j < genreList.length; j++) {
                    addToRecommendedList(user, fearfulSongs, genreList[j]);
                }
            }
        }
        for (int i = 0; i < recommendedSongs.size(); i++) {
            for (int j = 0; j < user.getPreferredGenres().length; j++) {
                if (recommendedSongs.get(i).contains(user.getPreferredGenres()[j])) {
                    recommendedSongs.remove(i);
                }
            }
            songList[i] = recommendedSongs.get(i);
        }
    }
    
    // SHUFFLE THE LIST OF RECOMMENDED SONGS
    public static void shuffleArray(String[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
        MainGUI.i = 0;
        MainGUI.displaySongList(MainGUI.currentSongList);
    }

    // SWAP ELEMENTS IN THE RECOMMENDED SONGS ARRAY
    private static void swap(String[] a, int i, int change) {
        String helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }
    
    // GET THE LIST OF RECOMMENDED SONGS
    public static String[] getSongList() {
        return songList;
    }
    
    // TO STRING METHOD
    public String toString() {
        return "";
    } 
    
    // HANDLE BUTTON-CLICKED EVENTS
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
    }
}