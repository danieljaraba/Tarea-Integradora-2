package src.model;

public class PublicPlaylist extends Playlist{
    //ATRIBUTES
    private double grade;
    private int numOfGrades;

    //BUILDER
    public PublicPlaylist(String name){
        super(name);
        this.grade = 0;
        this.numOfGrades = 0;
    }

    /**
     * @return double return the grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }


    /**
     * @return int return the numOfGrades
     */
    public int getNumOfGrades() {
        return numOfGrades;
    }

    /**
     * @param numOfGrades the numOfGrades to set
     */
    public void setNumOfGrades(int numOfGrades) {
        this.numOfGrades = numOfGrades;
    }

    public void updateGrade(double grade){
        this.grade += grade;
        numOfGrades++;
    }

    public double showGrade(){
        double iGrade = grade/numOfGrades;
        return iGrade;
    }

    @Override
    public String showPlaylist(){
        String text = "\n**************  Playlist **************\n"+
                      "**  Title: "+ super.getName() + "\n"+
                      "**  Duration: "+ super.getMinutes() + ":" + super.getSeconds() + "\n"+
                      "**  Genre: " + super.showGenre() + "\n"+
                      "**  Rate: " + showGrade() + "\n"+
                      "\n";
        return text;
    }
}
