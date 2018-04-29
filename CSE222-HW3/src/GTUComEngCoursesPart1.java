import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;


public class GTUComEngCoursesPart1 {

    private LinkedList<GTUComEngCourses> allCourses;

    /**
     * @throws Exception
     */
    public GTUComEngCoursesPart1() throws Exception {
        this.allCourses = new LinkedList<GTUComEngCourses>();
        readFromFile();
    }

    /**
     * @return
     */
    public LinkedList<GTUComEngCourses> getAllCourses() {
        return allCourses;
    }

    /**
     * @throws Exception
     */
    private void readFromFile() throws Exception{
        File coursesFile = new File("courses.csv");

        if(coursesFile.exists()) {
            Scanner scannerForCourses = new Scanner(coursesFile).useDelimiter(";");
            while (scannerForCourses.hasNext()) {
                String[] parts = scannerForCourses.nextLine().split(";");
                allCourses.add(new GTUComEngCourses(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]));
            }
        }
        else
            throw new Exception("This file not found!");
    }

    /**
     * @param other
     * @throws Exception
     */
    public void printCourses(LinkedList<GTUComEngCourses> other) throws Exception{

        for(int i=0; i<other.size(); i++)
            System.out.println(other.get(i).getSemester() + " - " + other.get(i).getCourseCode() + " - " + other.get(i).getCourseName());
    }

    /**
     * @param code
     * @return
     * @throws Exception
     */
    public LinkedList<GTUComEngCourses> getByCode(String code) throws Exception{
        LinkedList<GTUComEngCourses> courseNames = new LinkedList<>();
        int count = 0;

        for (int i=0; i<allCourses.size(); i++){
            if (code.toUpperCase().equals(allCourses.get(i).getCourseCode())) {
                courseNames.add(allCourses.get(i));
                count++;
            }
        }

        if(count == 0)
            throw new Exception("The error in getByCode method. There is no lesson with this code.");

        return courseNames;
    }

    /**
     * @param semester
     * @return
     * @throws Exception
     */
    public LinkedList<GTUComEngCourses> listSemesterCourses(int semester) throws Exception{

        if(semester < 1 || semester > 8)
            throw new Exception("The error in listSemesterCourses method. Semester must be between 0 and 9");

        LinkedList<GTUComEngCourses> semesterCourses = new LinkedList<>();

        for (int i=0; i<allCourses.size(); i++){
            if (semester == Integer.parseInt(allCourses.get(i).getSemester().trim())) {
                semesterCourses.add(allCourses.get(i));
            }
        }

        return semesterCourses;
    }

    /**
     * @param start_index
     * @param last_index
     * @return
     * @throws Exception
     */
    public LinkedList<GTUComEngCourses> getByRange(int start_index, int last_index) throws Exception{

        if(start_index < 0 || start_index > allCourses.size())
            throw new Exception("The error in getByRange method. The start_index given is incorrect. Please check.");
        else if(last_index < 0 || last_index > allCourses.size())
            throw new Exception("The error in getByRange method. The last_index given is incorrect. Please check.");
        else if(start_index > last_index)
            throw new Exception("The error in getByRange method. start_index must be less than last_index.");

        LinkedList<GTUComEngCourses> allCoursesGivenRange = new LinkedList<>();

        for (int i = start_index; i < last_index; i++) {
            allCoursesGivenRange.add(allCourses.get(i));
        }

        return allCoursesGivenRange;
    }
}
