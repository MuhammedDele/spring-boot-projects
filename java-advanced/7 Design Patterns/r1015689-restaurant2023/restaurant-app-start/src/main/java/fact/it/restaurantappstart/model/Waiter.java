package fact.it.restaurantappstart.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Staff{
    private String name;
    public Waiter(String name){
        super(name);
    }

    public Waiter() {

    }

    @Override
    public void update() {
        System.out.println("I am "+super.getName()+ " and I start preparing the table for "+EntranceCounter.getInstance().getNumber()+" customers.");
    }
//    private long id;
//    private String name;

//    @OneToMany(mappedBy = "waiter")
//    private List<Order> orders;
//    @Override
//    public long getId() {
//        return id;
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public void setName(String name) {
//        this.name=name;
//    }

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
}
