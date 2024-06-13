package fact.it.example2.controller;
import fact.it.example2.Models.Course;
import fact.it.example2.Models.School;
import fact.it.example2.Models.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype. Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation. RequestMapping;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Controller
public class MainController {
    private School school = new School();
    @RequestMapping("/")
    public String index(Model model){
//        School school = new School();
        List<Course> courses = school.getCourses();
        model.addAttribute("courses",courses);

        return "index";
    }
    @RequestMapping("/students")
    public String getStudents(HttpServletRequest request, Model model){
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Integer numberOfCourses = Integer.parseInt(request.getParameter("numberOfCourses"));
        String course = request.getParameter("course");
        List<Student> students = school.getFilteredList(lastName,firstName,age,numberOfCourses,course);
        model.addAttribute("students",students);
        return "students";
    }

}
