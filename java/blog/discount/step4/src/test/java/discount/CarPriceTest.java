package discount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Tuple2;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CarPriceTest {

    private Map<FuelType, List<Tuple2<Integer, Integer>>> fuelTypeDiscountMap;
    private Map<CarType, Double> carTypeDiscountMap;
    private CarPrice carPrice;

    @Before
    public void setUp() throws Exception {
        fuelTypeDiscountMap = new HashMap<>();
        List<Tuple2<Integer, Integer>> dieselDiscountBreak = new LinkedList<>();
        dieselDiscountBreak.add(new Tuple2<>(500000, 10000));
        dieselDiscountBreak.add(new Tuple2<>(Integer.MAX_VALUE, 30000));

        List<Tuple2<Integer, Integer>> petrolDiscountBreak = new LinkedList<>();
        petrolDiscountBreak.add(new Tuple2<>(300000, 5000));
        petrolDiscountBreak.add(new Tuple2<>(Integer.MAX_VALUE, 10000));
        fuelTypeDiscountMap.put(FuelType.DIESEL, dieselDiscountBreak);
        fuelTypeDiscountMap.put(FuelType.PETROL, petrolDiscountBreak);

        carTypeDiscountMap = new HashMap<>();
        carTypeDiscountMap.put(CarType.HATCHBACK, 1.0);
        carTypeDiscountMap.put(CarType.SEDAN, 1.5);

        carPrice = new CarPrice(fuelTypeDiscountMap, carTypeDiscountMap);
    }

    @After
    public void tearDown() throws Exception {
        fuelTypeDiscountMap.clear();
        carTypeDiscountMap.clear();
    }


    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeUpperRange() throws Exception {
        Car maruthiSwiftDiesel = new Car(CarType.HATCHBACK, FuelType.DIESEL);
        double totalPrice = carPrice.totalPrice(maruthiSwiftDiesel, 600000);
        assertEquals(564000, totalPrice, 0.001);
    }

    @Test
    public void testShouldReturnSamePriceInCaseNoDiscountsApplicable() throws Exception {
        Car mahindraKUV100Diesel = new Car(CarType.HATCHBACK, FuelType.DIESEL);
        CarPrice carPrice = new CarPrice(new HashMap<>(), new HashMap<>());

        double totalPrice = carPrice.totalPrice(mahindraKUV100Diesel, 450000);
        assertEquals(450000, totalPrice, 0.001);
    }
}