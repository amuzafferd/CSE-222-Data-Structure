import java.util.LinkedList;
import static org.junit.Assert.*;

/**
 * Created by amd3 on 27.03.2018.
 */
public class GTUComEngCoursesPart1Test {

    GTUComEngCoursesPart1 part1 = new GTUComEngCoursesPart1();

    public GTUComEngCoursesPart1Test() throws Exception {
    }

    @org.junit.Test
    public void getByCode() throws Exception {

        assertEquals("3 - CSE 241 - Object Oriented Programming", part1.getByCode("CSE 241").get(0).toString());

    }

    @org.junit.Test
    public void listSemesterCourses() throws Exception {

        LinkedList<String> temp = new LinkedList<>();

        temp.add("8 - CSE 496 - Graduation Project II");
        temp.add("8 - CSE 4XX - Department Elective III");
        temp.add("8 - CSE 4XX - Bolum Secmeli IV");
        temp.add("8 - CSE 4XX - Bolum Secmeli (Temel Alan) Secmeli II");

        LinkedList<GTUComEngCourses> tempSemester = new LinkedList<>();
        tempSemester = part1.listSemesterCourses(8);

        for (int i = 0; i < tempSemester.size(); i++) {
            assertEquals(tempSemester.get(i).toString(), temp.get(i));
        }
    }

    @org.junit.Test
    public void getByRange() throws Exception {

        LinkedList<String> temp = new LinkedList<>();

        temp.add("1 - MATH 101 - Calculus I");
        temp.add("1 - PHYS 121 - Physics I");

        LinkedList<GTUComEngCourses> tempRange = new LinkedList<>();
        tempRange = part1.getByRange(3, 5);

        for (int i = 0; i < tempRange.size(); i++) {
            assertEquals(tempRange.get(i).toString(), temp.get(i));
        }
    }

}