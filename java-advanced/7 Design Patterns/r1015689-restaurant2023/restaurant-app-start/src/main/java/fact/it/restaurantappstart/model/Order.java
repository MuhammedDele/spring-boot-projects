package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate localDate;
    private boolean payed;


    @ManyToOne
    private Table table;

    @ManyToOne
    private Waiter waiter;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems= new ArrayList<OrderItem>();

    @Transient
    private PaymentStrategy paymentStrategy =new NormalPayment()    ;

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public long getId() {
        return id;
    }

    public LocalDate setDate() {
        return localDate;
    }

    public void setDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
    public void addItem(Dish dish, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setDish(dish);
        orderItem.setQuantity(quantity);
        orderItem.setAppliedPrice(paymentStrategy.getAppliedPrice(dish.getCurrentPrice()));
        orderItems.add(orderItem);
    }
    public double getTotal(){
        double total = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getQuantity() * orderItem.getAppliedPrice();
        }
        return total;
    }
}
