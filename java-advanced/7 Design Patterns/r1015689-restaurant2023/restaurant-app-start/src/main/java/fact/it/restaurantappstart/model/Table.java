package fact.it.restaurantappstart.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;

//    @OneToMany(mappedBy = "table")
//    private List<Order> orders;
    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
}
