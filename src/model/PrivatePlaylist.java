package model;

public class PrivatePlaylist extends Playlist{
    //ATRIBUTES
    private String user;

    //BUILDER
    public PrivatePlaylist(String user, String name){
        super(name);
        this.user = user;
    }
}
