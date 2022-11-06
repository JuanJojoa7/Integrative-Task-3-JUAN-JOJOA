package model;

public abstract class Audio{

    private String name;
    private String urlImage;
    private int timeRep;
    private int views;

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

