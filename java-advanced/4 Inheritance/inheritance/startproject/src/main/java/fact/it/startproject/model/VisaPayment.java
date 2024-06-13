package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class VisaPayment extends ElectronicPayment{
    private String cardNumber;
    private String expirationDate;

    public VisaPayment(){}

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String toString() {
        return getBeneficiary() + " " + getAmount() + " (clientName: " + getClientName() + " and clientAccount: " + getClientAccount() +
                ") is a Visa Payment with cardNumber = " + cardNumber + " and expirationDate = " + expirationDate + ".";
    }
}
