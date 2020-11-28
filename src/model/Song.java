package model;

/**
 * Song, is used to create an object of song
 * @author danieljag
 */
public class Song {
    //Atributes
    private String title;
    private String author;
    private String releaseDate;
    private int minutes;
    private int seconds;

    //Relationships
    private Genre genre;

    //Builder

    /**
     * Song, builder of song <br/>
     * @param title string, contains the title of the song
     * @param author string, contains the name of the author of the song
     * @param releaseDate string, contains the release date of the song
     * @param minutes int, contains the minutes that last the song
     * @param seconds int, contains the seconds that last the song
     * @param genre string, contains the genre of the song
     */
    public Song(String title, String author, String releaseDate, int minutes, int seconds, String genre){
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.minutes = minutes;
        this.seconds = seconds;
        Genre aGenre = Genre.valueOf(genre);
        this.genre = aGenre;
    }

    /**
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     * @return
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * 
     * @param releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 
     * @return
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * 
     * @param genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * showSongs, show the info of the song <br/>
     * <b> Pre:<b/> The song is created <br/>
     * @return text, the info of the song
     */
    public String showSongs(){
        String text = "\n**************  Song **************\n"+
                      "** Title: "+ title + "\n"+
                      "** Artist: "+ author + "\n"+
                      "** Duration: "+ minutes + ";" + seconds + "\n"+
                      "** Genre: "+ genre + "\n"+
                      "***********************************\n";
        return text;
    }

    /**
     * 
     * @return
     */
    public int getMinutes() {
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
    public int getSeconds() {
        return seconds;
    }

    /**
     * 
     * @param seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
