package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class House extends Property {
    private boolean townhouse;

    public House() {}

    public boolean isTownhouse() {
        return townhouse;
    }

    public void setTownhouse(boolean townhouse) {
        this.townhouse = townhouse;
    }
    public String toString() {
        if (townhouse) {
            return "Townhouse (" + getCode() + ") with " + getContractList().size() + " contract(s)";
        } else {
            return "Detached house (" + getCode() + ") with " + getContractList().size() + " contract(s)";
        }
    }
}
