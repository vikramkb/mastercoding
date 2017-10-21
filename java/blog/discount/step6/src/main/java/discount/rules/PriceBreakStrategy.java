package discount.rules;

import money.Money;
import util.Tuple2;
import discount.type.Discount;

import java.util.List;

public class PriceBreakStrategy implements DiscountStrategy {
    final private List<Tuple2<Money, Discount>> priceBreaks;

    //assuming the price breaks are in sorted order for simplicity
    public PriceBreakStrategy(List<Tuple2<Money, Discount>> priceBreaks) {
        this.priceBreaks = priceBreaks;
    }

    @Override
    public Money apply(Money amount) {
        for (Tuple2<Money, Discount> priceBreakDiscountStrategy : priceBreaks) {
            if(amount.lessOrEqual(priceBreakDiscountStrategy.first)) {
                return priceBreakDiscountStrategy.second.apply(amount);
            }
        }
        return amount;
    }
}
