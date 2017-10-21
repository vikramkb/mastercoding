package money;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ExchangeTest {
    @Test
    public void testCompareEqualityOfTwoMoneysOfDifferentCurrency() throws Exception {
        Money hundredRuppes = new Money(100);
        Money sameUsd = new Money(1.5, Optional.ofNullable(MoneySingletonFactory.getCurrencies().get("USD")));
        Money actualUsd = new MoneyExchange().convert(hundredRuppes, MoneySingletonFactory.getCurrencies().get("USD"));
        Assert.assertEquals(sameUsd, actualUsd);
    }
}
