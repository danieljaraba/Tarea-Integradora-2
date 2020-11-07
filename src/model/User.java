package model;

public class User {
    //Atributes
    private String userName;
    private String password;
    private int age;
    private int songsShared;
    
    //Relationships
    private Category category;

    //Builder
    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.category = Category.NEWBIE;
        this.songsShared = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getSongsShared() {
        return songsShared;
    }

    public void setSongsShared(int songsShared) {
        this.songsShared = songsShared;
    }

    public String showUser(){
        String user = "************* User *************\n"+
                      "** UserName: "+ userName + "\n"+
                      "** Age: "+ age + "\n"+
                      "** Category: "+ category + "\n"+
                      "********************************\n";
        return user;
    }
    
    public void addShared(){
        songsShared++;
    }

}
