package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class UPremium extends Consumer{

    private ArrayList<Shop> songs;
    private ArrayList<Playlist> playlists;

    /** UPremium: It is the constructor in charge of storing the data of a premium user, its type and information.
    * @param type: int => It is the selected type of consumer, in this case the premium.
    * @param nickname: String => It is the identifier that each premium user receives.
    * @param id: String => It is the ID that each premium user receives.
    * @param date: LocalDate => It is the date that is stamped when a premium user is created.
    */
    public UPremium(int type, String nickname, String id, LocalDate date){
        super(type, nickname, id, date);

        this.songs = new ArrayList<Shop>();
        this.playlists = new ArrayList<Playlist>();
    }

    /** searchPlaylistInArrayList: It is in charge of searching for the apartment object, verifies if it is created and obtains its information.
    * @param name: String => It is the name with which the playlist to be registered is identified.
    * @return playlistFounded: Playlist => Returns the found playlist ready to add audio.
    */
    public Playlist searchPlaylistInArrayList(String name) {
        Playlist playlistFounded = null;
        boolean isFound = false;
        for (int i = 0; i < playlists.size() && !isFound; i++) {
            if (playlists.get(i).gettName().equalsIgnoreCase(name)) {
                playlistFounded = playlists.get(i);
                isFound = true;
            }
        }
        return playlistFounded;
    }
    
    /** addPlayListToArrayList: It is responsible for adding the playlist to the user's playlist array.
    * @param name: String => It is the name with which the playlist will be added to the arraylist.
    * @return msgConfirmation: String => Returns the successful binding message and playlist registration.
    */
    public String addPlaylistToArrayList(String name){
        String msgConfirmation = null;
        Playlist playlist = new Playlist(name);
        if(searchPlaylistInArrayList(name) == null){
            playlists.add(playlist);
            msgConfirmation = "Agregada satisfactoriamente.";
        }else{
            msgConfirmation = "\nProceed.";
        }
        return msgConfirmation;
    }
    
}

