package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Consumer extends User{

    //In this section you will define at once all the arraylist that I believe pertinent for the development of the other requirements.

    private int podcastTimeRep;
    private Category podcastMostListenedCategory;
    private String podcastMostListenedCreator;
    private int songTimeRep;
    private Genre songMostListenedGenre;
    private String songMostListenedArtist;

    private ArrayList<String> listenedSongs;
    private ArrayList<Integer> numListSongs; 
 
    public Consumer(int type, String nickname, String id, LocalDate date){
        super(nickname, id, date);
    }

    public void updateStats(){
        //Working in this method.
        //The function of this method is too update the stats of a Consumer, playlist, songs and podcast.
    }

    public String createPlaylistV1(String name, ArrayList audios){
        //This is a non functional method, the first version of create Playlist, in the next solution of the integrative task 3 i want to make it
        //functional from this class "Consumer."
        return null;
    }

    public String buySong(String song){
        return song;
    }
 }
 