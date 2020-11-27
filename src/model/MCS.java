package model;

/**
 * MCS
 * Is used to manage the program
 * @author danieljag
 */
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
    
    /**
     *Mcs, builder of Mcs <br/>
     */
    public Mcs(){
        users = new User[MAX_USERS];
        pool = new Song[MAX_SONGS];
        colection = new Playlist[MAX_PLAYLISTS];
    }

    /**
     * userHasSpace, checks if the array of users has space <br/>
     * <b> Pre:<b/> The array of users is initialized <br/>
     * @return space, boolean that indicates if there is or not space
     */
    public boolean userHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_USERS && space == false; i++){
            if(users[i] == null){
                space = true;
            }
        }
        return space;
    }

    /**
     * numOfUsers, count the amount of users <br/>
     * <b> Pre:<b/> The array of users is initialized and have atleast one user <br/>
     * @return number, the amount of users
     */
    public int numOfUsers(){
        int number = 0;
        for(int i = 0; i<MAX_USERS; i++){
            if(users[i] != null){
                number++;
            }
        }
        return number;
    }

    /**
     * songHasSpace, checks if the array of songs has space <br/>
     * <b> Pre:<b/> The array of songs is initialized <br/>
     * @return space, boolean that indicates if there is or not space
     */
    public boolean songHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_SONGS && space == false; i++){
            if(pool[i] == null){
                space = true;
            }
        }
        return space;
    }

    /**
     * numOfSongs, count the amount of songs <br/>
     * <b> Pre:<b/> The array of songs is initialized and have atleast one user <br/>
     * @return number, the amount of songs
     */
    public int numOfSongs(){
        int number = 0;
        for(int i = 0; i<MAX_SONGS; i++){
            if(pool[i] != null){
                number++;
            }
        }
        return number;
    }

    /**
     * playlistHasSpace, checks if the array of songs has space <br/>
     * <b> Pre:<b/> The array of playlists is initialized <br/>
     * @return space, boolean that indicates if there is or not space
     */
    public boolean playlistHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_PLAYLISTS && space == false; i++){
            if(colection[i] == null){
                space = true;
            }
        }
        return space;
    }

    /**
     * addUser, creates a new user and adds it to the array of users <br/>
     * <b> Pre:<b/> The array of playlists is initialized <br/>
     * @param userName String, contains the name of the user
     * @param password String, contains the password of the user
     * @param age int, contains the age of the user
     */
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

    /**
     * showUsers, return a string with the info of the users <br/>
     * <b> Pre:<b/> Atleast one user is created <br/>
     * @return showUsers, contains the info of the users
     */
    public String showUsers(){
        String text = "\n ------------- Users -------------\n \n";
        for(int i = 0; i<numOfUsers; i++){
            text += users[i].showUser() + "\n";
        }
        return text;
    }

    /**
     * showUsersName, return a string with the name of the users <br/>
     * <b> Pre:<b/> Atleast one user is created <br/>
     * @return text, contains the name of the users
     */
    public String showUsersName(){
        String text = "\n ------------- Users -------------\n \n";
        for(int i = 0; i<numOfUsers; i++){
            text += (i+1) + ". " + users[i].getUserName() + "\n";
        }
        return text;
    }

    /**
     * addSong, creates a new song and adds it to the array of songs <br/>
     * <b> Pre:<b/> The array of songs is initialized <br/>
     * @param indexUser int, contains the index of the user that is creating the song
     * @param title string, contains the title of the song
     * @param author string, contains the name of the author of the song
     * @param releaseDate string, contains the release date of the song
     * @param minutes int, contains the amount of minutes that last the song
     * @param seconds int, contains the amount of seconds that last the song
     * @param genre string, contains the genre of the song
     */
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

    /**
     * showSongs, show the info of all the songs <br/>
     * <b> Pre:<b/> Atleast one song is created <br/>
     * @return text, contains the info of the songs
     */
    public String showSongs(){
        String text = "\n ------------- Songs -------------\n \n";
        for(int i = 0; i<numOfSongs; i++){
            text += pool[i].showSongs() + "\n";
        }
        return text;
    }

    /**
     * addPublicPlaylist, creates a new public playlist and adds it to the playlists array <br/>
     * <b> Pre:<b/> The array of playlists is initialized <br/>
     * @param name string, contains the name of the playlist
     */
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

    /**
     * addPrivatePlaylist, creates a new private playlist and adds it to the playlists array <br/>
     * <b> Pre:<b/> The array of playlists is initialized <br/>
     * @param name string, contains the name of the playlist
     * @param userIndex int, contains the index of the user that is creating the playlist
     */
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

    /**
     * addRestringedPlaylist, creates a new restringed playlist and adds it to the playlists array <br/>
     * <b> Pre:<b/> The array of playlists is initialized <br/>
     * @param user1Index int, contains the index of the user 1 that is creating the playlist
     * @param user2Index int, contains the index of the user 2 that is creating the playlist
     * @param user3Index int, contains the index of the user 3 that is creating the playlist
     * @param user4Index int, contains the index of the user 4 that is creating the playlist
     * @param user5Index int, contains the index of the user 5 that is creating the playlist
     * @param name string, contains the name of the playlist
     */
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

    /**
     * showPlaylists, show the names of the playlists <br/>
     * <b> Pre:<b/> Atleast one playlist is created <br/>
     * @return text, contains the names of the playlists
     */
    public String showPlaylists(){
        String text = "\n";
        for(int i = 0; i<numOfPlaylists; i++){
            text += (i+1) + ". " + colection[i].getName() + "\n";
        }
        return text;
    }

    /**
     * qualifyPublic, qualify the public playlist <br/>
     * <b> Pre:<b/> The public playlist is created <br/>
     * @param playlistIndex int, contains the index of the playlist
     * @param grade double, contains the grade of the playlist
     */
    public void qualifyPublic(int playlistIndex, double grade){
        PublicPlaylist playlist = (PublicPlaylist)colection[playlistIndex];
        playlist.updateGrade(grade);
        colection[playlistIndex] = playlist;
    }

    /**
     * addSongToPlaylist, adds a song to a playlist <br/>
     * <b> Pre:<b/> The song and the playlist are created <br/>
     * @param songIndex int, contains the index of the song
     * @param playlistIndex int, contains the index of the playlist
     */
    public void addSongToPlaylist(int songIndex, int playlistIndex){
        Song song = pool[songIndex];
        colection[playlistIndex].addSong(song);
    }

    /**
     * showEntirePlaylists, show the info of the playlists <br/>
     * <b> Pre:<b/> Atleast one playlist is created <br/>
     * @return text, contains the info of the playlists
     */
    public String showEntirePlaylists(){
        String text = "\n--------------  Playlists --------------\n";
        for(int i = 0; i<numOfPlaylists; i++){
            text += colection[i].showPlaylist();
        }
        return text;
    }

    /**
     * showSongNames, show the names of the songs <br/>
     * <b> Pre:<b/> Atleast one song is created <br/>
     * @return text, contains the names of the songs
     */
    public String showSongNames(){
        String text = "\n-------------- Songs --------------\n";
        for(int i = 0; i<numOfSongs; i++){
            text += (i+1) + ". " + pool[i].getTitle() + "\n";
        }
        return text;
    }

    /**
     * isUserOnPlaylist, checks if the user is in the playlist <br/>
     * <b> Pre:<b/> The user and the playlist are created
     * @param indexUser int, contains the index of the user
     * @param indexPlaylist int, contains the index of the playlist
     * @return is, boolean that indicates if the user is or not in the playlist
     */
    public boolean isUserOnPlaylist(int indexUser, int indexPlaylist){
        String userName = users[indexUser].getUserName();
        boolean is = colection[indexPlaylist].isUser(userName);
        return is;
    }

}