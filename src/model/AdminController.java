package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdminController{

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    
    public AdminController(){
        this.users = new ArrayList<User>();
        this.audios = new ArrayList<Audio>();
    }

    public User searchUser(String nickname){
        boolean isFound = false;
        User user = null;

        for(int i=0; i < users.size() && !isFound; i++){
            if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                user = users.get(i);
                isFound = true;
            }
        }
        return user;
    }

    public User searchUserID(String id){
        boolean isFound = false;
        User user = null;

        for(int i=0; i < users.size() && !isFound; i++){
            if(users.get(i).getId().equalsIgnoreCase(id)){
                user = users.get(i);
                isFound = true;
            }
        }
        return user;
    }

    public String addUserStandard(int type, String nickname, String id){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new StandardU(type, nickname, id, date));
        msgConfirmation = "\nSe ha agregado el usuario estandar correctamente.";
        return msgConfirmation;
    }

    public String addUserPremium(int type, String nickname, String id){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new PremiumU(type, nickname, id, date));
        msgConfirmation = "\nSe ha agregado el usuario premium correctamente.";
        return msgConfirmation;
    }

    public String addUserArtist(int type, String name, String nickname, String id, String urlImage){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new Artist(type, name, nickname, id, urlImage, date));
        msgConfirmation = "\nSe ha agregado el Artista correctamente.";
        return msgConfirmation;
    }

    public String addUserContentProducer(int type, String name, String nickname, String id, String urlImage){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new ContentProducer(type, name, nickname, id, urlImage, date));
        msgConfirmation = "\nSe ha agregado el Creador de contenido correctamente.";
        return msgConfirmation;
    }

    public String addSongToArrayList(String nickname, String name, String album, String urlImage, int timeRep, double price, int genre){
        LocalDate date = LocalDate.now();
        String msgConfirmation = null;
        boolean isFound = false;
        if(searchUser(nickname) == null && searchUser(nickname) instanceof ContentProducer){
            msgConfirmation = "\nLo sentimos, el artista no fue encontrado.";
        }else{
            Audio song = new Song(nickname, name, album, urlImage, timeRep, price, genre);
            for(int i = 0; i < users.size() && !isFound; i++) {
                if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                    Artist user = (Artist) users.get(i);
                    if(user.searchSongInArrayList(name) == null){
                        user.addSongInArrayList(song);
                        users.remove(users.get(i));
                        users.add(user);
                        isFound = true;
                        msgConfirmation = "\nCancion agregada correctamente.";
                    }else{
                        msgConfirmation = "\nLo sentimos, este artista ya tiene esa cancion registrada.";
                    }
                }
            }
        }
        return msgConfirmation;
    }

    public String addPodcastToArrayList(String contentProducer, String name, String description, String urlImage, int category, int timeRep){
        LocalDate date = LocalDate.now();
        String msgConfirmation = null;
        boolean isFound = false;
        if(searchUser(contentProducer) == null && searchUser(contentProducer) instanceof Artist){
            msgConfirmation = "\nLo sentimos, ese creador de contenido no se encuentra registrado.";
        }else{
            Audio podcast = new Podcast(contentProducer, name, description, urlImage, category, timeRep);
            for(int i = 0; i < users.size() && !isFound; i++){
                if(users.get(i).getNickname().equalsIgnoreCase(contentProducer)){
                    ContentProducer user = (ContentProducer) users.get(i);
                    if(user.searchPodcastV2(name) == null){
                        user.addPodcastV2(podcast);
                        users.remove(users.get(i));
                        users.add(user);
                        isFound = true;
                        msgConfirmation = "\nPodcast agregado correctamente.";
                    }else{
                        msgConfirmation = "\nLo sentimos, este creador de contenido ya tiene ese podcast en su lista.";
                    }
                }
            }
        }
        return msgConfirmation;
    }

    public String addPlaylistToStandardU(String name, String nickname){
        LocalDate date = LocalDate.now();
        String msgConfirmation = "\nPlaylist creada correctamente.";
        boolean isFound = false;
        if(searchUser(nickname)!= null){
            for(int i = 0; i < users.size() && !isFound; i++){
                if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                    }else{
                        if(users.get(i) instanceof StandardU){
                            StandardU consumer = (StandardU) users.get(i);
                            String operationResult = consumer.addPlaylistToArrayList(name);
                            if(operationResult.equalsIgnoreCase("Proceed.")){
                                msgConfirmation = "Error. This user has a playlist with the same name.";
                            }else if (operationResult.equalsIgnoreCase("\nLo sentimos, has alcanzado el limite de playlist de cuentas estandar, actualizate a premium.")){
                                msgConfirmation = "Error. Limit reached for this user.";
                            } else {
                                users.remove(i);
                                users.add(consumer);
                        }
                    }
                }
            }
        }else{
            msgConfirmation = "\nLo sentimos, el usuario que intenta crear la playlist no se encuentra en el sistema.";
        }
        return msgConfirmation;
    }

    public String addPlaylistToPremiumU(String name, String nickname){
        LocalDate date = LocalDate.now();
        String msgConfirmation = "\nPlaylist creada correctamente.";
        boolean isFound = false;
        if(searchUser(nickname)!= null){
            for(int i = 0; i < users.size() && !isFound; i++){
                if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                    }else{
                        if(users.get(i) instanceof PremiumU){
                        PremiumU consumer = (PremiumU) users.get(i);
                        if(consumer.addPlaylistToArrayList(name).equalsIgnoreCase("Proceed.")){
                        msgConfirmation = "\nLo sentimos, este usuario tiene ya otra playlist con ese nombre.";
                        }else{
                            users.remove(i);
                            users.add(consumer);
                        }
                    }
                }
            }
        }else{
            msgConfirmation = "\nLo sentimos, el productor que intenta crear la playlist no se encuentra en el sistema.";
        }
        return msgConfirmation;
    }

}   
