package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Artist extends Producer{

    private ArrayList<Song> songs;

    public Artist(int type, String name, String nickname, String id, String urlImage, LocalDate date) {
        super(type, name, nickname, id, urlImage, date);
        this.songs = new ArrayList<Song>();

    }

    public void addSongInArrayList(Audio audio){
        Song song = (Song) audio;
        songs.add(song);
    }

    public String getArtistName(){
        String name = super.getName();
        return name;
    }

    public Song searchSongInArrayList(String name) {
        Song song = null;
        boolean found = false;
        for (int i = 0; i < songs.size() && !found; i++) {
            if (songs.get(i).getName().equalsIgnoreCase(name)) {
                song = songs.get(i);
                found = true;
            }
        }
        return song;
    }
}

