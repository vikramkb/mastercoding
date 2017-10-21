package discount.rules;

import discount.type.Discount;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SimpleStrategyTest {
    @Test
    public void testShouldApplyTheFlatDiscount() throws Exception {
        Discount mockDiscount = mock(Discount.class);
        SimpleStrategy simpleStrategy = new SimpleStrategy(mockDiscount);
        simpleStrategy.apply(1000.0);
        verify(mockDiscount).apply(1000.0);
    }
}
