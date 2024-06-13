package fact.it.restaurantappstart.model;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Staff> observers;

    public Subject(){
        observers = new ArrayList<Staff>();
    }

    public List<Staff> getObservers() {
        return observers;
    }

    public void setObservers(List<Staff> observers) {
        this.observers = observers;
    }

    public abstract void attachObserver(Staff observer);
    public abstract void detachObserver(Staff observer);
    public abstract void notifyObservers();

}
