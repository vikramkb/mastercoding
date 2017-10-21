package discount.type;

import util.MathExtra;

public class PercentageDiscount implements Discount{
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(double amount) {
        return amount - new MathExtra().percentage(amount, percentage);
    }
}
