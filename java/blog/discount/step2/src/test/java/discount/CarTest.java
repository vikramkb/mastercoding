package discount;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeLowerRange() throws Exception {
        Car mahindraKUV100Diesel = new Car(CarType.HATCHBACK, FuelType.DIESEL,450000);
        assertEquals(435500, mahindraKUV100Diesel.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeUpperRange() throws Exception {
        Car maruthiSwiftDiesel = new Car(CarType.HATCHBACK, FuelType.DIESEL,600000);
        assertEquals(564000, maruthiSwiftDiesel.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplyHatchbackDiscountPetrolTypeLowerRange() throws Exception {
        Car mahindraKUV100Petrol = new Car(CarType.HATCHBACK, FuelType.PETROL,300000);
        assertEquals(292000, mahindraKUV100Petrol.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplyHatchbackDiscountPetrolTypeUpperRange() throws Exception {
        Car maruthiSwiftPetrol = new Car(CarType.HATCHBACK, FuelType.PETROL,600000);
        assertEquals(584000, maruthiSwiftPetrol.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplySedanDiscountDieselTypeUpperRange() throws Exception {
        Car voksWagenVentoTDIDiesel = new Car(CarType.SEDAN, FuelType.DIESEL,950000);
        assertEquals(905750, voksWagenVentoTDIDiesel.totalPrice(), 0.001);
    }

    @Test
    public void testShouldApplySUVDiscountDieselTypeUpperRange() throws Exception {
        Car mahindraScorpioDiesel = new Car(CarType.SUV, FuelType.DIESEL,1300000);
        assertEquals(1244000, mahindraScorpioDiesel.totalPrice(), 0.001);
    }

}

/**
    For Hatchback discount.type, the applicable java.discount is 1%.
        *      Sedan discount.type, the applicable java.discount is 1.5%.
        *      SUV discount.type, the applicable java.discount is 2%.
        *  For Fuel Type,
        *      Diesel discount.type,
        *          if the initial prices is less than or equal to 5,00,000Rs, the java.discount is 10000
        *          otherwise, the java.discount is 30000
        *      Petrol discount.type,
        *          if the initial prices is less than or equal to 3,00,000Rs, the java.discount is 5000
        *          otherwise, the java.discount is 10000
*/