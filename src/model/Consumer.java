package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Consumer extends User{

    private int podcastTimeRep;
    private Category podcastMostListenedCategory;
    private String podcastMostListenedCreator;
    private int songTimeRep;
    private Genre songMostListenedGenre;
    private String songMostListenedArtist;

    private ArrayList<String> listenedSongs;
    private ArrayList<Integer> numListSongs; 
 
    /** Consumer: It is the constructor of a consumer in the system that houses its types, and the inherited, standard and premium classes.
    * @param type: int => This is the type of consumers in the system.
    * @param nickname: String => It is the name identifier with which consumers will identify themselves.
    * @param id: String => It is the ID identifier that each consumer has.
    * @param date: LocalDate => This is the exact time at which the consumer's record will be stamped.
    */
    public Consumer(int type, String nickname, String id, LocalDate date){
        super(nickname, id, date);
    }

    public Playlist searchPlaylist(String name){
        Playlist playlist = null;
        return playlist;
    }

    public String addPlaylist(String name){

        boolean isFound = false;
        String msgConfirmation = "\nSe ha agregado la playlist satisfactoriamente.";

        if(isFound == true){

            msgConfirmation = "Lo sentimos, ha alcanzado el limite";
            
        }
        return msgConfirmation;
    }

    
 }
 