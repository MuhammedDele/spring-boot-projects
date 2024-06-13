package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double currentPrice;

//    @OneToMany(mappedBy = "dish")
//    private List<OrderItem> orderItems;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }
}
