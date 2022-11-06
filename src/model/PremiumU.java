package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class PremiumU extends Consumer {

    private ArrayList<Shop> songs;
    private ArrayList<Playlist> playlists;

    public PremiumU(int type, String nickname, String id, LocalDate date) {
        super(type, nickname, id, date);

        this.songs = new ArrayList<Shop>();
        this.playlists = new ArrayList<Playlist>();
    }

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

