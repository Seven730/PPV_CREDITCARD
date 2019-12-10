package pl.krakow.uek.pp5.creditcard.model;

import pl.krakow.uek.pp5.creditcard.model.exceptions.CreditBelowLimitException;
import pl.krakow.uek.pp5.creditcard.model.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class CreditCard {
    private final String cardNumber;
    private BigDecimal cardLimit;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static CreditCard of(CreditCardData ccData) {
        CreditCard cc = new CreditCard(ccData.getNumber());
        cc.cardLimit = ccData.limit;
        cc.balance = ccData.balance;

        return cc;
    }

    public void assignLimit(BigDecimal newLimit) {
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) {
            throw new CreditBelowLimitException();
        }
        cardLimit = newLimit;
        balance = newLimit;
    }

    public BigDecimal getLimit() {
        return cardLimit;
    }

    public void withdraw(BigDecimal money) {
        if (balance.compareTo(money) == -1)  {
            throw new NotEnoughMoneyException();
        }

        balance = balance.subtract(money);
    }

    public BigDecimal getCurrentBalance() {
        return balance;
    }

    public String getNumber() {
        return cardNumber;
    }
}
