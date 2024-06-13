package fact.it.lambdaandstream.controller;

import fact.it.lambdaandstream.model.School;
import fact.it.lambdaandstream.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SchoolController {
    private School school;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("courses",school.getCourses());

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
