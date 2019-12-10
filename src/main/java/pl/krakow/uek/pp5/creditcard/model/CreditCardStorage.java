package pl.krakow.uek.pp5.creditcard.model;

import java.util.List;

public interface CreditCardStorage {
    void add(CreditCard cc);

    CreditCard load(String creditCardNumber);

    List<CreditCard> all();
}
