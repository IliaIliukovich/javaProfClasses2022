package lesson20230220.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilterStudentTest {

    @Test
    public void filterStudent() {
        FilterStudent student = new FilterStudent();

        List<String> filteredStudent = student.filterStudent(Arrays.asList("Peter", "Jane", "Mary"));
        for (String s : filteredStudent) {
            assertNotNull(student);
            assertNotEquals("", s);
            assertEquals("Student ", s.substring(0,8));
        }

        filteredStudent = student.filterStudent(Arrays.asList(null, "", "Mary"));
        for (String s : filteredStudent) {
            assertNotNull(student);
            assertNotEquals("", s);
            assertEquals("Student ", s.substring(0,8));
        }

    }
}