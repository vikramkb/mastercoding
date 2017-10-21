package discount.type;

import money.Money;
import org.junit.Assert;
import org.junit.Test;

public class PercentageDiscountTest {
    @Test
    public void testShouldApplyPercentageDiscount() throws Exception {
        PercentageDiscount percentageDiscount = new PercentageDiscount(10);

        Money price = new Money(10000);
        Assert.assertEquals(new Money(9000), percentageDiscount.apply(price));

    }
}
