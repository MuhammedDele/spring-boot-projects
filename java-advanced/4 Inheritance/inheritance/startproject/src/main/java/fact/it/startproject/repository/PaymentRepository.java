package fact.it.startproject.repository;

import fact.it.startproject.model.CashPayment;
import fact.it.startproject.model.ElectronicPayment;
import fact.it.startproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository <Payment,Long>{
    @Query("select b from Payment b order by b.amount asc ")
    List<Payment> giveListOfAllBreadsOrderedByPrice();
    @Query("SELECT c FROM CashPayment c")
    List<CashPayment> findAllCashPayment();

    @Query("SELECT e FROM ElectronicPayment e order by e.currency")
    List<ElectronicPayment> findAllElectricPaymentOrderByCurrency();
//    @Query("SELECT p FROM Payment p where p.amount > :amount")
    List<Payment> findPaymentByAmountGreaterThan(double amount);
}
