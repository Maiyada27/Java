public class SumOfArrayElements {

    public static void main(String[] args) {
        int[] numbers = {2,3,1,2,2,6,12};
        IO.println("Sum of numbers at even indexes= " + sum(numbers, 0));
    }

    static int sum(int[] arr, int index) {
        if (index > arr.length - 1) {   /*base case*/
            return 0;
        }
        int total = arr[index];
        return total + sum(arr, index + 2);
    }
}
