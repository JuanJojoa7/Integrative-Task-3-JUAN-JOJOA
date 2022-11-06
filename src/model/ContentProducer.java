package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContentProducer extends Producer{

    private ArrayList<Podcast> podcasts;

    public ContentProducer(int type, String name, String nickname, String id, String urlImage, LocalDate date) {
        super(type, name ,nickname, id, urlImage, date);

        this.podcasts = new ArrayList<Podcast>();
    }
    
    public void addPodcastV1(Podcast podcast){
        //This a non functional method, i wanted it to work in the next solution from this Class.
        //The actual addPodcast is the V2.
        //I want to make more validations.
    }

    public void addPodcastV2(Audio audio) {
        Podcast podcast = (Podcast) audio;
        podcasts.add(podcast);
    }

    public Podcast searchPodcastV2(String name) {
        Podcast podcast = null;
        boolean found = false;
        for (int i = 0; i < podcasts.size() && !found; i++) {
            if (podcasts.get(i).getName().equalsIgnoreCase(name)) {
                podcast = podcasts.get(i);
                found = true;
            }
        }
        return podcast;
    }
    
}