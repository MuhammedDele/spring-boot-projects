package fact.it.startproject.controller;

import fact.it.startproject.model.Customer;
import fact.it.startproject.model.Employee;
import fact.it.startproject.model.Executive;
import fact.it.startproject.model.Person;
import fact.it.startproject.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonController {
    private PersonRepository personRepository;
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/addPerson")
    public String addPerson() {
        return "addPerson";
    }
    @RequestMapping("/processAddPerson")
    public String processAddPerson(Model model, HttpServletRequest request){
        String name = request.getParameter("name");
        Person person = new Person();
        person.setName(name);
        personRepository.save(person);
        return "index";
    }
    @RequestMapping("/addCustomer")
    public String addCustomer(){
        return "addCustomer";
    }
    @RequestMapping("/processAddCustomer")
    public String processAddCustomer(Model model, HttpServletRequest request){
        String name = request.getParameter("name");
        double discount = Double.parseDouble(request.getParameter("discount"));
        Customer customer = new Customer();
        customer.setName(name);
        customer.setDiscount(discount);
        personRepository.save(customer);
        return "index";

    }
    @RequestMapping("/addEmployee")
    public String addEmployee(){
        return "addEmployee";
    }
    @RequestMapping("/processAddEmployee")
    public String processAddEmployee(Model model, HttpServletRequest request){
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        personRepository.save(employee);
        return "index";
    }
    @RequestMapping("/addExecutive")
    public String addExecutive(){
        return "addExecutive";
    }
    @RequestMapping("/processAddExecutive")
    public String processAddExecutive(Model model, HttpServletRequest request){
        String name = request.getParameter("name");
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        Executive executive = new Executive();
        executive.setName(name);
        executive.setBonus(bonus);
        personRepository.save(executive);
        return "index";
    }

}
