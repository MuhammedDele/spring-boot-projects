package fact.it.restaurantappstart.model;

import javax.persistence.Entity;

@Entity
public class KitchenStaff extends Staff{
    private String name;

    public KitchenStaff(String name){
        super(name);
    }

    public KitchenStaff() {

    }

    @Override
    public void update() {
        System.out.println("I am "+super.getName()+" and I start now with preparing "+EntranceCounter.getInstance().getNumber()+" appetizers!");
    }
}
