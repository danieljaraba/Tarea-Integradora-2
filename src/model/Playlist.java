package src.model;

public class Playlist {
    //Atributes
    private String name;
    private int length;

    //Relationships
    private Genre[] genres;
    private Song[] songs;

    //Builder
    public Playlist(String name){
        this.name = name;
        this.length = 0;
        this.genres = new Genre[6];
        this.songs = new Song[30];
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return Genre[] return the genres
     */
    public Genre[] getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    /**
     * @return Song[] return the songs
     */
    public Song[] getSongs() {
        return songs;
    }

    /**
     * @param songs the songs to set
     */
    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

}
