package model;
import java.util.ArrayList;
import java.util.Random;

public class Playlist{

    private String name;
    private ArrayList<Audio> audios;

    /** Playlist: It is the builder in charge of hosting the playlist types, for standard and premium and that saves the audios in playlists.
    * @param name: String => This is the name that the playlist will receive when it is created.
    */
    public Playlist(String name){
        this.name = name;
        this.audios = new ArrayList<Audio>();
    }

    /** searchSongInArrayList: It is in charge of looking for a song in the arrayList of songs to validate its existence and add it to the playlist.
    * @param name: String => It is the name of the song that will be searched and validated.
    * @param owner: UArtist => It is the artist object which must already be created to validate that the song is yours.
    * @return audioFounded: Audio => The song found in the arrayList is returned.
    */
    public Audio searchSongInArrayList(String name, UArtist owner){
        boolean isFound = false;
        Audio audioFounded = null;

        for(int i = 0; i < audios.size() && !isFound; i++){

            if(audios.get(i).getName().equalsIgnoreCase(name) && owner.searchSongInArrayList(name) != null){

                audioFounded = audios.get(i);
                isFound = true;
                
            }
        }
        return audioFounded;
    }

    /** searchPodcastInArraylist: It is in charge of searching and finding a podcast in the arraylist together with its creator and validates it.
    * @param name: String => It is the name of the podcast to search and validate.
    * @param contentProducer: UContentProducer => It is the content creator object with which the existence of the podcast is validated.
    * @return audioFounded: Audio => Returns the validation if the requested audio was found, in this case the podcast.
    */
    public Audio searchPodcastInArrayList(String name, UContentProducer contentProducer){

        boolean isFound = false;
        Audio audioFounded = null;

        for(int i = 0; i < audios.size() && !isFound; i++){

            if(audios.get(i).getName().equalsIgnoreCase(name) && contentProducer.searchPodcastV2(name) != null){

                audioFounded = audios.get(i);
                isFound = true;

            }
        }
        return audioFounded;
    }

    /** addAudio: It is in charge of adding the audio to each user's playlist arraylist.
    * @param audio: Audio => This is the audio to be recorded in the playlist.
    */
    public void addAudio(Audio audio) {
        audios.add(audio);
    }

    public String getName() {
        return name;
    }

    public void setPlaylistName(String name){
        this.name = name;
    }

    public String sharePlaylist(){

        String msgConfirmation = null;
        boolean songsFlag = false;
        boolean podcastsFlag = false;

        String code = "";
        int counterMatrix;

        int[][] matrix = new int[6][6];
        Random rand = new Random();

        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[i].length; j++){

                matrix[i][j] = rand.nextInt(9);
            }
        }

        for(int i = 0; i < audios.size(); i++){

            if(audios.get(i) instanceof Song){

                songsFlag = true;

            } else if (audios.get(i) instanceof Podcast){

                podcastsFlag = true;
            }
        }

        if(songsFlag && !podcastsFlag){
            counterMatrix = 5;

            while(counterMatrix != 0){

                code += matrix[counterMatrix][0];
                counterMatrix--;

            }

            while(counterMatrix != 5){

                code += matrix[counterMatrix][counterMatrix];
                counterMatrix++;

            }
            while(counterMatrix != -1){

                code += matrix[counterMatrix][5];
                counterMatrix--;

            }

        }else if(!songsFlag && podcastsFlag){
            counterMatrix = 0;

            while(counterMatrix != 2){

                code += matrix[0][counterMatrix];
                counterMatrix++;

            }

            counterMatrix = 0;
            while(counterMatrix != 6){

                code += matrix[counterMatrix][2];
                counterMatrix++;

            }

            counterMatrix--;

            while(counterMatrix != 0){

                code += matrix[counterMatrix][3];
                counterMatrix--;

            }

            counterMatrix = 3;

            while(counterMatrix != 6){

                code += matrix[0][counterMatrix];
                counterMatrix++;

            }

        }else if(songsFlag && podcastsFlag){
            counterMatrix = 2;

            for(int i = matrix.length - 1; i >= 0; i--){

                if(i > 1){

                    if (counterMatrix == 1){

                        code += matrix[i][5];
                        code += matrix[i][3];
                        code += matrix[i][1];
                        counterMatrix = 2;


                    }else{

                        code += matrix[i][4];
                        code += matrix[i][2];
                        code += matrix[i][0];
                        counterMatrix = 1;

                    }

                }else{

                    if(counterMatrix == 1){

                        code += matrix[i][5];
                        code += matrix[i][3];
                        counterMatrix = 2;

                    }else{

                        code += matrix[i][4];
                        code += matrix[i][2];
                        counterMatrix = 1;

                    }
                }
            }

        }else{

            msgConfirmation = "\nLo sentimos aun no se han registrado audios.";
            
        }

        if(!code.equals("")){

            msgConfirmation = "\nCodigo de la playlist: " + code;
        }

        return msgConfirmation;
    }

    
}
