package discount.category;

import discount.rules.DiscountStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CategorySubTypeDiscounts {
    private Map<String, DiscountStrategy> discounts = new HashMap<>();
    public void add(String categorySubType, DiscountStrategy rule) {
        discounts.put(categorySubType, rule);
    }
    public void remove(String categorySubType) {
        discounts.remove(categorySubType);
    }
    public Optional<DiscountStrategy> getDiscountRule(String categorySubType) {
        return Optional.ofNullable(discounts.get(categorySubType));
    }
}
