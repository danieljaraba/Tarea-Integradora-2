package model;

/**
 * User, is used to create an object of user
 * @author danieljag
 */
public class User {
    //Atributes
    private String userName;
    private String password;
    private int age;
    private int songsShared;
    
    //Relationships
    private Category category;

    //Builder

    /**
     * User, builder of User
     * @param userName string, contains the user name
     * @param password string, contains the password
     * @param age int, contains the age of the user
     */
    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.category = Category.NEWBIE;
        this.songsShared = 0;
    }

    /**
     * 
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * 
     * @return
     */
    public int getSongsShared() {
        return songsShared;
    }

    /**
     * 
     * @param songsShared
     */
    public void setSongsShared(int songsShared) {
        this.songsShared = songsShared;
    }

    /**
     * showUser, shows the info of the user <br/>
     * <b> Pre:<b/> The user is created <br/>
     * @return user, info of the user
     */
    public String showUser(){
        String user = "************* User *************\n"+
                      "** UserName: "+ userName + "\n"+
                      "** Age: "+ age + "\n"+
                      "** Category: "+ category + "\n"+
                      "********************************\n";
        return user;
    }
    
    /**
     * addShared, increments the number of songs shared <br/>
     * <b> Pre:<b/> The user is created <br/>
     */
    public void addShared(){
        songsShared++;
    }

}
