package car;

import util.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private CarType carType;
    private FuelType fuelType;

    public CarModel(CarType carType, FuelType fuelType) {
        this.carType = carType;
        this.fuelType = fuelType;
    }

    /*ideally loaded from the api, db or files. Hard coded for the simplicity*/
    public List<Tuple2<String, String>> getDiscountCategories() {
        List<Tuple2<String, String>> discountCategories = new ArrayList<>();
        discountCategories.add(new Tuple2<>("CarType", carType.toString()));
        discountCategories.add(new Tuple2<>("FuelType", fuelType.toString()));

        return discountCategories;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

}