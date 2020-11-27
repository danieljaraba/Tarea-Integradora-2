package model;

/**
 * Playlist
 * Abstract class that is used to heredate subclasses
 * @author danieljag
 */
public abstract class Playlist {
    //Atributes
    private String name;
    private int minutes;
    private int seconds;
    private int numOfSongs;
    private int numOfGenres;

    //Relationships
    private Genre[] genres;
    private Song[] songs;

    //Builder

    /**
     * Playlist, builder of Playlist <br/>
     * @param name string, contains the name of the playlist
     */
    public Playlist(String name){
        this.name = name;
        this.minutes = 0;
        this.seconds = 0;
        this.genres = new Genre[6];
        this.songs = new Song[30];
        this.numOfSongs = 0;
    }

    /**
     * addSong, adds a song to the playlist <br/>
     * <b> Pre:<b/> The array of songs is initialized <br/>
     * @param song Song, contains the song that is going to be added
     */
    public void addSong(Song song){
        songs[numOfSongs] = song;
        minutes += song.getMinutes();
        seconds += song.getSeconds();
        if(seconds > 60){
            seconds -= 60;
            minutes++;
        }
        genres[numOfGenres] = song.getGenre();
        numOfGenres++;
    }

    /**
     * showGenre, update the genre of the playlist <br/>
     * <b> Pre:<b/> The playlist is created <br/>
     * @return text, contains the info of the genres
     */
    public String showGenre(){
        Genre[] aGenres = new Genre[numOfGenres];
        String text = "";
        int numOfaGenres = 0;
        int cont = 0;
        for(int i = 0; i<numOfGenres; i++){
            cont = 0;
            if(numOfaGenres > 0){
                for(int b = 0; b<numOfaGenres; b++){
                    if(genres[i] == aGenres[b]){
                        cont++;
                    }
                }
                if(cont == 0){
                    aGenres[numOfaGenres] = genres[i];
                    numOfaGenres++;
                }
            } else{
                aGenres[numOfaGenres] = genres[i];
                numOfaGenres++;
            }
        }
        for(int i = 0; i<numOfaGenres; i++){
            text += aGenres[i] + ", ";
        }
        return text;
    }

    /**
     * showPlaylist, shows the info of the playlist <br/>
     * <b> Pre:<b/> The playlist is created <br/>
     * @return text, contains the info of the song
     */
    public String showPlaylist(){
        String text = "\n**************  Playlist **************\n"+
                      "**  Title: "+ name + "\n"+
                      "**  Duration: "+ minutes + ":" + seconds + "\n"+
                      "**  Genre: " + showGenre() + "\n"+
                      "\n";
        return text;
    }

    /**
     * isUser, checks if the user is in the playlist <br/>
     * @param user string, contains the name of the user
     * @return true
     */
    public boolean isUser(String user){
        return true;
    }

    /**
     * 
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     */
    public Genre[] getGenres() {
        return genres;
    }

    /**
     * 
     * @param genres
     */
    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    /**
     * 
     * @return
     */
    public int getMinutes(){
        return minutes;
    }

    /**
     * 
     * @param minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * 
     * @return
     */
    public int getSeconds(){
        return seconds;
    }

    /**
     * 
     * @param seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * 
     * @return
     */
    public int getNumOfSongs() {
        return numOfSongs;
    }

    /**
     * 
     * @param numOfSongs
     */
    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    /**
     * 
     * @return
     */
    public int getNumOfGenres() {
        return numOfGenres;
    }

    /**
     * 
     * @param numOfGenres
     */
    public void setNumOfGenres(int numOfGenres) {
        this.numOfGenres = numOfGenres;
    }
}
