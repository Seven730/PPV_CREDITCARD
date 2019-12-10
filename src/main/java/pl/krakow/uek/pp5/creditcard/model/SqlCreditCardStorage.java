package pl.krakow.uek.pp5.creditcard.model;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SqlCreditCardStorage implements CreditCardStorage {
    private JdbcTemplate jdbcTemplate;

    public SqlCreditCardStorage(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(CreditCard cc) {
        jdbcTemplate.update(
                "INSERT INTO `cards` (`number`, `limit`, `balance`) " +
                    "VALUES " +
                    "(?, ?, ?)",
                cc.getNumber(),
                cc.getLimit(),
                cc.getCurrentBalance()
        );
    }

    @Override
    public CreditCard load(String creditCardNumber) {
        CreditCardData ccData = jdbcTemplate.queryForObject(
                "Select * from cards WHERE number = ?",
                new Object[]{creditCardNumber},
                BeanPropertyRowMapper.newInstance(CreditCardData.class)
        );

        return CreditCard.of(ccData);
    }

    @Override
    public List<CreditCard> all() {
        return null;
    }
}
