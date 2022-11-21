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
        String msgConfirmation = "\nCancion agregada correctamente";
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
        String msgConfirmation = "\nPodcast agregado correctamente";
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

    public String addPlaylist(String name, String user){

        String msgError = null;
        String msgConfirmation = "\nListo, playlist agregada correctamente.";
        boolean isFound = false;

        for(int i = 0; i < users.size() && !isFound; i++){

            if(users.get(i).getNickname().equalsIgnoreCase(user)){

                Consumer foundedConsumer = (Consumer) users.get(i);
                isFound = true;

                if(users.get(i) instanceof Producer){

                    msgConfirmation = "\nLo sentimos, solo usuarios consumidores pueden tener playlist.";

                }else{
                    String isCorrect = foundedConsumer.addPlaylist(name);

                    if(isCorrect.equalsIgnoreCase("")){

                        msgConfirmation = "\nLo sentimos ya se ha registrado una playlist con ese nombre.";

                    }else if(isCorrect.equalsIgnoreCase("")){

                        msgConfirmation = "\nLo sentimos, ha alcanzado el limite de playlists.";

                    }else{
                        users.remove(i);
                        users.add(foundedConsumer);
                    }
                }
            }
        }
        if(!isFound){
            msgError = null;
            msgConfirmation = "\nLo sentimos, ese usuario no se encuentra en el sistema.";
        }
        return msgConfirmation;
    }

    public String sharePlaylist(String name, String namePlaylist){
        String msgConfirmation = null;

        if(searchUser(name) != null){

            if(searchUser(name) instanceof Consumer){
                Consumer consumer = (Consumer) searchUser(name);

                if(consumer instanceof UStandard){
                    UStandard userFound = (UStandard) consumer;
                    if(userFound.searchPlaylist(namePlaylist) != null){

                        msgConfirmation = userFound.searchPlaylist(namePlaylist).sharePlaylist();

                    }else{

                        msgConfirmation = "\nLo sentimos, no se ha encontrado la playlist.";
                    }

                }else{

                    UPremium userFound = (UPremium) consumer;

                    if(userFound.searchPlaylist(namePlaylist) != null) {

                        msgConfirmation = userFound.searchPlaylist(namePlaylist).sharePlaylist();

                    }else{

                        msgConfirmation = "\nLo sentimos no se ha encontrado la playlist.";
                    }
                }
            }else{
                msgConfirmation = "\nLo sentimos, solo usuarios consumidores pueden compartir sus playlist.";
            }
        }else{
            msgConfirmation = "\nLo sentimos, este usuario no se encuentra en el sistema.";
        }
        return msgConfirmation;
    }

    public String simulateTracks(String nickname, String audio, int type, String producer){

        String msgConfirmation = null;

        if(searchUser(nickname) != null && searchUser(nickname) instanceof Consumer){
            Consumer consumer = (Consumer) searchUser(nickname);

            if(type == 1){

                if(searchUser(producer) != null && searchUser(producer) instanceof UArtist){

                    UArtist typeArtist = (UArtist) searchUser(producer);

                    if(typeArtist.searchSongOwner(audio) != null){

                        Song audioFounded = (Song) typeArtist.searchSongOwner(audio);
                        audioFounded.playAudio();
                        int counter = 0;

                        for(int i = 0; i < users.size() && counter != 2; i++){

                            if(users.get(i).getNickname().equalsIgnoreCase(nickname) && users.get(i) instanceof Consumer){

                                users.remove(i);
                                users.add(consumer);
                                counter++;
                            }

                            if(users.get(i).getNickname().equalsIgnoreCase(producer) && users.get(i) instanceof UArtist){

                                users.remove(i);
                                users.add(typeArtist);
                                counter++;

                            }
                        }

                    }else{

                        msgConfirmation = "\nLo sentimos, el audio que intentas buscar no se encuentra en el sistema.";

                    }

                }else{

                    msgConfirmation = "\nLo sentimos ese productor no esta en el sistema.";

                }

            }else if(type == 2){

                if(searchUser(producer) != null && searchUser(producer) instanceof UContentProducer){

                    UContentProducer typeProducer = (UContentProducer) searchUser(producer);

                    if(typeProducer.searchPodcastOwner(audio) != null){

                        Podcast audioFounded = (Podcast) typeProducer.searchPodcastOwner(audio);
                        audioFounded.playAudio();
                        int counter = 0;

                        for(int i = 0; i < users.size() && counter != 2; i++){

                            if(users.get(i).getNickname().equalsIgnoreCase(nickname) && users.get(i) instanceof Consumer){

                                users.remove(i);
                                users.add(consumer);
                                counter++;

                            }

                            if(users.get(i).getNickname().equalsIgnoreCase(producer) && users.get(i) instanceof UContentProducer){

                                users.remove(i);
                                users.add(typeProducer);
                                counter++;

                            }
                        }

                    }else{

                        msgConfirmation = "\nLo sentimos ese audio no esta en el sistema.";
                    }

                }else{

                    msgConfirmation = "\nLo sentimos, ese productor no esta en el sistema.";
                }

            }else{

                msgConfirmation = "\nLo sentimos, parece que has seleccionado un tipo incorrecto, intenta nuevamente.";
            }

        }else{

            msgConfirmation = "\nLo sentimos, ese usuario no ha sido encontrado.";
        }

        return msgConfirmation;
    }

    public String buySongToUser(String consumer, String song, String artist){
        String msgConfirmation = null;

        if(searchUser(consumer) != null && searchUser(consumer) instanceof Consumer){

            Consumer consumerFound = (Consumer) searchUser(consumer);

            if(searchUser(artist) != null && searchUser(artist) instanceof UArtist){

                UArtist artistFound = (UArtist) searchUser(artist);

                if(artistFound.searchSong(song)!= null){

                    Song music = artistFound.searchSong(song);

                    msgConfirmation = consumerFound.buySong(music);

                    if(msgConfirmation.equalsIgnoreCase("$$$")){

                        boolean isFound = false;

                        for(int i = 0; i < users.size() && !isFound; i++){

                            if(users.get(i).getNickname().equalsIgnoreCase(artist) && users.get(i) instanceof UArtist){

                                users.remove(i);
                                users.add(artistFound);

                            }
                        }
                    }
                }else{

                    msgConfirmation = "\nLo sentimos ese audio no se encuentra en el sistema.";
                }

            }else{

                msgConfirmation = "\nLo sentimos, ese artista no ha sido registrado.";
            }

        }else{

            msgConfirmation = "\nLo sentimos ese usuario no se encuentra en el sistema.";

        }

        return msgConfirmation;
    }




}   
