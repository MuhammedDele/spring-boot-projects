package fact.it.restaurantappstart.model;

public class CleaningStaff extends ExtraTask{

    public CleaningStaff(){
        super();
    }
    public CleaningStaff(Staff staff ){
        super(staff);
    }

//    @Override
//    public void update() {
//        super.update();
//    }
    public void clean(){
        System.out.println("I am " + staff.getName() + " and now I start also with cleaning.");
    }
}
