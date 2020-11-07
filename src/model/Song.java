package src.model;

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
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return String return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return Genre return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

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
     * @return int return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * @return int return the seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * @param seconds the seconds to set
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
