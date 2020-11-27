package model;

/**
 * PrivatePlaylist
 * Is used to create a object of a private playlist
 * @author danieljag
 */
public class PrivatePlaylist extends Playlist{
    //ATRIBUTES
    private String user;

    //BUILDER
    /**
     * PrivatePlaylist, builder of PrivatePlaylist <br/>
     * @param user string, contains the user name that is creating the playlist
     * @param name string, contains the name of the playlist
     */
    public PrivatePlaylist(String user, String name){
        super(name);
        this.user = user;
    }

    /**
     * 
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     * 
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * isUser, checks if the user is in the playlist
     * <b> Pre:<b/> The playlist is created <br/>
     * @param user string, contains the name of the user
     * @return is, boolean that indicates if the user is or not in the playlist
     */
    @Override
    public boolean isUser(String user) {
        boolean is = false;
        if(user.equals(this.user)){
            is = true;
        }
        return is;
    }

    /**
     * showPlaylist, show the info of the playlist
     * <b> Pre:<b/> The playlist is created <br/>
     * @return text, contains the info of the playlist
     */
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
