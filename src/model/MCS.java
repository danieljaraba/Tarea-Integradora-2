package model;

public class MCS{
    //CONSTANTS
    public final int MAX_SONGS = 30;
    public final int MAX_GENRES = 6;
    public final int MAX_USERS = 10;
    public final int MAX_PLAYLISTS = 20;

    //RELATIONSHIPS
    private User[] users;
    private Song[] pool;
    private Playlist[] colection;

    //BUILDER
    public MCS(){
        users = new User[MAX_USERS];
        pool = new Song[MAX_SONGS];
        colection = new Playlist[MAX_PLAYLISTS];
    }
}