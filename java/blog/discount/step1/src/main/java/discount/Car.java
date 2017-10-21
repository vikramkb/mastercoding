package discount;

public class Car {
    // 0 - Hatchback, 1 - Sedan, 2 - SUV
    private int type;
    // 0 - Diesel, 1 - petrol
    private int fuelType;
    private double initialPrice;

    public Car(int type, int fuelType, double initialPrice) {
        this.type = type;
        this.fuelType = fuelType;
        this.initialPrice = initialPrice;
    }

    public double totalPrice() {
        double totalPrice = initialPrice;
        //discount based on car type
        if (type == 0) {
            totalPrice -= totalPrice * 1 / 100;
        } else if (type == 1) {
            totalPrice -= totalPrice * 1.5 / 100;
        } else {
            totalPrice -= totalPrice * 2 / 100;
        }

        //discount based on fuel type
        if (fuelType == 0) {
            if (initialPrice <= 500000) {
                totalPrice -= 10000;
            } else {
                totalPrice -= 30000;
            }
        } else if (fuelType == 1) {
            if (initialPrice <= 300000) {
                totalPrice -= 5000;
            } else {
                totalPrice -= 10000;
            }
        }

        return totalPrice;
    }
}