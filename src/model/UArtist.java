package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class UArtist extends Producer{

    private ArrayList<Song> songs;

    /** UArtist: It is the constructor in charge of storing the information of the artist and his registered songs.
    * @param type: int => It is the selected type of producer, in this case the artist.
    * @param name: String => It is the name given to the artist.
    * @param nickname: String => It is the nickname that the artist receives.
    * @param id: String => It is the ID that the artist receives in his registry.
    * @param urlImage: String => It is the image with which the artist will identify.
    * @param date: LocalDate => It is the date on which the artist's creation was stamped.
    */
    public UArtist(int type, String name, String nickname, String id, String urlImage, LocalDate date) {
        super(type, name, nickname, id, urlImage, date);
        this.songs = new ArrayList<Song>();

    }

    /** searchSongInArrayList: It is responsible for searching the songs in the arrayList to validate their existence and creation.
    * @param name: String => It is the name with which the songs are identified and with which they will be validated.
    * @return songFounded: Song => Returns the song found in the song array in order to add it to the artist's arraylist.
    */
    public Song searchSongInArrayList(String name){

        Song songFounded = null;
        boolean isFound = false;

        for(int i = 0; i < songs.size() && !isFound; i++){

            if(songs.get(i).getName().equalsIgnoreCase(name)){

                songFounded = songs.get(i);
                isFound = true;
                
            }
        }
        return songFounded;
    }

    /** addSongInArrayList: It is responsible for adding songs to the arrangement of the owner in this case the artist.
    * @param audioToAdd: Audio => It is the audio found and added to the song arraylist.
    */
    public void addSongInArrayList(Audio audioToAdd){
        Song songToAdd = (Song) audioToAdd;
        songs.add(songToAdd);
    }

    public String getArtistName(){
        String name = super.getName();
        return name;
    }

    
}

