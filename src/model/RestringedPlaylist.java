package src.model;

public class RestringedPlaylist extends Playlist{
    //ATRIBUTES
    private String[] users;

    //BUILDER
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

    public String showUsers(){
        String text = "";
        for(int i = 0; i<5 ; i++){
            text += users[i] + ", ";
        }
        return text;
    }

    @Override
    public String showPlaylist(){
        String text = "\n**************  Playlist **************\n"+
                      "**  Title: "+ super.getName() + "\n"+
                      "**  Duration: "+ super.getMinutes() + ":" + super.getSeconds() + "\n"+
                      "**  Genre: " + super.showGenre() + "\n"+
                      "**  Users: " + showUsers() + "\n"+
                      "\n";
        return text;
    }
}
