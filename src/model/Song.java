package model;

public class Song extends Audio{

    private String album;
    private double price;
    private int amountSales;
    private Genre genre;
    private String nickname;

    /** Song: It is the constructor in charge of storing the information of the songs to be able to add them, and it is audio inheritance.
    * @param nickname: String => It is the nickname with which the owner of the song will be identified.
    * @param name: String => It is the name that the song will have.
    * @param album: String => It is the name of the album that will store the song.
    * @param urlImage: String => It is the image that will have the cover that will identify the song.
    * @param timeRep: int => It is the time in seconds that the playback of the song will have.
    * @param price: double => It is the sale price that the song will have to the public.
    * @param genre: int => It is the genre that the song to register will have.
    */
    public Song(String nickname, String name, String album, String urlImage, int timeRep, double price, int genre){
        super(name, urlImage, timeRep);

        this.album = album;
        this.price = price;
        this.nickname = nickname;

        switch(genre){
            case 1:
                this.genre = Genre.ROCK;
                break;
            case 2:
                this.genre = Genre.POP;    
                break;
            case 3:
                this.genre = Genre.TRAP;
                break;
            case 4:
                this.genre = Genre.HOUSE;
                break;      
        }
    }

    public String getSongName(){
        String name = super.getName();
        return name;
    }

    public String getAlbum(){
        return album;
    }

    public void setAlbum(String album){
        this.album = album;
    }

    public String getArtist(){
        return nickname;
    }

    public void setArtist(String nickname){
        this.nickname = nickname;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getAmountsales(){
        return amountSales;
    }

    public void setAmountsales(int amountSales){
        this.amountSales = amountSales;
    }
}
