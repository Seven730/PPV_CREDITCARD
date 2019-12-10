package pl.krakow.uek.pp5.creditcard.model;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryCreditCardStorage implements CreditCardStorage {
    ConcurrentHashMap<String, CreditCard> cards;

    public InMemoryCreditCardStorage() {
        cards = new ConcurrentHashMap<>();
    }

    @Override
    public void add(CreditCard cc) {
        cards.put(cc.getNumber(), cc);
    }

    @Override
    public CreditCard load(String creditCardNumber) {
        return cards.get(creditCardNumber);
    }

    @Override
    public List<CreditCard> all() {
        return cards.values().stream()
                .collect(Collectors.toList());
    }
}
