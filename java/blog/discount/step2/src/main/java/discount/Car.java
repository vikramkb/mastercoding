package discount;

public class Car {
    private CarType carType;
    private FuelType fuelType;
    private double initialPrice;

    public Car(CarType carType, FuelType fuelType, double initialPrice) {
        this.carType = carType;
        this.fuelType = fuelType;
        this.initialPrice = initialPrice;
    }

    public double totalPrice() {
        return applyFuelTypeDiscount(applyCarTypeDiscount(initialPrice));
    }

    private double applyFuelTypeDiscount(double price) {
        double discountPrice = 0;
        if (fuelType == FuelType.DIESEL) {
            if (initialPrice <= 500000) {
                discountPrice = 10000;
            } else {
                discountPrice = 30000;

            }
        } else if (fuelType == FuelType.PETROL) {
            if (initialPrice <= 300000) {
                discountPrice = 5000;
            } else {
                discountPrice = 10000;
            }
        }
        return price - discountPrice;
    }

    private double applyCarTypeDiscount(double price) {
        double discountPercentage = 2.0;
        if (carType == CarType.HATCHBACK) {
            discountPercentage = 1.0;
        } else if (carType == CarType.SEDAN) {
            discountPercentage = 1.5;
        }

        return price - percentage(price, discountPercentage);
    }

    private double percentage(double number, double part) {
        final int whole = 100;
        return number * (part / whole);
    }
}