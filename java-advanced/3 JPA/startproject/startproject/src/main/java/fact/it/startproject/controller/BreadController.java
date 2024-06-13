package fact.it.startproject.controller;

import fact.it.startproject.model.Bread;
import fact.it.startproject.repository.BreadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BreadController {
    private BreadRepository breadRepository;
    public BreadController(BreadRepository breadRepository) {
        this.breadRepository = breadRepository;
    }
@PostConstruct
    public void fillDatabaseTemprory(){
        for(int i=0;i<10;i++){
            Bread bread = new Bread();
            bread.setName("Bread"+i);
            bread.setPrice(25.5-i);
            breadRepository.save(bread);
        }
}
@RequestMapping("/")
    public String index(Model model){
        List<Bread> breadList = breadRepository.giveListOfAllBreadsOrderedByPrice();
        model.addAttribute("breadList", breadList);
        return "index";
}
@RequestMapping("/add")
    public String add(){
        return "add";
}
@RequestMapping("/processadd")
    public String processAdd(Model model, HttpServletRequest request){
        String breadName = request.getParameter("name");
        Double price=0.0;
        try {
            price =(Double.parseDouble(request.getParameter("price"))) ;
        }catch (NumberFormatException e){
            model.addAttribute("message", "the number you entered is not a number");
            return "error";
        }
        Bread bread = new Bread();
        bread.setName(breadName);
        bread.setPrice(price);
        breadRepository.save(bread);
        List<Bread> breadList = breadRepository.giveListOfAllBreadsOrderedByPrice();
        model.addAttribute("breadList", breadList);
        return "index";
}
@RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        Bread bread = breadRepository.findById(breadId).get();
        model.addAttribute("bread", bread);
        return "edit";
}
@RequestMapping("/processedit")
    public String processEdit(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        String breadName = request.getParameter("name");
        Double price =(Double.parseDouble(request.getParameter("price"))) ;
        Bread bread = new Bread();
        bread.setName(breadName);
        bread.setPrice(price);
        breadRepository.save(bread);
        List<Bread> breadList = breadRepository.giveListOfAllBreadsOrderedByPrice();
        model.addAttribute("breadList", breadList);
        return "index";
        //can we merge the two function together?
}
@RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        breadRepository.deleteById(breadId);
        List<Bread> breadList = breadRepository.giveListOfAllBreadsOrderedByPrice();
        model.addAttribute("breadList", breadList);
        return "index";
}
@RequestMapping("/search")
    public String search(Model model, HttpServletRequest request){
        if(request.getParameter("searchname")!=null) {
            String searchstring = request.getParameter("searchstring");
            List<Bread> breadList = breadRepository.findAllByNameStartsWith(searchstring);
        }else if(request.getParameter("searchcheap")!=null) {
            List<Bread> breadList=breadRepository.findCheapestBreads();
            model.addAttribute("breadList", breadList);
        }
        return "index";
}
}
