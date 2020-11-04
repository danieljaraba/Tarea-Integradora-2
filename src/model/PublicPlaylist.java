package src.model;

public class PublicPlaylist extends Playlist{
    //ATRIBUTES
    private double grade;

    //BUILDER
    public PublicPlaylist(double grade, String name){
        super(name);
        this.grade = grade;
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

}
