package fact.it.lambdaandstream;

import fact.it.lambdaandstream.model.School;
import fact.it.lambdaandstream.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LambdaAndStreamApplicationTests {

    @Test
    public void testGetFilteredList() {
        School school = new School();

        // Example 1: Students with lastname contains “r” and firstname contains “a”
        List<Student> result1 = school.getFilteredList("r", "a", null, null, null);
        assertEquals(4, result1.size());

        // Example 2: Students older than 20 years and more than 2 courses
        List<Student> result2 = school.getFilteredList(null, null, 20, 2, null);
        assertEquals(4, result2.size());

        // Example 3: Students with Lastname containing a “u” and following the SQL Databases course
        List<Student> result3 = school.getFilteredList("u", null, null, null, "SQL Databases");
        assertEquals(4, result3.size());
    }

}
