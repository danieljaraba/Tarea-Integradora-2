package ui;
import model.Mcs;
import java.util.Scanner;

/**
 * Method Main
 * @author danieljag
 */
public class Main {
    //Relationships
    private Mcs manager;
    private Scanner sc;

    //Builder

    /**
     * Main, builder of Main <br/>
     */
    public Main(){
        sc = new Scanner(System.in);
        manager = new Mcs();
    }

    public static void main(String[] args) {
        Main main = new Main();
        int option = 0;

        do{
            main.showMenu();
            option = main.sc.nextInt();
            main.sc.nextLine();
            main.executeOperation(option);
        } while(option != 0);
    }

    /**
     * showMenu, show the menu of options <br/>
     * <b> Pre:<b/> The object sc is defined <br/>
     */
    public void showMenu(){
        System.out.print("\n"+
                         "************* Menu *************\n"+
                         "(1) To create a new user.\n"+
                         "(2) Show the users list.\n"+
                         "(3) To add a new song.\n"+
                         "(4) To create a new playlist.\n"+
                         "(5) Show the songs list.\n"+
                         "(6) To qualify a public playlist.\n"+
                         "(7) To add a song to a playlist.\n"+
                         "(8) To show all playlists.\n"+
                         "\n"
                        );
    }

    /**
     * executeOperation, executes the option choosed <br/>
     * @param option int, contains the option choosed <br/>
     */
    public void executeOperation(int option){
        switch(option){
            case 1:
                createUser();
            break;
            case 2:
                showUserList();
            break;
            case 3:
                createSong();
            break;
            case 4:
                createPlaylist();
            break;
            case 5:
                showSongList();
            break;
            case 6:
                qualifyPublicPlaylist();
            break;
            case 7:
                addSongToPlaylist();
            break;
            case 8:
                showAllPlaylists();
            break;
        }
    }

    /**
     * createUser, creates one object of the class User <br/>
     * <b> Pre:<b/> The object sc is defined <br/>
     */
    public void createUser(){
        System.out.println("");
        System.out.println("Welcome to the new user menu");
        System.out.println("Fill all the fields");
        System.out.print("Username: ");
        String userName = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        manager.addUser(userName, password, age);
    }

    /**
     * showUserList, prints the name of the users <br/>
     * <b> Pre:<b/> The object manager is defined <br/>
     */
    public void showUserList(){
        System.out.print(manager.showUsers());
    }

    /**
     * createSong, creates an object of the class Song <br/>
     * <b> Pre:<b/> The objects sc and manager are defined <br/>
     */
    public void createSong(){
        System.out.println("");
        System.out.println("Welcome to the new song menu");
        int index = askUser();
        System.out.println("Fill all the fields");
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Release date: ");
        String releaseDate = sc.nextLine();
        System.out.print("Minutes length: ");
        int minutes = sc.nextInt();
        sc.nextLine();
        System.out.print("Seconds length: ");
        int seconds = sc.nextInt();
        sc.nextLine();
        String genre = askGenre();
        manager.addSong(index, title, author, releaseDate, minutes, seconds, genre);
    }

    /**
     * askGenre, ask the genre of the song to the user <br/>
     * <b> Pre:<b/> The object sc is defined <br/>
     * @return genre, the genre of the song
     */
    public String askGenre(){
        String genre = "";
        System.out.println("Select the genre of the song:");
        System.out.print("\n (1) Rock\n"+
                         "(2) Hip hop\n"+
                         "(3) Classic\n"+
                         "(4) Reggae\n"+
                         "(5) Sauce\n"+
                         "(6) Metal\n"
                        );
        int option = sc.nextInt();
        sc.nextLine();
        switch(option){
            case 1:
                genre = "ROCK";
            break;
            case 2:
                genre = "HIPHOP";
            break;
            case 3:
                genre = "CLASSIC";
            break;
            case 4:
                genre = "REGGAE";
            break;
            case 5:
                genre = "SAUCE";
            break;
            case 6:
                genre = "METAL";
            break;
        }
        return genre;
    }

    /**
     * askUser, asks the index of the user that is doing the action <br/>
     * <b> Pre:<b/> The object sc is defined <br/>
     * @return index-1, index of the user
     */
    public int askUser(){
        System.out.println("Select the user that is doing the action:");
        System.out.print(manager.showUsersName());
        int index = sc.nextInt();
        sc.nextLine();
        return index-1;
    }

    /**
     * askRestringedUser, asks the index of the restringed user that is doing the action <br/>
     * <b> Pre:<b/> The objects sc and manager are defined <br/>
     * @return index-1, index of the user
     */
    public int askRestringedUser(){
        System.out.print(manager.showUsersName());
        int index = sc.nextInt();
        sc.nextLine();
        return index-1;
    }

    /**
     * askPlaylist, asks the index of the playlist to the user <br/>
     * <b> Pre:<b/> The objects manager and sc are defined <br/>
     * @return option-1, index of the playlist
     */
    public int askPlaylist(){
        System.out.println("Select the playlist to do the action:");
        System.out.print(manager.showPlaylists());
        int option = sc.nextInt();
        sc.nextLine();
        return option-1;
    }

    /**
     * askSong, asks the index of the song to the user <br/>
     * <b> Pre:<b/> The objects sc and manager are defined <br/>
     * @return option-1, index of the song
     */
    public int askSong(){
        System.out.println("Select the song to do the action:");
        System.out.print(manager.showSongNames());
        int option = sc.nextInt();
        sc.nextLine();
        return option-1;
    }

    /**
     * showSongList, prints the names of the songs <br/>
     * <b> Pre:<b/> The object manager is defined <br/>
     */
    public void showSongList(){
        System.out.print(manager.showSongs());
    }

    /**
     * createPlaylist, creates a playlist
     */
    public void createPlaylist(){
        System.out.println("");
        System.out.println("Welcome to the new playlist menu");
        System.out.println("Fill all the fields");
        selectType();
        
    }

    /**
     * selectType, asks the type of playlist to the user <br/>
     * <b> Pre:<b/> The object sc is defined <br/>
     */
    public void selectType(){
        System.out.println("Select the type of playlist:");
        System.out.print("\n 1. Public playlist\n 2. Restringed playlist \n 3. Privated playlist\n");
        int option = sc.nextInt();
        sc.nextLine();
        switch(option){
            case 1:
                createPublicPlaylist();
            break;
            case 2:
                createRestringedPlaylist();
            break;
            case 3:
                createPrivatePlaylist();
            break;
        }
    }

    /**
     * createPublicPlaylist, creates a new public playlist <br/>
     * <b> Pre:<b/> The objects sc and manager are defined <br/>
     */
    public void createPublicPlaylist(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        manager.addPublicPlaylist(name);
    }

    /**
     * createPrivatePlaylist, creates a new private playlist <br/>
     * <b> Pre:<b/> The objects sc and manager are defined <br/>
     */
    public void createPrivatePlaylist(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        int userIndex = askUser();
        manager.addPrivatePlaylist(name, userIndex);
    }

    /**
     * createRestringedPlaylist, creates a new restringed playlist <br/>
     * <b> Pre:<b/> The objects sc and manager are defined <br/>
     */
    public void createRestringedPlaylist(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        int user1Index = askUser();
        System.out.println("Select the second user:");
        int user2Index = askRestringedUser();
        System.out.println("Select the third user:");
        int user3Index = askRestringedUser();
        System.out.println("Select the fourth user:");
        int user4Index = askRestringedUser();
        System.out.println("Select the fifth user:");
        int user5Index = askRestringedUser();
        manager.addRestringedPlaylist(user1Index, user2Index, user3Index, user4Index, user5Index, name);
    }

    /**
     * qualifyPublicPlaylist, qualifies a public playlist <br/>
     * <b> Pre:<b/> The public playlist is created <br/>
     */
    public void qualifyPublicPlaylist(){
        System.out.println("Fill all the fields:");
        int user = askUser();
        int playlistIndex = askPlaylist();
        System.out.print("Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine();
        manager.qualifyPublic(playlistIndex, grade);
    }

    /**
     * addSongToPlaylist, adds a song to a playlist <br/>
     * <b> Pre:<b/> The objects sc and manager are defined <br/>
     */
    public void addSongToPlaylist(){
        System.out.println("Select the options:");
        int userIndex = askUser();
        int songIndex = askSong();
        int playlistIndex = askPlaylist();
        boolean isUser = manager.isUserOnPlaylist(userIndex, playlistIndex);
        if(isUser == true){
            manager.addSongToPlaylist(songIndex, playlistIndex);
        }
        else{
            System.out.println("The user doesn't have access to the playlist.");
        }
    }

    /**
     * showAllPlaylist, prints the info of all the playlists <br/>
     * <b> Pre:<b/> The object manager is defined <br/>
     */
    public void showAllPlaylists(){
        System.out.print(manager.showEntirePlaylists());
    }
}
