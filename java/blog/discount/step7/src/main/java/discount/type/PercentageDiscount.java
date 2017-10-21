package discount.type;

import money.Money;

public class PercentageDiscount implements Discount{
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public Money apply(Money amount) {
        return amount.subtract(amount.percentage(percentage));
    }
}
