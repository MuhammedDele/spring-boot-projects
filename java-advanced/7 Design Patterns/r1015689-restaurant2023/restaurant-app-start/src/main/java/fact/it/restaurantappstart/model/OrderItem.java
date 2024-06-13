package fact.it.restaurantappstart.model;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int quantity;
    private double appliedPrice;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Dish dish;

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAppliedPrice() {
        return appliedPrice;
    }

    public void setAppliedPrice(double appliedPrice) {
        this.appliedPrice = appliedPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
