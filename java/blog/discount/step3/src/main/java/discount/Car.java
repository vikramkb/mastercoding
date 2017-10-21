package discount;

import util.Tuple2;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Car {
    private CarType carType;
    private FuelType fuelType;
    private double initialPrice;

    private Map<FuelType, List<Tuple2<Integer, Integer>>> fuelTypeDiscountMap;
    private Map<CarType, Double> carTypeDiscountMap;

    public Car(CarType carType, FuelType fuelType, double initialPrice, Map<FuelType, List<Tuple2<Integer, Integer>>> fuelTypeDiscountMap, Map<CarType, Double> carTypeDiscountMap) {
        this.carType = carType;
        this.fuelType = fuelType;
        this.initialPrice = initialPrice;
        this.fuelTypeDiscountMap = fuelTypeDiscountMap;
        this.carTypeDiscountMap = carTypeDiscountMap;
    }

    public double totalPrice() {
        return applyFuelTypeDiscount(applyCarTypeDiscount(initialPrice));
    }

    private double applyFuelTypeDiscount(double price) {
        if (!isFuelTypeDiscountApplicable()) return price;

        List<Tuple2<Integer, Integer>> priceDiscountRanges = fuelTypeDiscountMap.get(fuelType);

        for(Tuple2<Integer, Integer> priceRange : priceDiscountRanges) {
            if(price <= priceRange.first)
                return price - priceRange.second;
        }

        return price;
    }

    private boolean isFuelTypeDiscountApplicable() {
        return fuelTypeDiscountMap.containsKey(fuelType);
    }

    private double applyCarTypeDiscount(double price) {
        if (!isCarTypeDiscountApplicable())
            return price;
        double discountPercentage = carTypeDiscountMap.get(carType);
        return price - percentage(price, discountPercentage);
    }

    private boolean isCarTypeDiscountApplicable() {
        return carTypeDiscountMap.containsKey(carType);
    }

    private double percentage(double number, double part) {
        final int whole = 100;
        return number * (part / whole);
    }
}