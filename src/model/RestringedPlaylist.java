package model;

public class RestringedPlaylist extends Playlist{
    //ATRIBUTES
    private String[] users;

    //BUILDER
    public RestringedPlaylist(String[] users, String name){
        super(name);
        this.users = users;
    }
    
}
