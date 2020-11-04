package src.model;

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

    /**
     * @return String return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return Category return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    public String showUser(){
        String user = "************* User *************\n"+
                      "** UserName: "+ userName + "\n"+
                      "** Age: "+ age + "\n"+
                      "** Category: "+ category + "\n"+
                      "********************************\n";
        return user;
    }
    
}
