package discount.type;

public class FlatDiscount implements Discount{
    private double flatAmount;

    public FlatDiscount(double flatAmount) {
        this.flatAmount = flatAmount;
    }

    @Override
    public double apply(double amount) {
        return Math.max(amount - flatAmount, 0);
    }
}
