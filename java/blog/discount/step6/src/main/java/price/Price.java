package price;

import car.CarModel;
import discount.category.CategoryDiscounts;
import money.Money;
import util.Tuple2;

import java.util.Optional;

public class Price {
    private CategoryDiscounts categoryDiscounts;

    public Price(CategoryDiscounts categoryDiscounts) {
        this.categoryDiscounts = categoryDiscounts;
    }

    public Money totalPrice(CarModel model, Money basePrice) {
        Money discountedPrice = basePrice;
        for(Tuple2<String, String> category :model.getDiscountCategories()) {
            final Money currentPrice = discountedPrice;
            discountedPrice =categoryDiscounts
                    .getDiscounts(category.first)
                    .flatMap(x -> x.getDiscountRule(category.second))
                    .flatMap(x -> Optional.of(x.apply(currentPrice)))
                    .orElse(currentPrice);
        }
        return discountedPrice;
    }
}
