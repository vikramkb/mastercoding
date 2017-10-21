package discount.category;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CategoryDiscounts {
    private Map<String, CategorySubTypeDiscounts> discountTypes = new HashMap<>();

    public void add(String categoryName, CategorySubTypeDiscounts discounts) {
        discountTypes.put(categoryName, discounts);
    }

    public void remove(String categoryName) {
        discountTypes.remove(categoryName);
    }

    public Optional<CategorySubTypeDiscounts> getDiscounts(String categoryName) {
        return Optional.ofNullable(discountTypes.get(categoryName));
    }
}
