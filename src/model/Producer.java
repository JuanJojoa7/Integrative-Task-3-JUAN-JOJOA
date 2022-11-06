package model;

import java.time.LocalDate;

public class Producer extends User{

    private String name;
    private String urlImage;
    private int views;
    private int timeRep;

    public Producer(int type, String name, String nickname, String id, String urlImage, LocalDate date){
        super(nickname, id, date);
        this.name = name;
        this.urlImage = urlImage;
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
}

