package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SqlCreditCardStorageTest {

    public static final String CREDIT_CARD_NUMBER = "1234";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void itAllowToStoreCC() {
        SqlCreditCardStorage sqlStore = new SqlCreditCardStorage(jdbcTemplate);

        sqlStore.add(getCreditCard());

        CreditCard loaded = sqlStore.load(CREDIT_CARD_NUMBER);

        assertThat(CREDIT_CARD_NUMBER).isEqualTo(loaded.getNumber());
    }

    private CreditCard getCreditCard() {
        CreditCard creditCard = new CreditCard(CREDIT_CARD_NUMBER);
        creditCard.assignLimit(BigDecimal.valueOf(1000));
        return creditCard;
    }
}
