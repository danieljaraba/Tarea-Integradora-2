package src.model;

public class RestringedPlaylist extends Playlist{
    //ATRIBUTES
    private String[] users;

    //BUILDER
    public RestringedPlaylist(String[] users, String name){
        super(name);
        this.users = users;
    }
    
    /**
     * @return String[] return the users
     */
    public String[] getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(String[] users) {
        this.users = users;
    }

}
