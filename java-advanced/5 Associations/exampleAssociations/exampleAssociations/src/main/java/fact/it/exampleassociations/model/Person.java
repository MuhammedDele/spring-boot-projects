package fact.it.exampleassociations.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    private Passport passport;

    @ManyToOne
    private Team team;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Phone> phonenbrs=new ArrayList<Phone>();
    @ManyToMany
    @JoinTable(name = "coursestudent")
    private List<Course> courses=new ArrayList<>();

    public Person() {}

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Phone> getPhonenbrs() {
        return phonenbrs;
    }

    public void setPhonenbrs(List<Phone> phonenbrs) {
        this.phonenbrs = phonenbrs;
    }
    public void addPhonenbr(String type, String number) {
        Phone phone=new Phone();
        phone.setType(type);
        phone.setNumber(number);
        phonenbrs.add(phone);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public String toString() {
        return name;
    }

}
