package model;

/**
 * PublicPlaylist, is used to create an object of a public playlist
 * @author danieljag
 */
public class PublicPlaylist extends Playlist{
    //ATRIBUTES
    private double grade;
    private int numOfGrades;

    //BUILDER

    /**
     * PublicPlaylist, builder of PublicPlaylist <br/>
     * @param name string, contains the name of the playlist <br/>
     */
    public PublicPlaylist(String name){
        super(name);
        this.grade = 0;
        this.numOfGrades = 0;
    }

    /**
     * 
     * @return
     */
    public double getGrade() {
        return grade;
    }

    /**
     * 
     * @param grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * 
     * @return
     */
    public int getNumOfGrades() {
        return numOfGrades;
    }

    /**
     * 
     * @param numOfGrades
     */
    public void setNumOfGrades(int numOfGrades) {
        this.numOfGrades = numOfGrades;
    }

    /**
     * updateGrade, updates the grade of the public playlist <br/>
     * <b> Pre:<b/> The public playlist is created <br/>
     * @param grade double, contains the new grade for the playlist
     */
    public void updateGrade(double grade){
        this.grade += grade;
        numOfGrades++;
    }

    /**
     * showGrade, shows the grade of the public playlist <br/>
     * <b> Pre:<b/> The public playlist have atleast one grade <br/>
     * @return iGrade double, contains the prom of the grades
     */
    public double showGrade(){
        double iGrade = grade/numOfGrades;
        return iGrade;
    }

    /**
     * showPlaylist, shows the info of the public playlist <br/>
     * <b> Pre:<b/> The public playlist is created <br/>
     * @return text, contains the info of the playlist
     */
    @Override
    public String showPlaylist(){
        String text = "\n**************  Public Playlist **************\n"+
                      "**  Title: "+ super.getName() + "\n"+
                      "**  Duration: "+ super.getMinutes() + ":" + super.getSeconds() + "\n"+
                      "**  Genre: " + super.showGenre() + "\n"+
                      "**  Rate: " + showGrade() + "\n"+
                      "\n";
        return text;
    }
}
