package model;

public class Song extends Audio{

    private String album;
    private double price;
    private int amountSales;
    private Genre genre;
    private String nickname;

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
