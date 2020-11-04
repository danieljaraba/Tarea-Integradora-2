package src.ui;
import src.model.MCS;
import java.util.Scanner;

public class Main {
    //Relationships
    private MCS manager;
    private Scanner sc;

    //Builder
    public Main(){
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int option = 0;

        do{
            main.showMenu();
        } while(option != 0);
    }

    public void showMenu(){
        System.out.print("\n"+
                         "************* Menu *************\n"+
                         "(1) To create a new user.\n"+
                         "(2) Show the users list.\n"+
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
}
