package model;

public class PublicPlaylist extends Playlist{
    //ATRIBUTES
    private double grade;

    //BUILDER
    public PublicPlaylist(double grade, String name){
        super(name);
        this.grade = grade;
    }
}
