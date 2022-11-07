package model;
import java.time.LocalDate;

public abstract class User{
    
    private String nickname;
    private String id;
    private LocalDate date;
    
    public User(String nickname, String id, LocalDate date){
        this.nickname = nickname;
        this.id = id;
        this.date = LocalDate.now();
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getId(){
        return id;
    }

    public void setIdnum(String id){
        this.id = id;
    }
}
