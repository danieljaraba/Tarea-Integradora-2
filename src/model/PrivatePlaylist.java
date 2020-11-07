package model;

public class PrivatePlaylist extends Playlist{
    //ATRIBUTES
    private String user;

    //BUILDER
    public PrivatePlaylist(String user, String name){
        super(name);
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String showPlaylist(){
        String text = "\n**************  Privated Playlist **************\n"+
                      "**  Title: "+ super.getName() + "\n"+
                      "**  Duration: "+ super.getMinutes() + ":" + super.getSeconds() + "\n"+
                      "**  Genre: " + super.showGenre() + "\n"+
                      "**  User: " + user + "\n"+
                      "\n";
        return text;
    }
}
