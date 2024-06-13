package fact.it.startproject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RefuellingService {
    private List<Refuelling> refuellingList = new ArrayList<>();
    private int currentId= 1;
    public RefuellingService(){
        addRefuelling(new Refuelling(currentId++, 0, 500, 30));
        addRefuelling(new Refuelling(currentId++, 500, 900, 20));
        addRefuelling(new Refuelling(currentId++, 900, 1200, 15));
    }

    public Optional<Refuelling>getRefuellingById(int id){
        return refuellingList.stream().filter(r -> r.getId() == id).findFirst();
    }

    public List<Refuelling> getRefuellingList() {
        return refuellingList;
    }

    public void setRefuellingList(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }
    public Refuelling addRefuelling(Refuelling newRefuelling){
        refuellingList.add(newRefuelling);
        return newRefuelling;
    }
    public Optional<Refuelling> updateRefuelling(int id, Refuelling newRefuelling){
        return getRefuellingById(id).map(refuelling -> {
            refuellingList.remove(refuelling);
            refuellingList.add(newRefuelling);
            return newRefuelling;
        });
    }
    public int deleteRefuelling(int id) {
        getRefuellingById(id).ifPresent(refuellingList::remove);
        return refuellingList.size();
    }

    public double getAverageConsumption() {
        return refuellingList.stream().mapToDouble(Refuelling::getFuelConsumption).average().orElse(0);
    }
}
