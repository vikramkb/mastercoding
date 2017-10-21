package discount.type;

import org.junit.Assert;
import org.junit.Test;

public class FlatDiscountTest {
    @Test
    public void testShouldApplyFlatDiscount() throws Exception {
        double discount = 1000;
        FlatDiscount flatDiscount = new FlatDiscount(discount);

        double price = 10000;
        Assert.assertEquals(9000, flatDiscount.apply(price), 0.01);
    }
}
