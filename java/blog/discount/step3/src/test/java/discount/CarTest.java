package discount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Tuple2;


import java.util.*;

import static org.junit.Assert.assertEquals;

public class CarTest {

    private Map<FuelType, List<Tuple2<Integer, Integer>>> fuelTypeDiscountMap;
    private Map<CarType, Double> carTypeDiscountMap;

    @Before
    public void setUp() throws Exception {
        List<Tuple2<Integer, Integer>> dieselDiscountBreak = new LinkedList<>();
        dieselDiscountBreak.add(new Tuple2<>(500000, 10000));
        dieselDiscountBreak.add(new Tuple2<>(Integer.MAX_VALUE, 30000));

        List<Tuple2<Integer, Integer>> petrolDiscountBreak = new LinkedList<>();
        petrolDiscountBreak.add(new Tuple2<>(300000, 5000));
        petrolDiscountBreak.add(new Tuple2<>(Integer.MAX_VALUE, 10000));

        fuelTypeDiscountMap = new HashMap<>();
        fuelTypeDiscountMap.put(FuelType.DIESEL, dieselDiscountBreak);
        fuelTypeDiscountMap.put(FuelType.PETROL, petrolDiscountBreak);

        carTypeDiscountMap = new HashMap<>();
        carTypeDiscountMap.put(CarType.HATCHBACK, 1.0);
        carTypeDiscountMap.put(CarType.SEDAN, 1.5);
    }

    @After
    public void tearDown() throws Exception {
        fuelTypeDiscountMap.clear();
        carTypeDiscountMap.clear();
    }

    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeUpperRange() throws Exception {
        Car maruthiSwiftDiesel = new Car(CarType.HATCHBACK, FuelType.DIESEL,600000, fuelTypeDiscountMap, carTypeDiscountMap);
        assertEquals(564000, maruthiSwiftDiesel.totalPrice(), 0.001);
    }

    @Test
    public void testShouldReturnSamePriceInCaseNoDiscountsApplicable() throws Exception {
        Car mahindraKUV100Diesel = new Car(CarType.HATCHBACK, FuelType.DIESEL, 450000, new HashMap<>(), new HashMap<>());
        assertEquals(450000, mahindraKUV100Diesel.totalPrice(), 0.001);
    }
}