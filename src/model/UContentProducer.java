package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class UContentProducer extends Producer{

    private ArrayList<Podcast> podcasts;

    /** UContentProducer: It is the constructor in charge of storing the data of a content creator, its type and information.
    * @param type: int => It is the selected type of producer, in this case the content producer.
    * @param name: String => It is the name given to the content producer.
    * @param nickname: String => It is the nickname that the content producer receives.
    * @param id: String => It is the ID that the artist receives in his registry.
    * @param urlImage: String => It is the image with which the content producer will identify.
    * @param date: LocalDate => It is the date on which the content producer creation was stamped.
    */
    public UContentProducer(int type, String name, String nickname, String id, String urlImage, LocalDate date) {
        super(type, name ,nickname, id, urlImage, date);

        this.podcasts = new ArrayList<Podcast>();
    }

    /** searchPodcastV2: It is responsible for searching and finding, validating the existence of a podcast in order to add it to the content creator's arraylist.
    * @param name: String => It is the identifier of the podcast to make validations.
    * @return podcastFounded: Podcast => It's the podcast found and ready to be added to the content creator's arraylist.
    */
    public Podcast searchPodcastV2(String name) {
        Podcast podcastFounded = null;
        boolean isFound = false;
        for (int i = 0; i < podcasts.size() && !isFound; i++) {
            if (podcasts.get(i).getName().equalsIgnoreCase(name)) {
                podcastFounded = podcasts.get(i);
                isFound = true;
            }
        }
        return podcastFounded;
    }
    
    public void addPodcastV1(Podcast podcast){
        //This a non functional method, i wanted it to work in the next solution from this Class.
        //The actual addPodcast is the V2.
        //I want to make more validations.
    }

    /** addPodcastV2: It is responsible for adding a podcast to the podcast arraylist that is linked to the content creator.
    * @param audioToAdd: Audio => Is the podcast found and added to the arraylist.
    */
    public void addPodcastV2(Audio audioToAdd){
        Podcast podcastToAdd = (Podcast) audioToAdd;
        podcasts.add(podcastToAdd);
    }
    
}