package discount.type;

import money.Money;

public class FlatDiscount implements Discount{
    private Money flatAmount;

    public FlatDiscount(Money flatAmount) {
        this.flatAmount = flatAmount;
    }

    @Override
    public Money apply(Money amount) {
        return amount.subtract(flatAmount).max(new Money(0));
    }
}
