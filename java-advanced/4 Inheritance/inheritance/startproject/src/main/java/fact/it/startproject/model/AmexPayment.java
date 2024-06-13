package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class AmexPayment extends ElectronicPayment{
    private int pinCode;
    public AmexPayment(){}

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    public String toString() {
        return getBeneficiary() + " " + getAmount() + " (clientName: " + getClientName() + " and clientAccount: " + getClientAccount() +
                ") is an Amex Payment with a pinCode of " + pinCode + " characters.";
    }
}
