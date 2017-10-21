package discount;

import car.CarModel;
import price.Price;
import car.CarType;
import car.FuelType;
import discount.category.CategoryDiscounts;
import discount.category.CategorySubTypeDiscounts;
import discount.rules.PriceBreakStrategy;
import discount.rules.SimpleStrategy;
import discount.type.Discount;
import discount.type.FlatDiscount;
import discount.type.PercentageDiscount;
import money.*;
import org.junit.Before;
import org.junit.Test;
import util.Tuple2;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PriceTest {

    private Price price;

    @Before
    public void setUp() throws Exception {
        CategorySubTypeDiscounts fuelTypeDiscounts = new CategorySubTypeDiscounts();

        List<Tuple2<Money, Discount>> dieselDiscountPriceBreak = new ArrayList<>();
        dieselDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(500000.0), new FlatDiscount(new Money(10000.0))));
        dieselDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(Double.MAX_VALUE), new FlatDiscount(new Money(30000))));
        PriceBreakStrategy dieselDiscountBreak = new PriceBreakStrategy(dieselDiscountPriceBreak);

        fuelTypeDiscounts.add(FuelType.DIESEL.toString(), dieselDiscountBreak);

        List<Tuple2<Money, Discount>> petrolDiscountPriceBreak = new ArrayList<>();
        petrolDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(300000.0), new FlatDiscount(new Money(5000))));
        petrolDiscountPriceBreak.add(new Tuple2<Money, Discount>(new Money(Double.MAX_VALUE), new FlatDiscount(new Money(10000))));
        PriceBreakStrategy petrolDiscountBreak = new PriceBreakStrategy(petrolDiscountPriceBreak);

        fuelTypeDiscounts.add(FuelType.PETROL.toString(), petrolDiscountBreak);

        CategorySubTypeDiscounts carTypeDiscounts = new CategorySubTypeDiscounts();
        carTypeDiscounts.add(CarType.HATCHBACK.toString(), new SimpleStrategy(new PercentageDiscount(1.0)));
        carTypeDiscounts.add(CarType.SEDAN.toString(), new SimpleStrategy(new PercentageDiscount(1.5)));

        CategoryDiscounts categoryDiscounts = new CategoryDiscounts();
        categoryDiscounts.add("CarType", carTypeDiscounts);
        categoryDiscounts.add("FuelType", fuelTypeDiscounts);

        price = new Price(categoryDiscounts);
    }

    @Test
    public void testShouldApplyHatchbackDiscountDieselTypeLowerRange() throws Exception {
        CarModel mahindraKUV100Diesel = new CarModel(CarType.HATCHBACK, FuelType.DIESEL);
        Money totalPrice = price.totalPrice(mahindraKUV100Diesel, new Money(450000));
        assertEquals(new Money(435500), totalPrice);
    }

    @Test
    public void testShouldNotApplyAnyDiscountIfDiscountIsNotAvailable() throws Exception {
        CarModel mahindraScorpioDiesel = new CarModel(CarType.SUV, FuelType.DIESEL);
        Money totalPrice = price.totalPrice(mahindraScorpioDiesel, new Money(1300000));
        assertEquals(new Money(1270000), totalPrice);
    }
}