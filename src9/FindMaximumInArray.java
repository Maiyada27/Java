import java.lang.reflect.Array;

public class FindMaximumInArray {
    static int[] numbers = {1,3,55,20};
    public static void main(String[] args) {
    IO.println("Largest number in the array: " + maxArray(numbers, 0));

    }

    static int maxArray(int[] array, int index ){
        if (index == array.length - 1) {
            return array[index];
        }
        int Max = maxArray(array, index+1);
        return Math.max(Max, array[index]);
    }
}
