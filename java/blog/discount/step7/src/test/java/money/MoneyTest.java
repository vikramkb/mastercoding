package money;

import org.junit.Assert;
import org.junit.Test;
import util.MathExtra;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public class MoneyTest {
    private MathExtra mathExtra = new MathExtra();
    private Money tenRupees = new Money(10.0);
    private Money thirtyRuppes = new Money(30.0);

    @Test
    public void testShouldGivePercentageOfRealNumber() throws Exception {
        Assert.assertEquals(22.22, mathExtra.percentage(100.0, 22.22), 0.001);
    }

    @Test
    public void testReturnMinOfTwoDifferentMoney() throws Exception {
        Assert.assertEquals(tenRupees, tenRupees.min(thirtyRuppes));
    }

    @Test
    public void testReturnMaxOfTwoDifferentMoney() throws Exception {
        Assert.assertEquals(thirtyRuppes, tenRupees.max(thirtyRuppes));
    }

    @Test
    public void testChecksMoneyIsLessThanOtherMoney() throws Exception {
        Assert.assertTrue(tenRupees.less(thirtyRuppes));
    }

   @Test
    public void testChecksMoneyIsLessThanOrEqualOtherMoney() throws Exception {
        Assert.assertTrue(tenRupees.lessOrEqual(tenRupees));
        Assert.assertTrue(tenRupees.lessOrEqual(thirtyRuppes));
    }

    @Test
    public void testChecksMoneyIsMoreThanOtherMoney() throws Exception {
        Assert.assertTrue(thirtyRuppes.more(tenRupees));
    }

    @Test
    public void testChecksMoneyIsMoreThanPrEqualOtherMoney() throws Exception {
        Assert.assertTrue(thirtyRuppes.moreOrEqual(thirtyRuppes));
        Assert.assertTrue(thirtyRuppes.moreOrEqual(tenRupees));
    }

    @Test
    public void testGivesSubtractedMoney() throws Exception {
        Money twentyRupees = new Money(20.0);
        Assert.assertEquals(twentyRupees, thirtyRuppes.subtract(tenRupees));
    }

    @Test
    public void testGivesAddedMoney() throws Exception {
        Money fortyRupees = new Money(40.0);
        Assert.assertEquals(fortyRupees, thirtyRuppes.add(tenRupees));
    }

    @Test
    public void testReturnEqualityOfTwoMoneys() throws Exception {
        Assert.assertTrue(tenRupees.equals(tenRupees));
    }

    @Test
    public void testCompareEqualityOfTwoMoneysOfDifferentCurrency() throws Exception {
        Money hundredRuppes = new Money(100);
        Money sameUsd = new Money(1.5, Optional.ofNullable(MoneySingletonFactory.getCurrencies().get("USD")));
        Assert.assertEquals(hundredRuppes, sameUsd);
    }
}