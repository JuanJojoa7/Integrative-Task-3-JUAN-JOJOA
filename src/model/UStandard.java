package model;

import java.time.LocalDate;

public class UStandard extends Consumer{

    private Shop[] songs;
    private Playlist[] playlists;
    public int MAX_SONGS = 100;
    public int MAX_PLAYLISTS = 20;

    
    /** UPremium: It is the constructor in charge of storing the data of a standard user, its type and information.
    * @param type: int => It is the selected type of consumer, in this case the standard.
    * @param nickname: String => It is the identifier that each standard user receives.
    * @param id: String => It is the ID that each standard user receives.
    * @param date: LocalDate => It is the date that is stamped when a standard user is created.
    */
    public UStandard(int type, String nickname, String id, LocalDate date) {
        super(type, nickname, id, date);

        this.songs = new Shop[MAX_SONGS];
        this.playlists = new Playlist[MAX_PLAYLISTS];

    }

    /** searchPlaylistInArrayList: It is in charge of searching for the apartment object, verifies if it is created and obtains its information.
    * @param name: String => It is the name with which the playlist to be registered is identified.
    * @return playlistFounded: Playlist => Returns the found playlist ready to add audio.
    */
    public Playlist searchPlaylistInArrayList(String name){
        Playlist playlistFounded = null;
        boolean isFound = false;

        for(int i = 0; i < MAX_PLAYLISTS && !isFound; i++){

            if(playlists[i] != null && playlists[i].getName().equalsIgnoreCase(name)){
    
                playlistFounded = playlists[i];
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

        String msgConfirmation = "\nLo sentimos, has alcanzado el limite de playlist.";
        Playlist playlistCreated = new Playlist(name);
        boolean foundSpace = false;

        if(searchPlaylistInArrayList(name) == null){

            for(int i = 0; i < MAX_PLAYLISTS && !foundSpace; i++){

                if(playlists[i] == null){

                    playlists[i] = playlistCreated;
                    foundSpace = true;

                    msgConfirmation = "\nPlaylist agregada correctamente.";
                }
            }
        }else{
            msgConfirmation = "\nProceed.";
        }
        return msgConfirmation;
    }
    
    public Playlist searchPlaylist(String name){

        Playlist playlistFounded = super.searchPlaylist(name);
        boolean isFound = false;

        for(int i = 0; i < MAX_PLAYLISTS && !isFound; i++){

            if(playlists[i] != null && playlists[i].getName().equalsIgnoreCase(name)){

                playlistFounded = playlists[i];
                isFound = true;

            }
        }
        return playlistFounded;
    }
}
