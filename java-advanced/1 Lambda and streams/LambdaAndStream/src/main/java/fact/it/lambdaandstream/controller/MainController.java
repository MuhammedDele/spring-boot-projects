package fact.it.lambdaandstream.controller;
import fact.it.lambdaandstream.model.PrimeCalculator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    private  PrimeCalculator primeCalculator = new PrimeCalculator();

    @RequestMapping("/")
            public String index(){
                 return "primeCalculator";
            }

    @RequestMapping("/primes")
    public String calculatePrimes(Model model, HttpServletRequest request) {
        int number =Integer.parseInt(request.getParameter("number"));
        List<Integer> primes = primeCalculator.getAllPrimesUntil(number);
        model.addAttribute("number", number);
        model.addAttribute("primes", primes);
        return "primeCalculator";
    }
}
