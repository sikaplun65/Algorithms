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
    // O(log n)
    private double myPow(int val, int deg) {
        // Initialize result
        double temp;
        if( deg == 0) // Base condition
            return 1;
        else if(deg < 0)
            return 1 / myPow(val,Math.abs(deg));
        else{
            temp = myPow(val, deg/2); // recursive calling
            if (deg%2 == 0) //checking whether y is even or not
                return temp*temp;
            else
                return val*temp*temp;
        }
        // O(n)
//        return (deg > 0) ? val * myPow(val, deg - 1) : (deg < 0) ? 1 / myPow(val,Math.abs(deg)) : 1;
    }
}
