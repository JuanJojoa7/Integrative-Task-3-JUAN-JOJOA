package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdminController{

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    
    /** AdminController: Constructor in charge of doing all the functions of the control of the system functions.
    */
    public AdminController(){
        this.users = new ArrayList<User>();
        this.audios = new ArrayList<Audio>();
    }

    /** searchUser: It is in charge of searching and finding users in the system thanks to their nickname.
    * @param nickname: String => It is the indicator to identify the users.
    * @return user: User => The validation of the found user is returned.
    */
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

    /** searchUserID: It is responsible for validating the IDs of all users in the system so that they are not repeated when registering.
    * @param id: String => It is the id that each user registers in the system.
    * @return user: User => Returns the validation of the user found with that id.
    */
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

    /** addUserStandard: It is in charge of adding a standard user to the system.
    * @param type: int => It is the type of user that is requested by console to add the standard user.
    * @param nickname: String => It is the name identifier that each user has.
    * @param id: String => This is the ID with which each user is identified.
    * @return msgConfirmation: String => The message confirming the creation of the user is returned.
    */
    public String addUserStandard(int type, String nickname, String id){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new UStandard(type, nickname, id, date));
        msgConfirmation = "\nSe ha agregado el usuario estandar correctamente.";
        return msgConfirmation;
    }

    /** addUserPremium: It is responsible for adding a premium user to the system.
    * @param type: int => It is the type of user that is requested by console to add the premium user.
    * @param nickname: String => It is the name identifier that each user has.
    * @param id: String => This is the ID with which each user is identified.
    * @return msgConfirmation: String => The message confirming the creation of the user is returned.
    */
    public String addUserPremium(int type, String nickname, String id){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new UPremium(type, nickname, id, date));
        msgConfirmation = "\nSe ha agregado el usuario premium correctamente.";
        return msgConfirmation;
    }

    /** addUserArtist: It is in charge of adding an artist type producer to the system.
    * @param type: int => This is the type that identifies the type of producer.
    * @param nickname: String => It is the name identifier that each user has.
    * @param id: String => This is the ID with which each user is identified.
    * @param urlImage: String => It is the image that the artist will have and with which he/she will differentiate himself/herself from others.
    * @return msgConfirmation: String => The message confirming the creation of the user is returned.
    */
    public String addUserArtist(int type, String name, String nickname, String id, String urlImage){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new UArtist(type, name, nickname, id, urlImage, date));
        msgConfirmation = "\nSe ha agregado el Artista correctamente.";
        return msgConfirmation;
    }

    /** addUserContentProducer: It is responsible for adding a content creator type producer to the system.
    * @param type: int => This is the type that identifies the type of producer.
    * @param nickname: String => It is the name identifier that each user has.
    * @param id: String => This is the ID with which each user is identified.
    * @param urlImage: String => It is the image that the artist will have and with which he/she will differentiate himself/herself from others.
    * @return msgConfirmation: String => The message confirming the creation of the user is returned.
    */
    public String addUserContentProducer(int type, String name, String nickname, String id, String urlImage){
        String msgConfirmation = null;
        LocalDate date = LocalDate.now();
        users.add(new UContentProducer(type, name, nickname, id, urlImage, date));
        msgConfirmation = "\nSe ha agregado el Creador de contenido correctamente.";
        return msgConfirmation;
    }

    /** addSongToArrayList: It is in charge of adding a song to the arrangement of songs that an artist has.
    * @param nicknameArtist: String => It is the identifier that each user has as a name in the system.
    * @param name: String => This is the name given to the producer.
    * @param album: String => It is the name of the album where the song will be.
    * @param urlImage: String => This is the image of the cover with which the song will be identified.
    * @param timeRep: String => This is the playback time in seconds that the song will have.
    * @param price: String => It is the price that the song will have.
    * @param genre: String => This is the ID with which the apartment is identified.
    * @return msgConfirmation: String => This is the message confirming that the song has been created and added to the arraylist.
    */
    public String addSongToArrayList(String nicknameArtist, String name, String album, String urlImage, int timeRep, double price, int genre){
        LocalDate date = LocalDate.now();
        String msgConfirmation = null;
        boolean isFound = false;
        if(searchUser(nicknameArtist) == null && searchUser(nicknameArtist) instanceof UContentProducer){
            msgConfirmation = "\nLo sentimos, el artista no fue encontrado.";
        }else{
            Audio song = new Song(nicknameArtist, name, album, urlImage, timeRep, price, genre);
            for(int i = 0; i < users.size() && !isFound; i++) {
                if(users.get(i).getNickname().equalsIgnoreCase(nicknameArtist)){
                    UArtist user = (UArtist) users.get(i);
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

    /** addPodcastToArrayList: It is in charge of adding a song to the arrangement of songs that an artist has.
    * @param nicknameContentP: String => It is the identifier that each user has as a name in the system.
    * @param name: String => This is the name given to the producer.
    * @param description: String => It is the description that will have the podcast to add.
    * @param urlImage: String => This is the image of the cover with which the podcast will be identified.
    * @param category: int => This is the category in which the podcast will be stored.
    * @param timeRep: int => It is the time of reproduction in seconds that the podcast will have.
    * @return msgConfirmation: String => This is the message confirming that the podcast has been created and added to the arraylist.
    */
    public String addPodcastToArrayList(String nicknameContentP, String name, String description, String urlImage, int category, int timeRep){
        LocalDate date = LocalDate.now();
        String msgConfirmation = null;
        boolean isFound = false;
        if(searchUser(nicknameContentP) == null && searchUser(nicknameContentP) instanceof UArtist){
            msgConfirmation = "\nLo sentimos, ese creador de contenido no se encuentra registrado.";
        }else{
            Audio podcast = new Podcast(nicknameContentP, name, description, urlImage, category, timeRep);
            for(int i = 0; i < users.size() && !isFound; i++){
                if(users.get(i).getNickname().equalsIgnoreCase(nicknameContentP)){
                    UContentProducer user = (UContentProducer) users.get(i);
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

    /** addPlaylistToStandardU: It is in charge of adding playlists for standard users.
    * @param playlistName: String => This is the name by which the playlist will be identified.
    * @param nickname: String => It is the nickname identifier of the standard user to whom the playlist will be created.
    * @return msgConfirmation: String => This is the message that is returned when creating the playlist for the user.
    */
    public String addPlaylistToStandardU(String playlistName, String nickname){
        LocalDate date = LocalDate.now();
        String msgConfirmation = "\nPlaylist creada correctamente.";
        boolean isFound = false;
        if(searchUser(nickname)!= null){
            for(int i = 0; i < users.size() && !isFound; i++){
                if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                    }else{
                        if(users.get(i) instanceof UStandard){
                            UStandard consumer = (UStandard) users.get(i);
                            String operationResult = consumer.addPlaylistToArrayList(playlistName);
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

    /** addPlaylistToStandardU: It is in charge of adding playlists for premium users.
    * @param playlistName: String => This is the name by which the playlist will be identified.
    * @param nickname: String => It is the nickname identifier of the standard user to whom the playlist will be created.
    * @return msgConfirmation: String => This is the message that is returned when creating the playlist for the user.
    */
    public String addPlaylistToPremiumU(String name, String nickname){
        LocalDate date = LocalDate.now();
        String msgConfirmation = "\nPlaylist creada correctamente.";
        boolean isFound = false;
        if(searchUser(nickname)!= null){
            for(int i = 0; i < users.size() && !isFound; i++){
                if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                    }else{
                        if(users.get(i) instanceof UPremium){
                        UPremium consumer = (UPremium) users.get(i);
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
