


package pl.krakow.uek.pp5.creditcard.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krakow.uek.pp5.creditcard.model.CreditCardFacade;
import pl.krakow.uek.pp5.creditcard.model.WithdrawCommand;
import pl.krakow.uek.pp5.creditcard.model.dto.CardBlanceDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CreditCardReportingController {

    CreditCardFacade api;

    @Autowired
    public CreditCardReportingController(CreditCardFacade api) {
        this.api = api;
    }

    // http://localhost:8080/api/cards/balances


    @GetMapping("/balances")
    public List<CardBlanceDto> cardsBalances() {

        return Arrays.asList(
                new CardBlanceDto("1234", BigDecimal.valueOf(1000)),
                new CardBlanceDto("5678", BigDecimal.valueOf(2000)),
                new CardBlanceDto("1290", BigDecimal.valueOf(8000))
        );
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody WithdrawCommand command) {
        api.withdraw(command);
    }
}
