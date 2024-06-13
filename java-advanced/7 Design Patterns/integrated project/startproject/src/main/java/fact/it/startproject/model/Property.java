package fact.it.startproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String code;
    private double surface;

    public Property(){}

    @OneToMany(mappedBy = "property")
    private List<Contract> contractList=new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
    public abstract String toString();


}
