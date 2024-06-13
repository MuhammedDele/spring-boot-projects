package fact.it.startproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String location;
    private double memberfee;

    public Club(){

    }
    @OneToMany(mappedBy = "club")
    private List<Jogger> joggers= new ArrayList<Jogger>();

    @OneToMany(mappedBy = "club")
    private List<Event> events= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMemberfee() {
        return memberfee;
    }

    public void setMemberfee(double memberfee) {
        this.memberfee = memberfee;
    }

    public List<Jogger> getJoggers() {
        return joggers;
    }

    public void setJoggers(List<Jogger> joggers) {
        this.joggers = joggers;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public long getId() {
        return id;
    }
    public String toString(){
        return name;
    }
}
