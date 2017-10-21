package money;

import java.util.*;

public class MoneyExchange {
    final private Currencies currencies = MoneySingletonFactory.getCurrencies();


    public Money convert(Money fromMoney, Currency toCurrency) {
        double toConversionRate = getRates().get(fromMoney.getCurrency()) / getRates().get(toCurrency);
        return new Money(fromMoney.getAmount() * toConversionRate, Optional.ofNullable(toCurrency));
    }

    /* ideally get this information on daily basis. Hard coded for simplicity */
    private Map<Currency, Double> getRates() {
        Map<Currency, Double> exchangeRate = new HashMap<>();
        exchangeRate.put(currencies.get("INR"), 0.015);
        exchangeRate.put(currencies.get("USD"), 1.0);
        exchangeRate.put(currencies.get("GBP"), 1.34);

        return Collections.unmodifiableMap(exchangeRate);
    }
}
