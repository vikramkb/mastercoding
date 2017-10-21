package util;

import org.junit.Assert;
import org.junit.Test;

public class MathExtraTest {
    @Test
    public void testReturnPercentageOfRealNumber() throws Exception {
        double percentage = new MathExtra().percentage(125.35, 10);
        Assert.assertEquals(12.535, percentage, 0.001);
    }
}
