package discount.rules;

import money.Money;

public interface DiscountStrategy {
    Money apply(Money amount);
}
