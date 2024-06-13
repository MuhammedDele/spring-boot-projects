package fact.it.startproject.controller;

import fact.it.startproject.model.Refuelling;
import fact.it.startproject.model.RefuellingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/refuellings")
public class RefuellingController {
    private final RefuellingService refServ = new RefuellingService();

    @GetMapping
    public List<Refuelling> getRefuellings(){
        return refServ.getRefuellingList();
    }
    @GetMapping("/{id}")
    public Optional<Refuelling> getRefuellingbyId(int id){
        return refServ.getRefuellingById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<Refuelling> addRefuelling(Refuelling ref){
        ref = refServ.addRefuelling(ref);
        return new ResponseEntity<>(ref, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Refuelling> updateRefuelling(int id,Refuelling ref){
        Optional<Refuelling> updateRefuelling = refServ.updateRefuelling(id, ref);
        return updateRefuelling.map(ResponseEntity::ok).orElseGet(() ->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Refuelling> deleteRefuelling(int id){
//        int ref = refServ.deleteRefuelling(id);
//        return new ResponseEntity<>(ref,HttpStatus.OK);
//
//    }

}
