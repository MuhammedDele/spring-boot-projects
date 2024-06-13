package fact.it.startproject.controller;

import fact.it.startproject.model.Contract;
import fact.it.startproject.model.Property;
import fact.it.startproject.model.Tenant;
import fact.it.startproject.repository.ContractRepository;
import fact.it.startproject.repository.PropertyRepository;
import fact.it.startproject.repository.TenantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/")
public class PropertyController {
    private final PropertyRepository propertyRepository;
    private final TenantRepository tenantRepository;
    private final ContractRepository contractRepository;
    public PropertyController(PropertyRepository propertyRepository, ContractRepository contractRepository, TenantRepository tenantRepository) {
        this.propertyRepository = propertyRepository;
        this.contractRepository = contractRepository;
        this.tenantRepository = tenantRepository;
    }
    @RequestMapping("/")
    public String index(Model model){
        List<Property> propertyList = propertyRepository.findAll();
        model.addAttribute("propertyList", propertyList);

        return "index";
    }
    @RequestMapping("/addContract/{propertyId}")
    public String showAddContractForm(@PathVariable Long propertyId, Model model) {
        Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new IllegalArgumentException("Invalid property Id:" + propertyId));
        List<Tenant> tenants = tenantRepository.findAll();
        model.addAttribute("property", property);
        model.addAttribute("tenants", tenants);
        return "addContract";
    }

    @RequestMapping("/contracts")
    public String addContract(HttpServletRequest request,Model model) {
        Long propertyId = Long.valueOf(request.getParameter("propertyId"));
        Long tenantId= Long.valueOf(request.getParameter("tenantId"));
        int rentalPrice;
        try {
            rentalPrice = Integer.parseInt(request.getParameter("rentalPrice"));

        }catch (NumberFormatException e){
            model.addAttribute("message","Enter a valid price. This must be an integer!");
            return "error";
        }
        boolean active = request.getParameter("active") != null;

        Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new IllegalArgumentException("Invalid property Id:" + propertyId));
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(() -> new IllegalArgumentException("Invalid Tenant Id:" + tenantId));

        Contract contract = new Contract();
        contract.setProperty(property);
        contract.setTenant(tenant);
        contract.setRentalPrice(rentalPrice);
        contract.setActive(active);

        contractRepository.save(contract);
        List<Property> propertyList = propertyRepository.findAll();
        List<Tenant> tenantList = tenantRepository.findAll();
        model.addAttribute("tenantList",tenantList);
        model.addAttribute("propertyList", propertyList);
        List<Contract> contractsList= contractRepository.findAll();
        model.addAttribute("contractsList",contractsList);

        return "contracts";
    }
}
