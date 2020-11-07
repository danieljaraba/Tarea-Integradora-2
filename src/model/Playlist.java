package model;

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
    public Playlist(String name){
        this.name = name;
        this.minutes = 0;
        this.seconds = 0;
        this.genres = new Genre[6];
        this.songs = new Song[30];
        this.numOfSongs = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

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

    public String showGenre(){
        Genre[] aGenres = genres;
        int numOfaGenres = numOfGenres;
        String text = "";
        int cont = 0;
        int index = 0;
        for(int i = 0; i<numOfGenres; i++){
            cont = 0;
            for(int b = 0; i<numOfaGenres; i++){
                if(genres[i] == aGenres[b]){
                    cont++;
                }
                if(cont > 1){
                    index = b;
                }
            }
            aGenres[index] = null;
            numOfaGenres--;
        }
        for(int i = 0; i<6; i++){
            if(aGenres[i] != null){
                text += aGenres[i] + ", ";
            }
        }
        return text;
    }

    public String showPlaylist(){
        String text = "\n**************  Playlist **************\n"+
                      "**  Title: "+ name + "\n"+
                      "**  Duration: "+ minutes + ":" + seconds + "\n"+
                      "**  Genre: " + showGenre() + "\n"+
                      "\n";
        return text;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getNumOfGenres() {
        return numOfGenres;
    }

    public void setNumOfGenres(int numOfGenres) {
        this.numOfGenres = numOfGenres;
    }

    public int getMinutes(){
        return minutes;
    }

    public int getSeconds(){
        return seconds;
    }

}
