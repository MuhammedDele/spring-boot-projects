package fact.it.startproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Jogger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int bibNumber;
    private String name;
    private int yearOfBirth;
    private String location;
    @Embedded
    private Time time;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Club club;

    public Jogger(){

    }


    public int getBibNumber() {
        return bibNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }


    public long getId() {
        return id;
    }

}
