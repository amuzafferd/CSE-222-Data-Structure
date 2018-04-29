import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class GTUComEngCoursesPart3Test {

    GTUComEngCoursesPart3 part3 = new GTUComEngCoursesPart3();

    @Test
    public void next() throws Exception {

        LinkedList<String> tempStrings = new LinkedList<>();

        part3.add(new GTUComEngCourses("8", "CSE 444", "Bilgisayar Aglari","5", "3", "2+0+0"));
        part3.add(new GTUComEngCourses("8", "CSE 241", "Nesneye Dayali Programlama", "6", "4", "3+1+0"));
        part3.add(new GTUComEngCourses("9", "CSE 900", "Oryantasyon", "6", "4", "3+1+0"));

        while (part3.hasNext())
            tempStrings.add(part3.next().toString());

        assertEquals("8 - CSE 444 - Bilgisayar Aglari", tempStrings.get(0));

    }

    @Test
    public void nextInSemester() throws Exception {

        part3.add(new GTUComEngCourses("8", "CSE 444", "Bilgisayar Aglari","5", "3", "2+0+0"));
        part3.add(new GTUComEngCourses("8", "CSE 241", "Nesneye Dayali Programlama", "6", "4", "3+1+0"));
        part3.add(new GTUComEngCourses("9", "CSE 900", "Oryantasyon", "6", "4", "3+1+0"));

        assertEquals("8 - CSE 241 - Nesneye Dayali Programlama", part3.nextInSemester().toString());

    }

    @Test
    public void size() throws Exception {

        part3.add(new GTUComEngCourses("8", "CSE 444", "Bilgisayar Aglari","5", "3", "2+0+0"));
        part3.add(new GTUComEngCourses("8", "CSE 241", "Nesneye Dayali Programlama", "6", "4", "3+1+0"));
        part3.add(new GTUComEngCourses("9", "CSE 900", "Oryantasyon", "6", "4", "3+1+0"));

        assertEquals(3, part3.size());

    }

}