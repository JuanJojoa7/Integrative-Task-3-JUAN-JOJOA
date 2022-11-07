package model;

public abstract class Audio{

    private String name;
    private String urlImage;
    private int timeRep;
    private int views;

    /** Audio: It is the constructor in charge of storing the songs and podcast and inheriting to the classes song and podcast.
    * @param name: String => This is the name or identifier that the audio types will have.
    * @param urlImage: String => It is the image that will have an audio to differentiate it.
    * @param timeRep: int => It is the time that the audios will have to be played.
    */
    public Audio(String name, String urlImage, int timeRep){
        this.name = name;
        this.urlImage = urlImage;
        this.timeRep = timeRep;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUrlImage(){
        return urlImage;
    }

    public void setUrlImage(String urlImage){
        this.urlImage = urlImage;
    }

    public int getTimeRep(){
        return timeRep;
    }

    public void setTimerep(int timeRep){
        this.timeRep = timeRep;
    }
    
}

