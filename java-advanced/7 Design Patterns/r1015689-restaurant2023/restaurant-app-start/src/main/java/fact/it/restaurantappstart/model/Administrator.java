package fact.it.restaurantappstart.model;

public class Administrator extends ExtraTask{
    public Administrator(){}
    public Administrator(Staff staff){
        super(staff);
    }

    @Override
    public void update() {
        super.update();
        System.out.println("Next, I register the " + EntranceCounter.getInstance().getNumber() + " customers in the customer file.");
    }
}
