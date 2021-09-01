package Lesson5;

import lombok.Data;
import lombok.Value;

@Data
public class RaisingNumberToPower {
    private final double number;
    private final double degree;
    private final double result;

    public RaisingNumberToPower(int number, int degree) {
        this.number = number;
        this.degree = degree;
        this.result = myPow(number, degree);
    }

    private double myPow(int val, int deg) {
        return (deg > 0) ? val * myPow(val, deg - 1) : (deg < 0) ? 1 / myPow(val,Math.abs(deg)) : 1;
    }
}
