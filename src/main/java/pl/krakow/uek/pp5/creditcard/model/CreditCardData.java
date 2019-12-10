package pl.krakow.uek.pp5.creditcard.model;

import java.math.BigDecimal;

public class CreditCardData {
    String number;
    BigDecimal limit;
    BigDecimal balance;

    public CreditCardData() {}
    public CreditCardData(String number, BigDecimal limit, BigDecimal balance) {
        this.number = number;
        this.limit = limit;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
