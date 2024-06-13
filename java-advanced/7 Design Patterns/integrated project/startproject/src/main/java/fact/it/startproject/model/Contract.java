package fact.it.startproject.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private int rentalPrice;
    private boolean active;

    public Contract() {}

    @ManyToOne
    private Property property;

    @ManyToOne
    private Tenant tenant;

    public long getId() {
        return id;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isActive() {

        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
