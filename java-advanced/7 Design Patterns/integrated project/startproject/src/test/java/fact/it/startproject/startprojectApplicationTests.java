package fact.it.startproject;

import fact.it.startproject.model.Apartment;
import fact.it.startproject.model.Contract;
import fact.it.startproject.model.House;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class startprojectApplicationTests {

    @Test
    public void testApartmentToString(){
        Apartment apartment = new Apartment();
        apartment.setContractList(Arrays.asList(new Contract()));
        apartment.setCode("BEMA56");
        apartment.setFloor(1);
        String result = apartment.toString();
        assertEquals("Apartment (BEMA56) on floor: 1 with 1 contract(s)",result);
    }
    @Test
    public void testHouseToStingDetached(){
        House house = new House();
        house.setTownhouse(false);
        house.setCode("BEMA56");
        String result = house.toString();
        assertEquals("Detached house (BEMA56) with 0 contract(s)", result);

    }
    @Test
    public void testHouseToStingTownHouse(){
        House house = new House();
        house.setTownhouse(true);
        house.setCode("BEMA56");
        String result = house.toString();
        assertEquals("Townhouse (BEMA56) with 0 contract(s)", result);

    }

}
