package model;

public class GameController{

    public static final int SIZE_OF_PLAYERS = 20;
    public static final int SIZE_OF_LEVELS = 10;
    public static final int SIZE_OF_TREASURES = 50;
    public static final int SIZE_OF_ENEMIES = 25;
    private Player[] players;
    private Level[] levels;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private int resPixelX;
    private int resPixelY;

    public GameController(){
        players = new Player[SIZE_OF_PLAYERS];
        levels = new Level[SIZE_OF_LEVELS];
        enemies = new Enemy[SIZE_OF_ENEMIES];
        treasures = new Treasure[SIZE_OF_TREASURES];
        resPixelX = 1280;
        resPixelY = 720;
        for(int i=0; i<SIZE_OF_LEVELS; i++){
            levels[i] = new Level(i+1,(i+1)*50);
        }
    }

    /** addPlayer: It is in charge of adding players to the video game.
    * @param nickName: String => It is the player's nickname.
    * @param name: String => It is the name of the player to be registered.
    * @return msgNewPlayer: String => This is the message confirming the creation of the player. 
    */
    public String addPlayer(String nickName, String name){

        String msgNewPlayer = "\nSe ha agregado un nuevo jugador al juego.";
        boolean found = false;

        for(int i=0; i<SIZE_OF_PLAYERS && !found; i++){

            if(players[i] != null && players[i].getNickname().equals(nickName)){

                msgNewPlayer = "\nLo sentimos, este nickname ya ha sido escogido, intenta nuevamente.";

                found = true;

            }
        }

        if(!found){

            for (int i=0;  i<SIZE_OF_PLAYERS && !found; i++){

                if (players[i] == null){

                    players[i] = new Player(nickName, name, levels[0]);

                    found = true;
                }
            }
        }

        return msgNewPlayer;
    }

    /** validateEnemyName: It is responsible for validating the enemy name and seeing if there is space in the enemy array.
    * @param name: String => It is the name of the enemy to be registered.
    * @param level: int => This is the level where the enemy will go.
    * @return flag: boolean => This is the message confirming the creation of the player. 
    */
    public boolean validateEnemyName(String name, int level){

        return levels[level].isFoundSpaceEnemies(name);

    }

    /** searchPlayerGetter: It is in charge of the validation of finding a player in the game.
    * @param nickName: String => It is the nickname to search for the player.
    * @return flag: boolean => It is the validation obtained if the player was found.
    */
    public boolean searchPlayerGetter(String nickName){

        double foundPlayer = 0.0;
        boolean flag = false;

        for (int i=0; i<SIZE_OF_PLAYERS && !flag; i++){

            if (players[i] != null && players[i].getNickname().equals(nickName)){

                flag = true;
            }
        }

        return flag;
    }

    public boolean isFoundSpaceInLevel(int level){

        return levels[level].isFoundSpaceEnemies(null);

    }

    public boolean isFound(){

        if(players[0] == null){

            return false;

        }else{

            return true;
        }
    }

    /** playerAvailableSpaces: He is in charge of finding spaces for new players in the players' arrangement.
    * @return flag: boolean => It is the validation that determines if there are free spaces in the game.
    */
    public boolean playerAvailableSpaces(){

        boolean IsFound = false;
        boolean flag = false;
        
        for(int i=0; i<SIZE_OF_PLAYERS && !flag; i++){

            if (players[i] == null){
                
                flag = true;
            }
        }

        return flag;
    }

    /** changeNewPlayerScore: It is responsible for changing the score of a player in the game.
    * @param playerScore: int => This is the player's new score.
    * @param nickName: String => It is the nickname of the player to change the score.
    * @return msgConfirmation: String => It is the confirmation of the successful score change.
    */
    public String changeNewPlayerScore(int playerScore, String nickName){

        String msgConfirmation = "\nSe ha cambiado el puntaje del jugador correctamente.";
        boolean Founded = false;

        for(int i=0; i<SIZE_OF_PLAYERS && !Founded; i++){

            if(players[i].getNickname().equals(nickName)){

                if (players[i].getScore()>playerScore){

                    msgConfirmation = "\nLo sentimos, no puedes poner un valor menor al puntaje actual del jugador.";

                } else if(players[i].getScore() == playerScore){

                    msgConfirmation = "\nLo sentimos, no puedes cambiar la puntuacion al mismo valor que ya tiene el jugador.";

                } else{

                    players[i].setScore(playerScore);
                }

                Founded = true;
            }
        }

        return msgConfirmation;
    }

    /** getUpPlayerLevel: It is in charge of leveling up the player or alerting him/her what score he/she needs to level up.
    * @param nickName: String => It is the nickname to search for the player.
    * @return msgConfirmationLevel: String => It is the confirmation of whether or not the player can level up.
    */
    public String getUpPlayerLevel(String nickName){

        String msgConfirmationLevel = null;
        boolean isFounded = false;
        boolean flag = false;

        for(int i=0; i<SIZE_OF_PLAYERS && !flag; i++){

            if(players[i].getNickname().equals(nickName)){

                int actualScore = players[i].getScore();
                int actualLevel = players[i].getLevel().getId();
                int necessaryScore = players[i].getLevel().getScoreRequired();

                if(actualLevel >= 10){

                    msgConfirmationLevel = "\nLo sentimos, este jugador ha alcanzado el nivel maximo.";

                }else{

                    if(actualScore >= necessaryScore){

                        players[i].setLevel(levels[actualLevel]);

                        System.out.println("\nEl jugador ha subido de nivel.");
                        msgConfirmationLevel = "\nEl jugador esta en el nivel: " + (actualLevel+1);

                    }else{

                        System.out.println("\nLo sentimos, el jugador no tiene el puntaje suficiente");
                        msgConfirmationLevel = "\nEl jugador esta en el nivel: " + actualLevel + "Con puntuacion de: " + actualScore + "Necesita un puntaje de: " + necessaryScore + " Para subir de nivel.";
                    }
                }

                flag = true;
            }
        }

        return msgConfirmationLevel;
    }

    /** addNewTreasureToLevel: It is the method in charge of adding a treasure to a specific level.
    * @param level: int => This is the level selected to add the treasure.
    * @param name: String => This is the name that the treasure will bear.
    * @param urlShowImage: String => It is the url image that will have the treasure.
    * @param scoreToPlayer: int => This is the score that will be awarded to the player.
    * @param qLevel: int => It is the amount of treasures that will be in that level.
    * @return msgConfirmation: String => It is the confirmation that will be given when adding treasures to the level.
    */
    public String addNewTreasureToLevel(int level, String name, String urlShowImage, int scoreToPlayer, int qLevel){

        return levels[level].addTreasureToGame(name, urlShowImage, scoreToPlayer, qLevel, resPixelX, resPixelY);

    }

    public boolean isFoundSpaceInTreasure(int level){

        return levels[level].isFoundSpaceFTreasures();
    }

    /** listEnemies: It is the method in charge of listing all the enemies of a specific level.
    * @param levelIF: int => It is the selected level where the enemies will be consulted.
    * @return msgConfirmation: String => This is the confirmation message with the enemies listed.
    */
    public String listEnemies(int levelIF){

        String msgConfirmation ="\nLos enemigos son: " + enemies;

        for(int i=0; i<SIZE_OF_ENEMIES; i++){

            if(enemies[i] != null && enemies[i].getLevel().getId()==levelIF){

                msgConfirmation += enemies[i].getName() + enemies;

            }
        }

        return msgConfirmation;
    }
    
    /** listTreasure: It is the method in charge of listing the treasures of a specific level.
    * @param levelIF: int => This is the level in question to be consulted.
    * @return msgConfirmation: String => It is the confirmation of the treasures listed in the level.
    */
    public String listTreasure(int levelIF){

        String msgConfirmation ="\nLos tesoros son: " + treasures;

        for(int i=0; i<SIZE_OF_TREASURES; i++){

            if(treasures[i] != null && treasures[i].getLevel().getId()==levelIF){

                msgConfirmation += treasures[i].getName() + treasures;
            }
        }

        return msgConfirmation;
    }

    /** informTotalTreasureByName: It is in charge of looking for a treasure and its repeated times in the level to be consulted.
    * @param name: String => It is the name of the treasure to be sought.
    * @return msgConfirmation: String => These are the treasures found after the consultation.
    */
    public String informTotalTreasureByName(String name){

        int totalFound = 0;
        String msgConfirmation = "\nLos tesoros encontrados fueron: ";
        int amountOfTreasures = 0;
        for(int i=0; i<SIZE_OF_LEVELS; i++){

            amountOfTreasures += levels[i].getAmountTypeTreasure(name);

        }

        if(amountOfTreasures == 0){

            boolean continue4 = false;
            msgConfirmation = "\nLo sentimos, no se han podido encontrar tesoros con ese nombre.";

            return msgConfirmation;

        }else{

            return msgConfirmation + amountOfTreasures;

        }
    }

    /** addEnemyToLevel: It is in charge of adding an enemy to a specific level.
    * @param level: int => This is the level where the enemy will be added.
    * @param name: String => It is the name of the enemy to be added.
    * @param enemyType: int => This is the type of enemy into which the enemy will be classified.
    * @param defeatScore: int => It is the score that will be given to the player if he defeats the enemy.
    * @param playerDamage: int => It is the score that will be taken away from the player if he is hit by the enemy.
    * @return msgConfirmation: String => It is the confirmation message that will correctly add the enemy.
    */
    public String addEnemyToLevel(int level, String name, int enemyType, int defeatScore, int playerDamage){

        int countedEnemies = 0;
        return levels[level].addEnemyToGame(name, enemyType, defeatScore, playerDamage, resPixelX, resPixelY);
    }

    /** informTotalEnemiesByType: It is the method in charge of querying all enemies of a specific type throughout the game.
    * @param totalCountEnemies: int => Enemies encountered are of the type requested.
    * @return msgTotalEnemiesType: String => It is responsible for returning the query of the encountered enemies.
    */
    public String informTotalEnemiesByType(int totalCountEnemies){

        String msgTotalEnemiesType = "\nSe han encontrado estos enemigos: ";
        int getOfEnemies = 0;

        for(int i=0; i<SIZE_OF_LEVELS; i++){

            getOfEnemies += levels[i].getEnemiesType(totalCountEnemies);
            String validateType = null;

        }

        if(getOfEnemies == 0){

            boolean continue8 = false;
            msgTotalEnemiesType = "\nLo sentimos, no se han podido encontrar enemigos.";

            return msgTotalEnemiesType;

        }else{

            return msgTotalEnemiesType + getOfEnemies;

        }
    }

    /** getMostRepeatedTreasure: It is in charge of consulting the most repeated treasure of the whole game and its appearances.
    * @return msgConfirmation: String => After having consulted throughout the game, the most repeated treasure is returned to the user.
    */
    public String getMostRepeatedTreasure(){

        String msgConfirmation = null;
        int countedRepeated = 0;
        String msgValidation = null;
        boolean finished = false;
        int amountTreasures = 0;
        String[] foundTreasures = new String[SIZE_OF_LEVELS * levels[0].getMaxTreasures()];
        
        for(int i = 0; i < SIZE_OF_LEVELS; i++){

            String[] foundedNames = levels[i].getTreasuresName();

            for(int j = 0; j < SIZE_OF_LEVELS * levels[i].getMaxTreasures() && !finished; j++){

                if(foundTreasures[j] == null && foundedNames[countedRepeated] != null){

                    foundTreasures[j] = foundedNames[countedRepeated]; countedRepeated++;
                }
                boolean continueIF = false;
                if(foundedNames[countedRepeated] == null){

                    finished = true;
                }
            }
            countedRepeated = 0;

            finished = false;
        }

        for(int i = 0; i < SIZE_OF_LEVELS * levels[0].getMaxTreasures(); i++){

            String treasure = foundTreasures[i];

            for(int j = 0; j < SIZE_OF_LEVELS * levels[0].getMaxTreasures(); j++){

                if(foundTreasures[j] != null && foundTreasures[j].equalsIgnoreCase(treasure)){ countedRepeated++;
                }
            }
            if(countedRepeated > amountTreasures){

                amountTreasures = countedRepeated;

                msgConfirmation = "\nEl tesoro mas repetido en el juego es: " + treasure + " con " + countedRepeated + " Apariciones. ";
            }

            countedRepeated = 0;
        }

        if(amountTreasures == 0){

            String msgVal = null;
            msgConfirmation = "\nLo sentimos, no hay tesoros registrados.";
        }

        return msgConfirmation;
    }

    /** getEnemyConsonants: It is responsible for obtaining the consonants of the names of enemies, working together, with the method, to find consonants.
    * @return msgConsonants: String => It is responsible for obtaining the consonants of the names of enemies.
    */
    public String getEnemyConsonants(){

        String msgConsonants = null;
        int amountIfConsonants = 0;
        int countedConsonants = 0;
        
        for(int i = 0; i < SIZE_OF_LEVELS; i++){
            amountIfConsonants += levels[i].getConsonants();

            msgConsonants = "\nSe encontraron las siguientes consonantes en los nombres de los enemigos: " + amountIfConsonants;
        }
        if(amountIfConsonants == 0){

            boolean continueSearching = false;
            msgConsonants = "\nLo sentimos, no se han encontrado consonantes.";
        }

        return msgConsonants;
    }

    public String getMaxScoringEnemy(){

        String msgConfirmation = "\nLo sentimos, no hay enemigos registrados.";
        String nameEnemy = null;
        int enemyScore = 0;
        
        for(int i = 0; i < SIZE_OF_LEVELS; i++){

            if(levels[i].getMaxEnemyScore()>enemyScore){

                nameEnemy = levels[i].getMaxEnemyName();
                enemyScore = levels[i].getMaxEnemyScore();
                msgConfirmation = "\nEste es el enemigo con mayor puntuacion: " + nameEnemy + " con puntuacion de " + enemyScore + " En el nivel: " + (i);
        
            }
        }

        return msgConfirmation;
    }

    /** getTopFivePlayersInGame: It is in charge of getting the best 5 players in the whole game.
    * @return msgGetTop5: String => Returns the 5 best players in the game.
    */
    public String getTopFivePlayersInGame(){

        String msgGetTop5 = "\nHa iniciado, consultar los mejores 5 jugadores.";
        int getPlayerScore[] = new int[SIZE_OF_PLAYERS];
        boolean continueIF = false;
        int countedPlayers = 0;
        int numOfPlayers = 0;
        int posPlayer = 0;
        String getNicknames[] = new String[SIZE_OF_PLAYERS];
        boolean continueSearching = false;
        
        if (players[0] != null){

            for (int i = 0; i < SIZE_OF_PLAYERS; i++){

                if(players[i] != null){

                    getPlayerScore[i] = players[i].getScore();

                    getNicknames[i] = players[i].getNickname();

                    numOfPlayers++;
                }
            }
            while(!continueSearching){


                if(getNicknames[posPlayer] != null && getPlayerScore[posPlayer] < getPlayerScore[posPlayer+1]){
        
                    int arrayScore = getPlayerScore[posPlayer+1];

                    getPlayerScore[posPlayer+1] = getPlayerScore[posPlayer];

                    getPlayerScore[posPlayer] = arrayScore;

                    String arrayNickname = getNicknames[posPlayer+1];

                    getNicknames[posPlayer+1] = getNicknames[posPlayer];

                    getNicknames[posPlayer] = arrayNickname;

                    posPlayer = 0;

                    for(int j = 0; j < numOfPlayers; j++){

                        if(getNicknames[j] != null && j != numOfPlayers-1 && getPlayerScore[j] >= getPlayerScore[j+1]){ countedPlayers++;

                        }
                        if(countedPlayers == numOfPlayers-1){

                            continueSearching = true;

                            countedPlayers = 0;
                        }
                    }

                        countedPlayers = 0;

                }else{

                    if(getPlayerScore[posPlayer] == 0){

                        continueSearching = true;
                    }

                    posPlayer++;
                }
            }

            for(int i=0; i<5; i++){

                if(getNicknames[i] != null){

                    msgGetTop5 += "\nJugador " + (i+1) + ": " + getNicknames[i] + " con puntuacion de " + getPlayerScore[i];
                }
            }
        }
        return msgGetTop5;
    }

    
}
