package fact.it.startproject.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Apartment extends Property{
    private int floor;

    public Apartment() {}



    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    public String toString() {
        return "Apartment ("+getCode()+") on floor: "+getFloor()+" with "+getContractList().size()+" contract(s)";
    }
}
