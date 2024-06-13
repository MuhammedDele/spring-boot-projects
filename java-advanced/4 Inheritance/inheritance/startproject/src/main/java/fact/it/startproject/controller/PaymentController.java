package fact.it.startproject.controller;

import fact.it.startproject.model.CashPayment;
import fact.it.startproject.model.ElectronicPayment;
import fact.it.startproject.model.Payment;
import fact.it.startproject.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PaymentController {
    private PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }
    @RequestMapping("/")
    public String index(Model model){

        return "index";
    }
    @RequestMapping("/result")
    public String result(Model model){
        List<Payment> paymentList = paymentRepository.findAll();
        model.addAttribute("paymentList",paymentList);
        return "result";
    }
    @RequestMapping("ascResult")
    public String ascResult(Model model){
        List<Payment> paymentList= paymentRepository.giveListOfAllBreadsOrderedByPrice();
        model.addAttribute("paymentList",paymentList);
        return "result";
    }
    @RequestMapping("/cashPaymentResult")
    public String cashPaymentResult(Model model){
        List<CashPayment> paymentList = paymentRepository.findAllCashPayment();
        model.addAttribute("paymentList",paymentList);
        return "result";
    }
    @RequestMapping("/electricPaymentResult")
    public String electricPaymentResult(Model model){
        List<ElectronicPayment> paymentList = paymentRepository.findAllElectricPaymentOrderByCurrency();
        model.addAttribute("paymentList",paymentList);
        return "result";
    }
    @RequestMapping("/certainAmountPaymentResult")
    public String certainAmountPaymentResult(Model model, HttpServletRequest request){
        Double amount  =Double.parseDouble(request.getParameter("amount")) ;
        List<Payment> paymentList = paymentRepository.findPaymentByAmountGreaterThan(amount);
        model.addAttribute("paymentList",paymentList);
        return "result";
    }
    @RequestMapping("/addCashPayment")
    public String addCashPayment(){
        return "addCashPayment";
    }
    @RequestMapping("/processAddCashPayment")
    public String processAddCashPayment(Model model, HttpServletRequest request){
        String beneficiary = request.getParameter("beneficiary");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        String currency = request.getParameter("currency");
        String name = request.getParameter("name");

        CashPayment cashPayment = new CashPayment();
        cashPayment.setBeneficiary(beneficiary);
        cashPayment.setAmount(amount);
        cashPayment.setCurrency(currency);
        cashPayment.setName(name);
        paymentRepository.save(cashPayment);
        List<Payment> paymentList = paymentRepository.findAll();
        model.addAttribute("paymentList", paymentList);
        return "result";
    }
}
