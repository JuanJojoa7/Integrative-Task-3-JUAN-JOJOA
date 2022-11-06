package ui;
import model.*;
import java.util.Scanner;

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
                nickname = reader.next(); 
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

                System.out.println(controller.addSongToArrayList(nickname, name, album, urlImage, timeRep, price, genre));
                
                break;

            case 4:
                System.out.print("\nHa iniciado, registrar un Podcast.\n");   
                System.out.print("\nIngresa el nombre del nuevo podcast: ");
                name = reader.next();
                System.out.print("\nIngresa el nombre del creador de contenido de este podcast: ");
                String contentProducer = reader.next(); 
                System.out.print("\nIngresa la URL con la caratula de este podcast: ");
                urlImage = reader.next();
                System.out.print("\nIngresa la descripcion que tendra el podcast: ");
                String description = reader.next();
                System.out.print("\nIngresa la duracion que tendra el podcast (En segundos): ");
                timeRep = reader.nextInt();
                System.out.print("\nIngresa la categoria que tendra este podcast: "+
                "\n1. Politico"+
                "\n2. Entretenimiento"+
                "\n3. Videojuego"+
                "\n4. Moda"+
                "\nOpcion: ");
                int category = reader.nextInt();

                System.out.println(controller.addPodcastToArrayList(contentProducer, name, description, urlImage, category, timeRep));

                break;

            case 5:
                System.out.println("\nHa iniciado, registrar lista de reproduccion.");
                System.out.print("\nIngresa un nombre para esta playlist: ");
                name = reader.next();
                System.out.print("\nIngresa el usuario al cual se le agregara la playlist: ");
                nickname = reader.next();
                System.out.print("\nQue tipo de membresia tiene este usuario:" +
                        "\n1. Estandar." +
                        "\n2. Premium." +
                        "\nOpcion: ");
                    int optionUser = reader.nextInt();
                    switch(optionUser){
                        case 1:
                            System.out.println(controller.addPlaylistToStandardU(name, nickname));
                            break;
                        case 2:
                            System.out.println(controller.addPlaylistToPremiumU(name, nickname));
                            break;
                        default:
                            System.out.println("\nLo sentimos, ese no es un tipo de usuario valido para agregar playlist.");
                            break;    
                    }

                break;

            case 6:
                
                break;

            case 7: 

                break;

            case 8: 

                break;

            case 9: 

                break;

            case 10:    

                break;

            case 11: 

                break;

            case 12:

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
