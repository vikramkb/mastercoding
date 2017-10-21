package discount;

import util.Tuple2;
import util.MathExtra;

import java.util.List;
import java.util.Map;

class CarPrice {
    private Map<FuelType, List<Tuple2<Integer, Integer>>> fuelTypeDiscountMap;
    private Map<CarType, Double> carTypeDiscountMap;


    public CarPrice(Map<FuelType, List<Tuple2<Integer, Integer>>> fuelTypeDiscountMap, Map<CarType, Double> carTypeDiscountMap) {
        this.fuelTypeDiscountMap = fuelTypeDiscountMap;
        this.carTypeDiscountMap = carTypeDiscountMap;
    }

    public double totalPrice(Car model, double initialPrice) {
        return applyFuelTypeDiscount(model, applyCarTypeDiscount(model, initialPrice));
    }


    private double applyFuelTypeDiscount(Car model, double price) {
        if (!isFuelTypeDiscountApplicable(model.getFuelType()))
            return price;

        List<Tuple2<Integer, Integer>> priceDiscountRanges = fuelTypeDiscountMap.get(model.getFuelType());

        for (Tuple2<Integer, Integer> priceRange : priceDiscountRanges) {
            if (price <= priceRange.first)
                return price - priceRange.second;
        }

        return price;
    }

    private boolean isFuelTypeDiscountApplicable(FuelType fuelType) {
        return fuelTypeDiscountMap.containsKey(fuelType);
    }

    private double applyCarTypeDiscount(Car model, double price) {
        if (!isCarTypeDiscountApplicable(model.getCarType())) {
            return price;
        }
        double discountPercentage = carTypeDiscountMap.get(model.getCarType());
        return price - new MathExtra().percentage(price, discountPercentage);
    }

    private boolean isCarTypeDiscountApplicable(CarType carType) {
        return carTypeDiscountMap.containsKey(carType);
    }
}
