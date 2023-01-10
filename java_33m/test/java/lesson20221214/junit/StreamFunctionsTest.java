package lesson20221214.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StreamFunctionsTest {

    private static StreamFunctions functions;

    @BeforeAll
    public static void init() {
        functions = new StreamFunctions();
    }

    @Test
    public void filterStringListWorks() {
        List<String> filteredList = functions.filterStringList(Arrays.asList("One"));
        System.out.println(filteredList); // For debug purpose only
        assertEquals("One", filteredList.get(0));
    }

    @Test
    public void filterStringListFiltersEmptyStrings() {
        List<String> filteredList = functions.filterStringList(Arrays.asList(""));
        assertTrue(filteredList.isEmpty());
        filteredList = functions.filterStringList(Arrays.asList("", "One"));
        assertTrue(filteredList.size() == 1);
        assertTrue(filteredList.contains("One"));
    }

    @Test
    public void filterStringListDoesntWorkWithNull() {
        assertThrows(NullPointerException.class, () -> functions.filterStringList(null));
    }

    @Test
    public void filterStringListWorksWithNullInList() {
        assertDoesNotThrow(() -> functions.filterStringList(Arrays.asList("One", null)));
    }


    @Test
    public void testStudentNames() {
        List<String> studentNames = functions.studentNames(Arrays.asList("Peter"));
        assertEquals("Student Peter", studentNames.get(0));
        assertDoesNotThrow(() -> functions.studentNames(Arrays.asList("", null)));
        studentNames = functions.studentNames(Arrays.asList("Peter", "Jane", "Peter", "Mark"));
        assertTrue(studentNames.size() == 3);
        studentNames = functions.studentNames(Arrays.asList("Peter", "Jane", "Peter", "Mark","", "   "));
        assertTrue(studentNames.size() == 3);
        studentNames = functions.studentNames(Arrays.asList("Peter", "Jane", "Peter", "Abragam"));
        assertEquals("Student Abragam", studentNames.get(0));
    }


}