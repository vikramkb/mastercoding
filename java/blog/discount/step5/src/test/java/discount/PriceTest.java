package discount;

import car.CarModel;
import car.CarPrice;
import car.CarType;
import car.FuelType;
import discount.category.CategoryDiscounts;
import discount.category.CategorySubTypeDiscounts;
import discount.rules.PriceBreakStrategy;
import discount.rules.SimpleStrategy;
import discount.type.Discount;
import discount.type.FlatDiscount;
import discount.type.PercentageDiscount;
import org.junit.Before;
import org.junit.Test;
import util.Tuple2;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PriceTest {

    private CarPrice price;

    @Before
    public void setUp() throws Exception {
        CategorySubTypeDiscounts fuelTypeDiscounts = new CategorySubTypeDiscounts();

        List<Tuple2<Double, Discount>> dieselDiscountPriceBreak = new ArrayList<>();
        dieselDiscountPriceBreak.add(new Tuple2<Double, Discount>(500000.0, new FlatDiscount(10000)));
        dieselDiscountPriceBreak.add(new Tuple2<Double, Discount>(Double.MAX_VALUE, new FlatDiscount(30000)));
        PriceBreakStrategy dieselDiscountBreak = new PriceBreakStrategy(dieselDiscountPriceBreak);

        fuelTypeDiscounts.add(FuelType.DIESEL.toString(), dieselDiscountBreak);

        List<Tuple2<Double, Discount>> petrolDiscountPriceBreak = new ArrayList<>();
        petrolDiscountPriceBreak.add(new Tuple2<Double, Discount>(300000.0, new FlatDiscount(5000)));
        petrolDiscountPriceBreak.add(new Tuple2<Double, Discount>(Double.MAX_VALUE, new FlatDiscount(10000)));
        PriceBreakStrategy petrolDiscountBreak = new PriceBreakStrategy(petrolDiscountPriceBreak);

        fuelTypeDiscounts.add(FuelType.PETROL.toString(), petrolDiscountBreak);

        CategorySubTypeDiscounts carTypeDiscounts = new CategorySubTypeDiscounts();
        carTypeDiscounts.add(CarType.HATCHBACK.toString(), new SimpleStrategy(new PercentageDiscount(1.0)));
        carTypeDiscounts.add(CarType.SEDAN.toString(), new SimpleStrategy(new PercentageDiscount(1.5)));

        CategoryDiscounts categoryDiscounts = new CategoryDiscounts();
        categoryDiscounts.add("CarType", carTypeDiscounts);
        categoryDiscounts.add("FuelType", fuelTypeDiscounts);

        price = new CarPrice(categoryDiscounts);
    }

    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeLowerRange() throws Exception {
        CarModel mahindraKUV100Diesel = new CarModel(CarType.HATCHBACK, FuelType.DIESEL);
        double totalPrice = price.totalPrice(mahindraKUV100Diesel, 450000);
        assertEquals(435500, totalPrice, 0.001);
    }

    @Test
    public void testShouldNotApplyAnyDiscountIfDiscountIsNotAvailable() throws Exception {
        CarModel mahindraScorpioDiesel = new CarModel(CarType.SUV, FuelType.DIESEL);
        double totalPrice = price.totalPrice(mahindraScorpioDiesel, 1300000);
        assertEquals(1270000, totalPrice, 0.001);
    }
}