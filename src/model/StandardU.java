package model;

import java.time.LocalDate;

public class StandardU extends Consumer {

    private Shop[] songs;
    private Playlist[] playlists;
    public int LIMIT_SONGS = 100;
    public int LIMIT_PLAYLISTS = 20;

    public StandardU(int type, String nickname, String id, LocalDate date) {
        super(type, nickname, id, date);

        this.songs = new Shop[LIMIT_SONGS];
        this.playlists = new Playlist[LIMIT_PLAYLISTS];

    }

    public Playlist searchPlaylistInArrayList(String name) {
        Playlist playlistFounded = null;
        boolean isFound = false;
        for (int i = 0; i < LIMIT_PLAYLISTS && !isFound; i++) {
            if (playlists[i] != null && playlists[i].gettName().equalsIgnoreCase(name)) {
                playlistFounded = playlists[i];
                isFound = true;
            }
        }
        return playlistFounded;
    }

    public String addPlaylistToArrayList(String name){
        String msgConfirmation = "\nLo sentimos, has alcanzado el limite de playlist.";
        Playlist playlistCreated = new Playlist(name);
        boolean foundSpace = false;
        if(searchPlaylistInArrayList(name) == null){
            for(int i = 0; i < LIMIT_PLAYLISTS && !foundSpace; i++){
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
    
}
