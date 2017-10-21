package price;

import car.CarModel;
import car.CarType;
import car.FuelType;
import discount.category.CategoryDiscounts;
import discount.category.CategorySubTypeDiscounts;
import discount.rules.SimpleStrategy;
import money.Money;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceTest {
    @Test
    public void name() throws Exception {
        Money basePrice = new Money(450000);
        Money carTypeDiscountedPrice = new Money(445000);
        Money expectedTotalPrice = new Money(430000);

        CategorySubTypeDiscounts carTypeDiscounts = new CategorySubTypeDiscounts();
        SimpleStrategy simpleStrategyMock = mock(SimpleStrategy.class);
        carTypeDiscounts.add(CarType.HATCHBACK.toString(), simpleStrategyMock);
        carTypeDiscounts.add(CarType.SEDAN.toString(), mock(SimpleStrategy.class));
        when(simpleStrategyMock.apply(basePrice)).thenReturn(carTypeDiscountedPrice);


        CategorySubTypeDiscounts fuelTypeDiscounts = new CategorySubTypeDiscounts();
        SimpleStrategy simpleStrategyMock1 = mock(SimpleStrategy.class);
        fuelTypeDiscounts.add(FuelType.DIESEL.toString(), simpleStrategyMock1);
        fuelTypeDiscounts.add(FuelType.PETROL.toString(), mock(SimpleStrategy.class));
        when(simpleStrategyMock1.apply(carTypeDiscountedPrice)).thenReturn(expectedTotalPrice);

        CarModel mahindraKUV100Diesel = new CarModel(CarType.HATCHBACK, FuelType.DIESEL);

        CategoryDiscounts categoryDiscounts = mock(CategoryDiscounts.class);
        when(categoryDiscounts.getDiscounts("CarType")).thenReturn(Optional.of(carTypeDiscounts));
        when(categoryDiscounts.getDiscounts("FuelType")).thenReturn(Optional.of(fuelTypeDiscounts));

        Price price = new Price(categoryDiscounts);
        Money totalPrice = price.totalPrice(mahindraKUV100Diesel, basePrice);
        assertEquals(expectedTotalPrice, totalPrice);
    }
}
