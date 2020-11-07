package model;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

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

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
