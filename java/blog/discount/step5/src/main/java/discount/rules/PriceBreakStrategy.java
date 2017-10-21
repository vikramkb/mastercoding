package discount.rules;

import util.Tuple2;
import discount.type.Discount;

import java.util.List;

public class PriceBreakStrategy implements DiscountStrategy {
    private List<Tuple2<Double, Discount>> priceBreaks;

    //assuming the price breaks are in sorted order for simplicity
    public PriceBreakStrategy(List<Tuple2<Double, Discount>> priceBreaks) {
        this.priceBreaks = priceBreaks;
    }

    @Override
    public double apply(double amount) {
        for (Tuple2<Double, Discount> priceBreakDiscountStrategy : priceBreaks) {
            if(amount <= priceBreakDiscountStrategy.first) {
                return priceBreakDiscountStrategy.second.apply(amount);
            }
        }
        return amount;
    }
}
