package ui;
import model.*;
import java.util.Scanner;

public class VideoGame{

    public static Scanner reader;
    private GameController gamecontroller;

    public VideoGame(){
        reader = new Scanner(System.in);
        gamecontroller = new GameController();
    }

    public static void main(String[] args){ //Start of main method.
        VideoGame main = new VideoGame(); 

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
        System.out.print(
            "\nBienvenido, administrador del videojuego, que desea hacer hoy: \n"+	
            "1. Registrar jugador a un nivel\n"+
            "2. Registrar enemigos a un nivel\n"+
            "3. Registrar tesoros a un nivel\n"+
            "4. Modificar el puntaje de un jugador\n"+
            "5. Incrementar el nivel para un jugador\n"+
            "6. Informar los tesoros y enemigos de un nivel\n"+
            "7. Informar la cantidad de un tesoro en todo el juego\n"+
            "8. Informar cual es la cantidad de los enemigos de un tipo en todo el juego\n"+ 
            "9. Informar cual es el tesoro mas repetido de todos los niveles\n"+
            "10. Informar cual es el enemigo que otorga mayor puntaje y en que nivel se encuentra\n"+
            "11. Informar cual es la cantidad de consonantes en los nombres de todos los enemigos\n"+
            "12. Informar cuales son los mejores 5 jugadores\n"+
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
    */
    public void executeOption(int option){

        switch(option){
            case 1:

                boolean flag = gamecontroller.playerAvailableSpaces();
                if(flag){
                    System.out.println("\nHa iniciado, registro de jugador");

                    System.out.print("\nIngresa un nickname: ");
                    reader.nextLine();
                    String nickName = reader.nextLine();
                    
                    System.out.print("\nIngresa un nombre: ");
                    String name = reader.nextLine();
                    System.out.println(gamecontroller.addPlayer(nickName, name));

                }else{
                    System.out.println("\nLo sentimos, has alcanzado el limite de jugadores.");
                }

                break;

            case 2:

                String spaceFounded = null;
                System.out.println("\nHa iniciado, registrar enemigos a un nivel");
                System.out.println("\nNOTA: Recuerda que el videojuego consta de 10 niveles");
                System.out.print("\nIngresa el nivel, donde estara el nuevo enemigo: ");
                int levelEnemyFound = 0;

                int level = reader.nextInt();
                reader.nextLine();

                if(level >= 1 && level < 11){

                    if(gamecontroller.isFoundSpaceInLevel(level)){
                        System.out.print("\nIngresa el nombre del nuevo enemigo: ");
                        String name = reader.nextLine();

                        if(gamecontroller.validateEnemyName(name, level)){
                            System.out.print("\nQue tipo de enemigo es:\n" +
                            "\n1. Ogro" +
                            "\n2. Abstracto" +
                            "\n3. Jefe" +
                            "\n4. Magico" +
                            "\nOpcion: ");
                            int typeEnemy = reader.nextInt();

                            System.out.print("\nIngresa el puntaje otorgado al ser vencido: ");
                            int defeatScore = reader.nextInt();

                            System.out.print("\nIngresa el puntaje que quitara si golpea al jugador: ");
                            int playerDamage = reader.nextInt();

                            System.out.println(gamecontroller.addEnemyToLevel(level, name, typeEnemy, defeatScore, playerDamage));

                        }else{
                            System.out.println("\nLo sentimos, el nombre de ese enemigo ya se encuentra registrado en el nivel.");
                        }
                    }else{
                        System.out.println("\nLo sentimos, ha alcanzado el maximo de enemigos para este nivel.");
                    }
                }else{
                    System.out.println("\nLo sentimos, recuerda que solo hay 10 niveles, intenta nuevamente.");
                }

                break;

            case 3: 

                String msgSpaceTR = null;
                System.out.println("\nHa iniciado, registro de tesoros.");
                System.out.println("\nNOTA: Recuerda que el videojuego consta de 10 niveles.");
                System.out.print("\nIngresa el nivel donde estara el nuevo tesoro: ");
                int levelTR = reader.nextInt();
                int levelIf = 0;
            
                if(levelTR>0 &&levelTR<11){

                    if(gamecontroller.isFoundSpaceInTreasure(levelTR-1)){
                        System.out.print("\nIngresa el nombre del tesoro: ");
                        String name = reader.next();

                        System.out.print("\nIngresa la URL del tesoro: ");
                        String urlShowImage = reader.next();

                        System.out.print("\nQue puntaje le da al jugador si lo obtiene: ");
                        int scoreToPLayer = reader.nextInt();

                        System.out.print("\nIngresa cuantos tesoros de este tipo estaran en el nivel: ");
                        int levelQ = reader.nextInt();

                        System.out.println(gamecontroller.addNewTreasureToLevel(levelTR-1, name, urlShowImage, scoreToPLayer, levelQ));
                    }else{
                        System.out.println("\nLo sentimos, se ha alcanzado el limite de tesoros en este nivel.");
                    }
                }else{
                    System.out.println("\nLo sentimos, recuerda que solo hay 10 niveles, intenta nuevamente.");
                }

                break;

            case 4:

                String msgchangeScore = null;
                System.out.println("\nHa iniciado, Modificar el puntaje de un jugador.");
                if(gamecontroller.isFound()){

                    System.out.print("\nIngresa el nickname del jugador: ");
                    String nickName = reader.next();

                    if(gamecontroller.searchPlayerGetter(nickName)){

                        System.out.print("\nIngresa la nueva puntuacion del jugador: ");
                        System.out.println(gamecontroller.changeNewPlayerScore(reader.nextInt(), nickName));

                    }else{
                        System.out.println("\nLo sentimos, ese jugador no existe en el videojuego.");
                    }
                }else{
                    System.out.println("\nLo sentimos, aun no hay ningun jugador en el juego.");
                }

                break;

            case 5:
                String ifValidation = null;
                if(gamecontroller.isFound()){

                    System.out.println("\nHa iniciado, incrementar el nivel de un jugador.");

                    System.out.print("\nIngresa el nickname del jugador: ");
                    String nickName = reader.next();
                    
                    if(gamecontroller.searchPlayerGetter(nickName)){
                        System.out.println(gamecontroller.getUpPlayerLevel(nickName));
                    }else{
                        System.out.println("\nLo sentimos, ese jugador no existe en el videojuego.");
                    }
                }else{
                    System.out.println("\nLo sentimos, aun no hay ningun jugador en el videojuego.");
                }

                break;

            case 6:
                
                String msgILevel = null;
                System.out.println("\nHa iniciado, informar tesoros y enemigos de un nivel.");
                System.out.print("\nIngresa el nivel que quieres consultar: ");
                int levelIF = reader.nextInt();
                int levelFound = 0;

                if(levelIF>=1 && levelIF<=10){
                    System.out.println(gamecontroller.listEnemies(levelIF));
                    System.out.println(gamecontroller.listTreasure(levelIF));
                }else{
                    System.out.println("\nLo sentimos, recuerda que solo hay 10 niveles, intenta nuevamente.");
                }

                break;

            case 7: 

                String msgFoundTreasures = null;
                System.out.println("\nHa iniciado, informar la cantidad de un tesoro en todo el juego.");
                System.out.print("\nIngresa el nombre del tesoro que deseas consultar: ");
                System.out.println(gamecontroller.informTotalTreasureByName(reader.next()));
                int counted = 0;

                break;

            case 8: 
                int typeVal = 0;
                System.out.println("\nHa iniciado, informar la cantidad de enemigos de un tipo en el juego.");

                System.out.print("\nSelecciona un tipo de enemigo para consultar:" +
                "\n1. Ogro" +
                "\n2. Abstracto" +
                "\n3. Jefe" +
                "\n4. Magico" +
                "\nOpcion: ");
                int enemyType = reader.nextInt();

                if (enemyType < 5 && enemyType > 0){
                    System.out.println(gamecontroller.informTotalEnemiesByType(enemyType));
                } else {
                    System.out.println("\nLo sentimos, este tipo de enemigo no es valido.");
                }

                break;

            case 9: 

                System.out.println("");
                String msgVal = null;
                System.out.println(gamecontroller.getMostRepeatedTreasure());
                String ifVal = null;
                int repeatedTreasure = 0;

                break;

            case 10:    

                System.out.println("");
                String msgBestEnemy = null;
                System.out.println(gamecontroller.getMaxScoringEnemy());
                String msgValBestEnemy = null;
                int enemyId = 0;

                break;

            case 11: 

                System.out.println("");
                String msgConsonants = null;
                System.out.println(gamecontroller.getEnemyConsonants());
                String msgValConsonants = null;
                int countConsonants = 0;

                break;

            case 12:

                System.out.println(gamecontroller.getTopFivePlayersInGame());

                break;

            case 0: 
                System.out.println("\nHasta luego administrador.\n");    
                break;

            default:
                System.out.println("\nOpcion no valida, intenta nuevamente."); 
                break;   
        }
    }
}

