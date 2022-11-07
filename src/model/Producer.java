package model;

import java.time.LocalDate;

public class Producer extends User{

    private String name;
    private String urlImage;
    private int views;
    private int timeRep;

    /** Producer: It is the constructor in charge of storing the information of a producer, its attributes and giving inheritance to the types of producers.
    * @param type: int => Is the type of producer to be added to the system.
    * @param name: String => It is the name that the producer will have.
    * @param nickname: String => It is the nickname that the producer will have.
    * @param id: String => It is the id with which the producer is identified.
    * @param urlImage: String => It is the image that will identify the producer.
    * @param date: LocalDate => It is the date with which the record of the producer is stamped.
    */
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

