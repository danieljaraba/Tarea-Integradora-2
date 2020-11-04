package model;

public class Song {
    //Atributes
    private String title;
    private String author;
    private String releaseDate;
    private int length;

    //Relationships
    private Genre genre;

    //Builder
    public Song(String title, String author, String releaseDate, int length, String genre){
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.length = length;
        Genre aGenre = Genre.valueOf(genre);
        this.genre = aGenre;
    }
}
