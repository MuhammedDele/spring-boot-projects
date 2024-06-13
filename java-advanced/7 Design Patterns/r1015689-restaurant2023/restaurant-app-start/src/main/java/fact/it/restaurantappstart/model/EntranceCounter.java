package fact.it.restaurantappstart.model;

public class EntranceCounter extends Subject {
    private static EntranceCounter instance=null;
    private int number;



    private EntranceCounter() {}
    public static EntranceCounter getInstance() {
        if(instance==null) {
            instance=new EntranceCounter();
        }
        return instance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        notifyObservers();
    }

    @Override
    public void attachObserver(Staff observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(Staff observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for(Staff observer: observers){
            observer.update();
        }
    }
}
