package src.ui;
import src.model.Mcs;
import java.util.Scanner;

public class Main {
    //Relationships
    private Mcs manager;
    private Scanner sc;

    //Builder
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

    public void showMenu(){
        System.out.print("\n"+
                         "************* Menu *************\n"+
                         "(1) To create a new user.\n"+
                         "(2) Show the users list.\n"+
                         "(3) To add a new song.\n"+
                         "(4) To create a new playlist.\n"+
                         "(5) Show the songs list.\n"+
                         "\n"
                        );
    }

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
        }
    }

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

    public void showUserList(){
        System.out.print(manager.showUsers());
    }

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
        int length = (minutes*60)+seconds;
        String genre = askGenre();
        manager.addSong(index, title, author, releaseDate, length, genre);
    }

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

    public int askUser(){
        System.out.println("Select the user that is doing the action:");
        System.out.print(manager.showUsersName());
        int index = sc.nextInt();
        sc.nextLine();
        return index;
    }

    public void showSongList(){
        System.out.print(manager.showSongs());
    }

    public void createPlaylist(){
        System.out.println("");
        System.out.println("Welcome to the new playlist menu");
        System.out.println("Fill all the fields");
        System.out.print("Name: ");
        String name = sc.nextLine();
        manager.addPlaylist(name);
    }
}
