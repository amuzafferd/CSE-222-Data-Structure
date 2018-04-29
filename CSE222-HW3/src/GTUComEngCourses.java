public class GTUComEngCourses {

    private String semester;
    private String courseCode;
    private String courseName;
    private String ECTSCredits;
    private String GTUCredits;
    private String HTL;

    public GTUComEngCourses(String semester, String courseCode, String courseName, String ECTSCredits, String GTUCredits, String HTL) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.ECTSCredits = ECTSCredits;
        this.GTUCredits = GTUCredits;
        this.HTL = HTL;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getECTSCredits() {
        return ECTSCredits;
    }

    public String getGTUCredits() {
        return GTUCredits;
    }

    public String getHTL() {
        return HTL;
    }

    @Override
    public String toString() {
        return semester + " - " + courseCode + " - " + courseName;
    }
}
