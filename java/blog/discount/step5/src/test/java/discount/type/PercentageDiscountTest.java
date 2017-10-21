package discount.type;

import org.junit.Assert;
import org.junit.Test;

public class PercentageDiscountTest {
    @Test
    public void testShouldApplyPercentageDiscount() throws Exception {
        PercentageDiscount percentageDiscount = new PercentageDiscount(10);

        double price = 10000;
        Assert.assertEquals(9000, percentageDiscount.apply(price), 0.01);

    }
}
