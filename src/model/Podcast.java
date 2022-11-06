package model;

public class Podcast extends Audio{

    private String description;
    private String contentProducer;
    private Category category;
   
    public Podcast(String contentProducer, String name, String description, String urlImage, int category, int timeRep){
        super(name, urlImage, timeRep);

        this.description = description;
        this.contentProducer = contentProducer;

        switch(category){
            case 1:
                this.category = Category.POLITIC;
                break;
            case 2:
                this.category = Category.ENTERTAINMENT;    
                break;
            case 3:
                this.category = Category.VIDEOGAME;
                break;
            case 4:
                this.category = Category.FASHION;
                break;      
        }

    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getContentproducer(){
        return contentProducer;
    }

    public void setContentProducer(String contentProducer){
        this.contentProducer = contentProducer;
    }
}