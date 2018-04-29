import org.junit.Test;
import static org.junit.Assert.*;

public class GTUComEngCoursesPart2Test {

    GTUComEngCoursesPart1 part1 = new GTUComEngCoursesPart1();
    GTUComEngCoursesPart2 part2 = new GTUComEngCoursesPart2(part1.getAllCourses());

    public GTUComEngCoursesPart2Test() throws Exception {
    }

    @Test
    public void disable() throws Exception {

        assertEquals("1 - CSE 101 - Introduction To Computer Engineering", part2.disable(1));

    }

    @Test
    public void enable() throws Exception {

        assertEquals("1 - CSE 101 - Introduction To Computer Engineering", part2.disable(1));
        assertEquals("1 - CSE 101 - Introduction To Computer Engineering", part2.enable(0));

    }

}