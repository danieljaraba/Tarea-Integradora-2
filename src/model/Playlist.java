package model;

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
}
