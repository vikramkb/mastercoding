package discount.rules;

import discount.type.Discount;
import discount.type.FlatDiscount;
import money.Money;
import org.junit.Assert;
import org.junit.Test;
import util.Tuple2;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PriceBreakStrategyTest {
    @Test
    public void testShouldApplyTheFirstBreakFlatDiscount() throws Exception {
        FlatDiscount firstBreakDiscountMock = mock(FlatDiscount.class);
        Money amount = new Money(400000);
        Money expectedDiscountedPrice = new Money(395000);
        when(firstBreakDiscountMock.apply(amount)).thenReturn(expectedDiscountedPrice);

        FlatDiscount secondBreakDiscountMock = mock(FlatDiscount.class);
        List<Tuple2<Money, Discount>> dieselDiscountPriceBreak = new ArrayList<>();
        dieselDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(500000.0), firstBreakDiscountMock));
        dieselDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(Double.MAX_VALUE), secondBreakDiscountMock));
        PriceBreakStrategy priceBreakStrategy = new PriceBreakStrategy(dieselDiscountPriceBreak);

        Money actualDiscountedPrice = priceBreakStrategy.apply(amount);
        Assert.assertEquals(expectedDiscountedPrice, actualDiscountedPrice);
    }

    @Test
    public void testShouldApplyTheLastBreakFlatDiscount() throws Exception {
        FlatDiscount firstBreakDiscountMock = mock(FlatDiscount.class);
        FlatDiscount secondBreakDiscountMock = mock(FlatDiscount.class);
        Money amount = new Money(600000);
        Money expectedDiscountedPrice = new Money(580000);
        when(secondBreakDiscountMock.apply(amount)).thenReturn(expectedDiscountedPrice);

        List<Tuple2<Money, Discount>> dieselDiscountPriceBreak = new ArrayList<>();
        dieselDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(500000.0), firstBreakDiscountMock));
        dieselDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(Double.MAX_VALUE), secondBreakDiscountMock));
        PriceBreakStrategy priceBreakStrategy = new PriceBreakStrategy(dieselDiscountPriceBreak);

        Money actualDiscountedPrice = priceBreakStrategy.apply(amount);
        Assert.assertEquals(expectedDiscountedPrice, actualDiscountedPrice);
    }
}



