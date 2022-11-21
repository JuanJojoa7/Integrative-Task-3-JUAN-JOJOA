package ui;
import model.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class NeoTunesApp{

    public static Scanner reader;
    private AdminController controller;

    public NeoTunesApp(){
        reader = new Scanner(System.in);
        controller = new AdminController();
    }

    public static void main(String[] args){ //Start of main method.
        NeoTunesApp main = new NeoTunesApp(); 

        int option = -1; 
        do{ //Start of the cycle
            option = main.getOptionShowMenu(); 
            main.executeOption(option);

        }while(option != 0); //End of the cycle.

    } //End of main method.

    /** getOptionShowMenu: It is responsible for obtaining the menu of options for interaction with the user.
    * @return Option: int => This is the option with which you interact with the program.
    */
    public int getOptionShowMenu(){
        int option = 0; 
        printMenu();

        option = validateReader(); 

        return option; 
    }

    /** printMenu: It is in charge of showing the user the game options ribbon.
     */ 
    public void printMenu(){
        System.out.println("\nBienvenido a NeoTunes App");
        System.out.print(
            "\nQuerido usuario de NeoTunes, que desea hacer hoy: \n"+	
            "1. Registrar usuarios consumidores(Estandar y Premium).\n"+
            "2. Registrar usuarios productores(Artistas y creadores de contenido).\n"+
            "3. Registrar cancion.\n"+
            "4. Registrar podcast.\n"+
            "5. Crear una lista de reproduccion.\n"+
            "6. Editar lista de reproduccion.\n"+
            "7. Compartir playlist.\n"+
            "8. Simular una reproducion.\n"+
            "9. Comprar una cancion. \n"+
            "10. Generar informes. \n"+
            "0. Salir del programa. \n"+
            "Opcion: ");  
    }

    /** validateReader: It is responsible for validating that the user has entered a numerical entry in the options.
    * @return option: int => The option selected by the user.
    */
    public int validateReader(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }

    /** executeOption: It is in charge of executing the option requested by the user.
    * @param option: int => It is the option with which the user interacts in the menu. 
    */
    public void executeOption(int option){
        String msgError = null;

        switch(option){
            case 1:
                System.out.println("\nHa iniciado, registro de Consumidor.");
                System.out.print("\nIngresa un nickname: ");
                String nickname = reader.next();

                if(controller.searchUser(nickname)==null){

                    System.out.print("\nIngresa un ID: ");
                    String id = reader.next();

                    if(controller.searchUserID(id)==null){

                        System.out.print("\nQue tipo de usuario se va a agregar:" +
                        "\n1. Estandar." +
                        "\n2. Premium." +
                        "\nOpcion: ");

                        int optionUser = reader.nextInt();
                        int type = 0;

                        switch(optionUser){
                            case 1:
                                System.out.println(controller.addUserStandard(type, nickname, id));
                                break;
                                
                            case 2:
                                System.out.println(controller.addUserPremium(type, nickname, id));
                                break;

                            default:
                                System.out.println("\nLo sentimos, ese no es un tipo de usuario valido.");
                                break;    
                        }

                    }else{

                        System.out.println("\nLo sentimos, ya existe un usuario con ese ID.");
                    }

                }else{

                    System.out.println("\nLo sentimos, ya existe un usuario con ese nickname.");
                }
            
                break;

            case 2:
                System.out.println("\nHa iniciado, registro de Productor.");
                System.out.print("\nIngresa un nombre: ");
                String name = reader.next();

                System.out.print("\nIngresa un nickname: ");
                nickname = reader.next();

                if(controller.searchUser(nickname)==null){

                    System.out.print("\nIngresa un ID: ");
                    String id = reader.next();

                    if(controller.searchUserID(id)==null){

                        System.out.print("\nIngresa la URL de la imagen del productor: ");
                        String urlImage = reader.next();
                        System.out.print("\nQue tipo de productor se va a agregar:" +
                        "\n1. Artista." +
                        "\n2. Creador de contenido." +
                        "\nOpcion: ");

                        int optionUser = reader.nextInt();
                        int type = 0;

                        switch(optionUser){

                            case 1:
                                System.out.println(controller.addUserArtist(type, name, nickname, id, urlImage));
                                break;

                            case 2:
                                System.out.println(controller.addUserContentProducer(type, name, nickname, id, urlImage));
                                break;

                            default:
                                System.out.println("\nLo sentimos, ese no es un tipo de productor valido.");
                                break;    
                        }
                    }else{
                        System.out.println("\nLo sentimos, ya existe un usuario con ese ID.");
                    }
                    
                }else{
                    System.out.println("\nLo sentimos, ya existe un productor con ese nickname.");
                }

                break;

            case 3: 
                System.out.print("\nHa iniciado, registrar una cancion.\n");   
                System.out.print("\nIngresa el nombre de la nueva cancion: ");
                name = reader.next();

                System.out.print("\nIngresa el nombre del artista de esta cancion: ");
                String nicknameArtist = reader.next(); 
        
                System.out.print("\nIngresa la URL con la caratula de la cancion: ");
                String urlImage = reader.next();

                System.out.print("\nIngresa el nombre del album donde ira la cancion: ");
                String album = reader.next();

                System.out.print("\nIngresa la duracion que tendra la cancion (En segundos): ");
                int timeRep = reader.nextInt();

                System.out.print("\nIngresa el valor de venta de la cancion: ");
                double price = reader.nextInt();

                System.out.print("\nIngresa el genero que tendra esta cancion: "+
                "\n1. Rock"+
                "\n2. Pop"+
                "\n3. Trap "+
                "\n4. House"+
                "\nOpcion: ");
                int genre = reader.nextInt();

                System.out.println(controller.addSongToArrayList(nicknameArtist, name, album, urlImage, timeRep, price, genre));
                
                break;

            case 4:
                System.out.print("\nHa iniciado, registrar un Podcast.\n");   
                System.out.print("\nIngresa el nombre del nuevo podcast: ");
                name = reader.next();

                System.out.print("\nIngresa el nombre del creador de contenido de este podcast: ");
                String nicknameContentP = reader.next(); 
                System.out.print("\nIngresa la URL con la caratula de este podcast: ");
                urlImage = reader.next();

                System.out.print("\nIngresa la descripcion que tendra el podcast: ");
                String description = reader.next();
                System.out.print("\nIngresa la duracion que tendra el podcast (En segundos): ");
                timeRep = reader.nextInt();

                System.out.print("\nIngresa la categoria que tendra este podcast: "+
                "\n1. Politico"+
                "\n2. Entretenimiento"+
                "\n4. Moda"+
                "\n3. Videojuego"+
                "\nOpcion: ");
                
                int category = reader.nextInt();

                System.out.println(controller.addPodcastToArrayList(nicknameContentP, name, description, urlImage, category, timeRep));

                break;

            case 5:
                
                boolean ifFounded = false;
                System.out.println("\nHa iniciado, registrar playlist.");
                System.out.print("\nIngresa el nombre para esta playlist: ");
                name = reader.next();

                System.out.print("\nIngresa el usuario para vincular la playlist: ");
                nickname = reader.next();

                System.out.println(controller.addPlaylist(name, nickname));

                break;

            case 6:
                

                break;

            case 7: 

                String msgConfirmation = null;
                String isFoundedPlaylist = null;
                System.out.print("\nIngresa el nombre del consumidor que compartira la playlist: ");
                name = reader.next();

                System.out.print("\nIngresa la playlist que compartira el consumidor: ");
                String playlist = reader.next();

                System.out.println(controller.sharePlaylist(name, playlist));

                break;

            case 8: 
                System.out.println("\nHa iniciado, simular reproduccion de audios.");
                System.out.print("\nIngresa el nickname del consumidor: ");
                nickname = reader.next();

                System.out.print("\nIngresa el nombre del audio: ");
                String audioSearched = reader.next();
                
                System.out.print("\nQue tipo de audio es: " +
                "\n1. Cancion." +
                "\n2. Podcast." +
                "\nOpcion: ");

                Timer timer = new Timer();
                TimerTask task = new TimerTask(){
                    int counter = 0;
                    public void run() {
                        System.out.print(".");
                        counter++;
                        if (counter == 1){
                            cancel();
                        }
                    }
                };

                int typeAudio = reader.nextInt();
                System.out.print("\nIngresa el nombre del productor de este audio: ");
                String nicknameProducer = reader.next();

                msgConfirmation = controller.simulateTracks(nickname, audioSearched, typeAudio, nicknameProducer);

                if(msgConfirmation.equalsIgnoreCase("Reproduciendo...")){

                    System.out.println("\nEstas escuchando " + audioSearched + " de " + nicknameProducer + "");
                    timer.schedule(task, 500, 500);

                    try{
                        Thread.sleep(2500);
                    }catch(Exception errorOfTime){

                        System.out.println(errorOfTime);
                    }

                    System.out.print("\nQue te ha parecido la cancion: ");
                    String msgSatis = reader.next();

                }else{

                    System.out.println(msgConfirmation);
                }

                break;

            case 9: 

                System.out.println("\nHa iniciado, comprar una cancion.");
                System.out.print("\nIngresa el nickname del consumidor: ");
                nickname = reader.next();

                System.out.print("\nIngresa el nombre de la cancion que deseas comprar: ");
                String songOption = reader.next();

                System.out.print("\nQuien produjo esta cancion: ");
                String nameArtist = reader.next();

                System.out.println(controller.buySongToUser(nickname, songOption, nameArtist));

                break;

            case 10:    

                break;

            case 0: 
                System.out.println("\nHasta luego querido usuario.\n");    
                break;

            default:
                System.out.println("\nOpcion no valida, intenta nuevamente."); 
                break;   
        }
    }
}

