package fact.it.restaurantappstart.model;

public abstract class ExtraTask extends Staff{

    protected Staff staff;
    public ExtraTask(){}

    public ExtraTask(Staff staff) {
        this.staff = staff;
    }

    public  void update(){
        staff.update();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
