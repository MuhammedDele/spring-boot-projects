package fact.it.startproject.controller;

import fact.it.startproject.model.Bread;
import fact.it.startproject.repository.BreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BreadRestController {
    @Autowired
    private BreadRepository breadRepository;
    @GetMapping("/breads")
    public List<Bread> getBreads() {
        return breadRepository.giveListOfAllBreadsOrderedByPrice();
    }
    @GetMapping("/breads/search")
    public List<Bread> getBreadsNamePart(@RequestBody String namePart) {
        return breadRepository.findAllByNameStartsWith(namePart);
    }
    @GetMapping("/breads/searchcheapst")
    public List<Bread> getBreadsCheapest(){
        return breadRepository.findCheapestBreads();
    }
    @PostMapping("/breads/")
    public Bread createBread(@RequestBody Bread bread) {
        return breadRepository.save(bread);
    }
    @PutMapping("/breads/{id}")
    public ResponseEntity<Bread> updateBread(@RequestBody Bread updateBread,@PathVariable long id) {
        Optional<Bread> bread1 = breadRepository.findById(id);
        if (bread1.isPresent()) {
            Bread bread = bread1.get();
            bread.setName(updateBread.getName());
            bread.setPrice(updateBread.getPrice());
            breadRepository.save(bread);
            return new ResponseEntity<>(bread, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/breads/{id}")
    public ResponseEntity<Integer> deleteBread(@PathVariable long id) {
        Optional<Bread> bread1 = breadRepository.findById(id);
        if (bread1.isPresent()) {
            breadRepository.delete(bread1.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/breads/{id}")
    public Bread getBread(@PathVariable long id) {
        return breadRepository.findById(id).orElseThrow(() -> new RuntimeException("Bread not found with id"+id));
    }
}
