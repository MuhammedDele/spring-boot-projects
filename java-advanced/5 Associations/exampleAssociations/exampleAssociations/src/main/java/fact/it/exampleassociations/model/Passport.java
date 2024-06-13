package fact.it.exampleassociations.model;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "passport")
    private Person person;

    public Passport(String passportnbr){
        this.passportnbr = passportnbr;
    }
    public Passport(){

    }

    private String passportnbr;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public String getPassportnbr() {
        return passportnbr;
    }
    public void setPassportnbr(String passportnbr) {
        this.passportnbr = passportnbr;
    }
}
