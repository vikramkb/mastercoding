package discount.rules;

import discount.type.Discount;
import discount.type.FlatDiscount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Tuple2;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PriceBreakStrategyTest {

    @Test
    public void testShouldApplyTheLastBreakFlatDiscount() throws Exception {
        FlatDiscount firstBreakDiscountMock = mock(FlatDiscount.class);
        FlatDiscount secondBreakDiscountMock = mock(FlatDiscount.class);
        double amount = 600000;
        double expectedDiscountedPrice = 580000;
        doReturn(expectedDiscountedPrice).when(secondBreakDiscountMock).apply(amount);

        List<Tuple2<Double, Discount>> dieselDiscountPriceBreak = new ArrayList<>();
        dieselDiscountPriceBreak.add(new Tuple2<Double, Discount>(500000.0, firstBreakDiscountMock));
        dieselDiscountPriceBreak.add(new Tuple2<Double, Discount>(Double.MAX_VALUE, secondBreakDiscountMock));
        PriceBreakStrategy priceBreakStrategy = new PriceBreakStrategy(dieselDiscountPriceBreak);

        double actualDiscountedPrice = priceBreakStrategy.apply(amount);
        Assert.assertEquals(expectedDiscountedPrice, actualDiscountedPrice, 0.01);
    }
}



