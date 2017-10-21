package discount.rules;

import discount.type.Discount;
import money.Money;

public class SimpleStrategy implements DiscountStrategy {
    private Discount discount;

    public SimpleStrategy(Discount discount) {
        this.discount = discount;
    }

    @Override
    public Money apply(Money amount) {
        return discount.apply(amount);
    }
}
