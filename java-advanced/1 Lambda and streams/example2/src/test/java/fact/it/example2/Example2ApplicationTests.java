package fact.it.example2;

import fact.it.example2.Models.School;
import fact.it.example2.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Example2ApplicationTests {

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
