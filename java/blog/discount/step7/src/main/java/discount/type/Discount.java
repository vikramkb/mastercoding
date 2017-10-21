package discount.type;

import money.Money;

public interface Discount {
    Money apply(Money amount);
}
