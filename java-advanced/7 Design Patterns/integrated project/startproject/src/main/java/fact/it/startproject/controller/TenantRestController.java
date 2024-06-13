package fact.it.startproject.controller;

import fact.it.startproject.model.Tenant;
import fact.it.startproject.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tenants")
public class TenantRestController {

    private final TenantRepository tenantRepository;
    public TenantRestController(TenantRepository tenantRepository){
        this.tenantRepository = tenantRepository;
    }
    @GetMapping("/select")
    public List<Tenant> getTenantsByLessTan(double income){
        List<Tenant> tenants = tenantRepository.findByIncomeLessThan(income);
        return tenants;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@RequestBody Tenant updateTenant, @PathVariable long id) {
        return tenantRepository.findById(id)
                .map(tenant -> {
                    tenant.setName(updateTenant.getName());
                    tenant.setIncome(updateTenant.getIncome());
                    tenantRepository.save(tenant);
                    return ResponseEntity.ok(tenant);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
//        Optional<Tenant> tenant1 = tenantRepository.findById(id);
//        if (tenant1.isPresent()) {
//            Tenant tenant = tenant1.get();
//            tenant.setName(updateTenant.getName());
//            tenant.setIncome(updateTenant.getIncome());
//            tenantRepository.save(tenant);
//            return new ResponseEntity<>(tenant, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @GetMapping("/get")
    public List<Tenant> getTenants(){
        List<Tenant> tenants = tenantRepository.findAll();
        return tenants;
    }

}
