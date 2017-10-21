package discount;

public class Car {
    private CarType carType;
    private FuelType fuelType;

    public Car(CarType carType, FuelType fuelType) {
        this.carType = carType;
        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

}