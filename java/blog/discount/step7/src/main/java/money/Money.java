package money;

import util.MathExtra;

import java.util.Optional;

public class Money {
    final private double amount;
    final private Currency currency;
    final private MoneyExchange exchange = MoneySingletonFactory.getExchange();
    public Money(double amount, Optional<Currency> currency) {
        this.amount = amount;
        this.currency = currency.orElse(MoneySingletonFactory.getCurrencies().defaultCurrency());
    }

    public Money(double amount) {
        this.amount = amount;
        this.currency = MoneySingletonFactory.getCurrencies().defaultCurrency();
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean less(Money money) {
        return amount < getSameCurrency(money).amount;
    }

    public boolean lessOrEqual(Money money) {
        return less(money) || equals(money);
    }

    public boolean more(Money money) {
        return amount > getSameCurrency(money).amount;
    }

    public boolean moreOrEqual(Money money) {
        return more(money) || equals(money);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == getSameCurrency(money).amount;
    }

    public Money subtract(Money money) {
        return new Money(amount - getSameCurrency(money).amount, Optional.of(currency));
    }

    public Money add(Money money) {
        return new Money(amount + getSameCurrency(money).amount, Optional.of(currency));
    }

    public Money max(Money money) {
        return new Money(Math.max(amount, getSameCurrency(money).amount), Optional.of(currency));
    }

    public Money min(Money money) {
        return new Money(Math.min(amount, getSameCurrency(money).amount), Optional.of(currency));
    }

    public Money percentage(double percent) {
        return new Money(new MathExtra().percentage(amount, percent), Optional.of(currency));
    }


    private Money getSameCurrency(Money money) {
        if(currency.equals(money.currency)) {
            return  money;
        }
        return exchange.convert(money, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
