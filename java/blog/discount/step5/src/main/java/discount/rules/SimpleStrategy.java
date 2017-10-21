package discount.rules;

import discount.type.Discount;

public class SimpleStrategy implements DiscountStrategy {
    private Discount discount;

    public SimpleStrategy(Discount discount) {
        this.discount = discount;
    }

    @Override
    public double apply(double amount) {
        return discount.apply(amount);
    }
}
