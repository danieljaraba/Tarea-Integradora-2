package model;

/**
 * RestringedPlaylist, is used to create an object of restringed playlist
 * @author danieljag
 */
public class RestringedPlaylist extends Playlist{
    //ATRIBUTES
    private String[] users;

    //BUILDER

    /**
     * RestringedPlaylist, builder of restringed playlist <br/>
     * @param user1 string, contains the name of the first user
     * @param user2 string, contains the name of the second user
     * @param user3 string, contains the name of the third user
     * @param user4 string, contains the name of the fourth user
     * @param user5 string, contains the name of the fifth user
     * @param name string, contains the name of the playlist
     */
    public RestringedPlaylist(String user1, String user2, String user3, String user4, String user5, String name){
        super(name);
        this.users = new String[5];
        users[0] = user1;
        users[1] = user2;
        users[2] = user3;
        users[3] = user4;
        users[4] = user5;
    }

    /**
     * 
     * @return
     */
    public String[] getUsers() {
        return users;
    }

    /**
     * 
     * @param users
     */
    public void setUsers(String[] users) {
        this.users = users;
    }

    /**
     * showUsers, shows the info of the users <br/>
     * <b> Pre:<b/> The restringed playlist is created <br/>
     * @return text, contains the info of the users
     */
    public String showUsers(){
        String text = "";
        for(int i = 0; i<5 ; i++){
            text += users[i] + ", ";
        }
        return text;
    }

    /**
     * isUser, checks if the user is in the playlist <br/>
     * <b> Pre:<b/> The restringed playlist is created <br/>
     * @param user string, contains the name of the user
     * @return is, boolean that indicates if the user is or not in the playlist
     */
    @Override
    public boolean isUser(String user) {
        boolean is = false;
        for(int i = 0; i<5; i++){
            if(users[i] == user){
                is = true;
            }
        }
        return is;
    }

    /**
     * showPlaylist, show the info of the restringed playlist <br/>
     * <b> Pre:<b/> The restringed playlist is created <br/>
     * @return text, the info of the playlist
     */
    @Override
    public String showPlaylist(){
        String text = "\n**************  Restringed Playlist **************\n"+
                      "**  Title: "+ super.getName() + "\n"+
                      "**  Duration: "+ super.getMinutes() + ":" + super.getSeconds() + "\n"+
                      "**  Genre: " + super.showGenre() + "\n"+
                      "**  Users: " + showUsers() + "\n"+
                      "\n";
        return text;
    }
}
