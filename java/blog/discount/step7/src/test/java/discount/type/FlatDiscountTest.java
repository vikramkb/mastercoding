package discount.type;

import money.Money;
import org.junit.Assert;
import org.junit.Test;

public class FlatDiscountTest {
    @Test
    public void testShouldApplyFlatDiscount() throws Exception {
        Money discount = new Money(1000);
        FlatDiscount flatDiscount = new FlatDiscount(discount);

        Money price = new Money(10000);
        Assert.assertEquals(new Money(9000), flatDiscount.apply(price));
    }
}
