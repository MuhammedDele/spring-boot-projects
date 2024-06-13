package fact.it.lambdaandstream.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    private List<Course> courses;
    private List<Student> students;

    public School(){
        Course programmerI = new Course("Programmer I", 5);
        Course sqlDatabases = new Course("SQL Databases", 3);
        Course linux = new Course("Linux", 8);
        courses = Arrays.asList(programmerI, sqlDatabases, linux);

        students = Arrays.asList(
                new Student("Amber", "Akkermans", 21, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Bert", "Bergmans", 18, Arrays.asList(linux)),
                new Student("Carly", "Coopman", 25, Arrays.asList(programmerI, linux)),
                new Student("Dirk", "Dieltjens", 19, Arrays.asList(programmerI, sqlDatabases)),
                new Student("Erik", "Eyken", 17, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Fré", "Frederickx", 23, Arrays.asList(linux)),
                new Student("Gust", "Grevers", 20, Arrays.asList(sqlDatabases, linux)),
                new Student("Hans", "Hooimans", 22, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Isis", "Ilsen", 19, Arrays.asList(sqlDatabases, linux)),
                new Student("Joris", "Jonkers", 25, Arrays.asList(programmerI, linux)),
                new Student("Kim", "Keuppens", 31, Arrays.asList(programmerI)),
                new Student("Laura", "Liekens", 21, Arrays.asList(sqlDatabases)),
                new Student("Merel", "Meulemans", 18, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Nele", "Nauwelaers", 19, Arrays.asList(linux)),
                new Student("Oscar", "Oppens", 18, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Pieter", "Peters", 21, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Quinten", "Qwards", 22, Arrays.asList(sqlDatabases, linux)),
                new Student("Rik", "Rubens", 20, Arrays.asList(programmerI, sqlDatabases)),
                new Student("Stef", "Stekker", 20, Arrays.asList(programmerI)),
                new Student("Toon", "Timmers", 21, Arrays.asList(programmerI, linux)),
                new Student("Ursula", "Uyterhoeven", 22, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Viktor", "Van der Veken", 20, Arrays.asList(programmerI, linux)),
                new Student("Wim", "Winkers", 21, Arrays.asList(programmerI)),
                new Student("Xanty", "Xanders", 19, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Yael", "Ysebaert", 18, Arrays.asList(linux)),
                new Student("Zuster", "Zulma", 22, Arrays.asList(sqlDatabases, linux))
        );

    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public List<Student> getFilteredList(String lname, String fname, Integer age, Integer numberOfCourses, String course) {
        Stream<Student> filteredList = students.stream();

        if (lname != null && !lname.isEmpty()) {
            filteredList = filteredList.filter(s -> s.getLastName().contains(lname));
        }

        if (fname != null && !fname.isEmpty()) {
            filteredList = filteredList.filter(s -> s.getFirstName().contains(fname));
        }

        if (age != null) {
            filteredList = filteredList.filter(s -> s.getAge() > age);
        }

        if (numberOfCourses != null) {
            filteredList = filteredList.filter(s -> s.getCourses().size() > numberOfCourses);
        }

        if (course != null && !course.isEmpty()) {
            filteredList = getFilteredOnCourse(filteredList, course);
        }

        return filteredList.collect(Collectors.toList());
    }
    private Stream<Student> getFilteredOnCourse(Stream<Student> filteredList, String course) {
        return filteredList.filter(s -> s.getCourses().stream().anyMatch(c -> c.getName().equalsIgnoreCase(course)));
    }

}
