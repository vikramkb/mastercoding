package util;

public class MathExtra {
    private static final double WHOLE = 100.0;

    public double percentage(double realNumber, double part) {
        return realNumber * part / WHOLE;
    }

}
