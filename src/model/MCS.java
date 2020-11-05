package src.model;

public class Mcs{
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
    public Mcs(){
        users = new User[MAX_USERS];
        pool = new Song[MAX_SONGS];
        colection = new Playlist[MAX_PLAYLISTS];
    }

    public boolean userHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_USERS && space == false; i++){
            if(users[i] == null){
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

    public boolean songHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_SONGS && space == false; i++){
            if(pool[i] == null){
                space = true;
            }
        }
        return space;
    }

    public int numOfSongs(){
        int number = 0;
        for(int i = 0; i<MAX_SONGS; i++){
            if(pool[i] != null){
                number++;
            }
        }
        return number;
    }


    public boolean playlistHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_PLAYLISTS && space == false; i++){
            if(colection[i] == null){
                space = true;
            }
        }
        return space;
    }

    public int numOfPlaylists(){
        int number = 0;
        for(int i = 0; i<MAX_PLAYLISTS; i++){
            if(colection[i] != null){
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
        String text = "\n ------------- Users -------------\n \n";
        for(int i = 0; i<numOfUsers(); i++){
            text += users[i].showUser() + "\n";
        }
        return text;
    }

    public String showUsersName(){
        String text = "\n ------------- Users -------------\n \n";
        for(int i = 0; i<numOfUsers(); i++){
            text += (i+1) + ". " + users[i].getUserName() + "\n";
        }
        return text;
    }

    public void addSong(int indexUser, String title, String author, String releaseDate, int length, String genre){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_SONGS && found == false; i++){
            if(pool[i] == null){
                index = i;
                found = true;
            }
        }
        pool[index] = new Song(title, author, releaseDate, length, genre);
        users[indexUser-1].addShared();
        switch(users[indexUser-1].getSongsShared()){
            case 3:
                users[indexUser-1].setCategory(Category.LCONTRIBUTOR);
            break;
            case 10:
                users[indexUser-1].setCategory(Category.MCONTRIBUTOR);
            break;
            case 30:
                users[indexUser-1].setCategory(Category.SCONTRIBUTOR);
        }
    }

    public String showSongs(){
        String text = "\n ------------- Songs -------------\n \n";
        for(int i = 0; i<numOfSongs(); i++){
            text += pool[i].showSongs() + "\n";
        }
        return text;
    }

    public void addPlaylist(String name){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_PLAYLISTS && found == false; i++){
            if(colection[i] == null){
                index = i;
                found = true;
            }
        }
        colection[index] = new Playlist(name);
    }

}