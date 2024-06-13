package fact.it.startproject.model;

public class Refuelling {
    private int id;
    private int previousMileage;
    private int currentMileage;
    private double amountInLiters;

    public Refuelling(){}
    public Refuelling(int id, int previousMileage,int currentMileage, double amountInLiters){
        this.id=id;
        this.previousMileage= previousMileage;
        this.currentMileage = currentMileage;
        this.amountInLiters= amountInLiters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreviousMileage() {
        return previousMileage;
    }

    public void setPreviousMileage(int previousMileage) {
        this.previousMileage = previousMileage;
    }

    public int getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }

    public double getAmountInLiters() {
        return amountInLiters;
    }

    public void setAmountInLiters(double amountInLiters) {
        this.amountInLiters = amountInLiters;
    }
    public double getFuelConsumption() {
        int distanceDriven = currentMileage - previousMileage;
        return (amountInLiters / distanceDriven) * 100;
    }
}
