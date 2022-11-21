package model;

public class Podcast extends Audio{

    private String description;
    private String contentProducer;
    private Category category;
   
    /** Podcast: It is the constructor in charge of storing the podcast, its owner and its other attributes.
    * @param contentProducer: String => He is the content creator who owns a podcast.
    * @param name: String => It is the name that the podcast to register will have.
    * @param description: String => It is the description that the podcast to register will have.
    * @param urlImage: String => It is the url image which will visually identify the podcast.
    * @param category: int => It is the category which will define where the podcast will go.
    * @param timeRep: int => It is the duration that the podcast will have.
    */
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

    public void playAudio() {
        int views=0;
        views++;
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