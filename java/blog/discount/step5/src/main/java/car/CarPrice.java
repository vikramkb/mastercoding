package car;

import util.Tuple2;
import discount.category.CategoryDiscounts;

import java.util.Optional;

public class CarPrice {
    private CategoryDiscounts categoryDiscounts;

    public CarPrice(CategoryDiscounts categoryDiscounts) {
        this.categoryDiscounts = categoryDiscounts;
    }

    public double totalPrice(CarModel model, double basePrice) {
        double discountedPrice = basePrice;
        for(Tuple2<String, String> category :model.getDiscountCategories()) {
            double totalPrice = discountedPrice;
            discountedPrice =categoryDiscounts
                                .getDiscounts(category.first)
                                .flatMap(x -> x.getDiscountRule(category.second))
                                .flatMap(x -> Optional.of(x.apply(totalPrice)))
                                .orElse(totalPrice);
        }
        return discountedPrice;
    }
}
