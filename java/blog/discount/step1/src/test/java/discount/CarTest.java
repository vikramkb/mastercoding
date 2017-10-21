package discount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeLowerRange() throws Exception {
        Car mahindraKUV100Diesel = new Car(0, 0,450000);
        assertEquals(435500, mahindraKUV100Diesel.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeUpperRange() throws Exception {
        Car maruthiSwiftDiesel = new Car(0, 0,600000);
        assertEquals(564000, maruthiSwiftDiesel.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplyHatchbackDiscountPetrolTypeLowerRange() throws Exception {
        Car mahindraKUV100Petrol = new Car(0, 1,300000);
        assertEquals(292000, mahindraKUV100Petrol.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplyHatchbackDiscountPetrolTypeUpperRange() throws Exception {
        Car maruthiSwiftPetrol = new Car(0, 1,600000);
        assertEquals(584000, maruthiSwiftPetrol.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplySedanDiscountDieselTypeUpperRange() throws Exception {
        Car voksWagenVentoTDIDiesel = new Car(1, 0,950000);
        assertEquals(905750, voksWagenVentoTDIDiesel.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplySUVDiscountDieselTypeUpperRange() throws Exception {
        Car mahindraScorpioDiesel = new Car(2, 0,1300000);
        assertEquals(1244000, mahindraScorpioDiesel.totalPrice(), 0.001);
    }

}