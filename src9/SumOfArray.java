import java.lang.reflect.Array;
import java.util.Arrays;

public class SumOfArray {
    static int[] numbers = {1,3,5,20};
    public static void main(String[] args) {
       int n = numbers.length-1;  /*set n to be the number of indexes in the array*/
       IO.println("Sum of all values in the array= " + sum(n));

    }

    static int sum(int n) {
        if (n < 0) {
            return 0;
        }
        return numbers[n] + sum(n-1);
    }

}
