package src.model;

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

    public boolean userHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_USERS && space == false; i++){
            if(users[i]==null){
                space = true;
            }
        }
        return space;
    }

    public int numOfUsers(){
        int number = 0;
        for(int i = 0; i<MAX_USERS; i++){
            if(users[i] != null){
                number++;
            }
        }
        return number;
    }

    public void addUser(String userName, String password, int age){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_USERS && found == false; i++){
            if(users[i] == null){
                index = i;
                found = true;
            }
        }
        users[index] = new User(userName, password, age);
    }

    public String showUsers(){
        String text = "------------- Users -------------\n \n";
        for(int i = 0; i<numOfUsers(); i++){
            text += users[i].showUser() + "\n";
        }
        return text;
    }
}