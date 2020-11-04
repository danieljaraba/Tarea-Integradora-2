package model;

public class User {
    //Atributes
    private String userName;
    private String password;
    private int age;
    
    //Relationships
    private Category category;

    //Builder
    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.category = Category.NEWBIE;
    }
}
