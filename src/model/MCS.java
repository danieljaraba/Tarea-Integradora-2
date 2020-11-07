package model;

public class Mcs{
    //ATRIBUTES
    private int numOfSongs;
    private int numOfUsers;
    private int numOfPlaylists;

    //CONSTANTS
    public final int MAX_SONGS = 30;
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

    public void addUser(String userName, String password, int age){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_USERS && found == false; i++){
            if(users[i] == null){
                index = i;
                found = true;
            }
        }
        numOfUsers++;
        users[index] = new User(userName, password, age);
    }

    public String showUsers(){
        String text = "\n ------------- Users -------------\n \n";
        for(int i = 0; i<numOfUsers; i++){
            text += users[i].showUser() + "\n";
        }
        return text;
    }

    public String showUsersName(){
        String text = "\n ------------- Users -------------\n \n";
        for(int i = 0; i<numOfUsers; i++){
            text += (i+1) + ". " + users[i].getUserName() + "\n";
        }
        return text;
    }

    public void addSong(int indexUser, String title, String author, String releaseDate, int minutes, int seconds, String genre){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_SONGS && found == false; i++){
            if(pool[i] == null){
                index = i;
                found = true;
            }
        }
        pool[index] = new Song(title, author, releaseDate, minutes, seconds, genre);
        users[indexUser].addShared();
        switch(users[indexUser].getSongsShared()){
            case 3:
                users[indexUser].setCategory(Category.LCONTRIBUTOR);
            break;
            case 10:
                users[indexUser].setCategory(Category.MCONTRIBUTOR);
            break;
            case 30:
                users[indexUser].setCategory(Category.SCONTRIBUTOR);
            break;
        }
        numOfSongs++;
    }

    public String showSongs(){
        String text = "\n ------------- Songs -------------\n \n";
        for(int i = 0; i<numOfSongs; i++){
            text += pool[i].showSongs() + "\n";
        }
        return text;
    }

    public void addPublicPlaylist(String name){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_PLAYLISTS && found == false; i++){
            if(colection[i] == null){
                index = i;
                found = true;
            }
        }
        colection[index] = new PublicPlaylist(name);
        numOfPlaylists++;
    }

    public void addPrivatePlaylist(String name, int userIndex){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_PLAYLISTS && found == false; i++){
            if(colection[i] == null){
                index = i;
                found = true;
            }
        }
        String userName = users[userIndex].getUserName();
        colection[index] = new PrivatePlaylist(userName, name);
        numOfPlaylists++;
    }

    public void addRestringedPlaylist(int user1Index, int user2Index, int user3Index, int user4Index, int user5Index, String name){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<MAX_PLAYLISTS && found == false; i++){
            if(colection[i] == null){
                index = i;
                found = true;
            }
        }
        String user1 = users[user1Index].getUserName();
        String user2 = users[user2Index].getUserName();
        String user3 = users[user3Index].getUserName();
        String user4 = users[user4Index].getUserName();
        String user5 = users[user5Index].getUserName();
        colection[index] = new RestringedPlaylist(user1, user2, user3, user4, user5, name);
        numOfPlaylists++;
    }

    public String showPlaylists(){
        String text = "\n";
        for(int i = 0; i<numOfPlaylists; i++){
            text += (i+1) + ". " + colection[i].getName() + "\n";
        }
        return text;
    }

    public void qualifyPublic(int playlistIndex, double grade){
        PublicPlaylist playlist = (PublicPlaylist)colection[playlistIndex];
        playlist.updateGrade(grade);
        colection[playlistIndex] = playlist;
    }

    public void addSongToPlaylist(int songIndex, int playlistIndex){
        Song song = pool[songIndex];
        colection[playlistIndex].addSong(song);
    }

    public String showEntirePlaylists(){
        String text = "\n--------------  Playlists --------------\n";
        for(int i = 0; i<numOfPlaylists; i++){
            text += colection[i].showPlaylist();
        }
        return text;
    }

    public String showSongNames(){
        String text = "\n-------------- Songs --------------\n";
        for(int i = 0; i<numOfSongs; i++){
            text += (i+1) + ". " + pool[i].getTitle() + "\n";
        }
        return text;
    }

}