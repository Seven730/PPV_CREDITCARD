package pl.krakow.uek.pp5.creditcard.model.pl.krakow.uek.pp5.e2e;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.krakow.uek.pp5.creditcard.model.CreditCardFacade;
import pl.krakow.uek.pp5.creditcard.model.dto.CardBlanceDto;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class Foo {
    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    CreditCardFacade creditCardFacade;

    @LocalServerPort
    private int port;

    @Test
    public void itListCardBalances(){

        ResponseEntity re = restTemplate.getForEntity(getURL("/api/cards/balances"),
                CardBlanceDto[].class);
        assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
    private  String getURL(String URI){
        return String.format("http://localhost:%s%s",port,URI);

    }
}
