package util;

import org.junit.Assert;
import org.junit.Test;

public class MathExtraTest {
    private MathExtra math = new MathExtra();

    @Test
    public void testShouldGivePercentageOfRealNumber() throws Exception {
        Assert.assertEquals(22.22, math.percentage(100.0, 22.22), 0.001);
    }
}