package discount.rules;

import discount.type.Discount;
import money.Money;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SimpleStrategyTest {
    @Test
    public void testShouldApplyTheFlatDiscount() throws Exception {
        Discount mockDiscount = mock(Discount.class);
        SimpleStrategy simpleStrategy = new SimpleStrategy(mockDiscount);
        Money amount = new Money(1000);
        simpleStrategy.apply(amount);
        verify(mockDiscount).apply(amount);
    }
}
