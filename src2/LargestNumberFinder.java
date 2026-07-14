import java.util.Arrays;

public class LargestNumberFinder {

    public static void main(String[] args){
        int[] numbers = {12, 36, 77, 89, 65};  /*set a set of numbers*/
        int largestNumber = 0; /*set a variable largest number to store largest number*/

       for (int i=1; i < numbers.length; i++)
        if(numbers[i] >= largestNumber){
            largestNumber = numbers[i];
        }                                   /*use for loop and extract every number from the set and compares to the largest number, if it is larger then set the largest number to it */

       IO.println( "Largest number = " + largestNumber);  /*prints the result*/



    }
}
