import java.util.Arrays;

public class DataAnalyzerSystem {
    static int[] numbers = {30, 44, -43, 62, 71, 89, 24, -55, -19, 23, 71, 21, -24, 54, 23};/*create array numbers and initialized it */

    public static void main(String[] args) {

        /*Display array size, first and last elements.*/
        IO.println("Total number of elements: " + numbers.length);
        IO.println("First element: " + numbers[0]);
        IO.println("Last element: " + numbers[(numbers.length - 1)]);
        /*use a loop to display all values in the array with their index number*/
        for (int i = 0; i <= numbers.length - 1; i++) {
            IO.println("Index(" + i + ")" + " = " + numbers[i]);
        }

        /*use a loop to get the sum of all numbers in the array and create new variable sum*/
        int sum = 0;
        for (int i = 0; i <= numbers.length - 1; i++) {
            sum += numbers[i];
        }
        IO.println("Sum = " + sum);

        /*use casting to get value in double*/
        double average = (double) sum / numbers.length;
        IO.println("Average = " + average);  /*Display result*/

        int largestNum = numbers[0];  /*create largest number variable and initialize it to be the first value in the array*/
        for (int i = 0; i <= numbers.length - 1; i++) {  /*use a loop to compare and get the largest value*/
            if (numbers[i] > largestNum) {
                largestNum = numbers[i];
            }
        }
        IO.println("Maximum = " + largestNum);

        int smallesttNum = numbers[0];  /*create smallest number variable and initialize it to be the first value in the array*/
        for (int i = 0; i <= numbers.length - 1; i++) {  /*use a loop to compare and get the smallest value*/
            if (numbers[i] < smallesttNum) {
                smallesttNum = numbers[i];
            }
        }
        IO.println("Minimum = " + smallesttNum);

        /*create variables and set them to 0*/
        int positive = 0;
        int negative = 0;
        int evenNumbers = 0;
        int oddNumbers = 0;
        int zeroCount = 0;

        for (int i = 0; i <= numbers.length - 1; i++) {   /*use a loop to go through every number in the array. use if statement to check conditions and set values for max,min, odd and even*/
            if (numbers[i] > 0) {
                positive += 1;
            } else if (numbers[i] < 0) {
                negative += 1;
            } else if (numbers[i] == 0) {
                zeroCount += 1;
            }
            if (numbers[i] % 2 == 0) {
                evenNumbers += 1;
            } else if (numbers[i] % 2 != 0) {
                oddNumbers += 1;
            }
        }
        /*Display all results*/
        IO.println("Count of positive numbers = " + positive);
        IO.println("Count of negative numbers = " + negative);
        IO.println("Count of zeros = " + zeroCount);
        IO.println("Count of even numbers = " + evenNumbers);
        IO.println("Count of odd numbers = " + oddNumbers);

        int number = Integer.parseInt(IO.readln("Enter a number: "));   /*prompt user to enter a value*/
        boolean found = false;
        int occurance = 0;
        /*use a loop to check if the number exists and count how many times it appears*/
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (number == numbers[i]) {
                found = true;
                occurance += 1;
            }
        }
        Integer indexFirst = 0;

        /*use a loop to get the fist time the number appears and then stores the value and breaks the loop*/
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (number == numbers[i]) {
                indexFirst = i;
                break;
            }
        }
        /*Display message if number is found with all details about it and if not display another message*/
        if (found == true) {
            IO.println("Number found " + occurance + " times. It appears the first time at index " + indexFirst);
        } else {
            IO.println("Number not found");
        }

        /*prompt user to enter index number for updating the value and the new value.*/
        int ind = Integer.parseInt(IO.readln("Enter index number: "));
        int newNum = Integer.parseInt( IO.readln("Enter new value: "));

        updateValue(ind, newNum);  /*call the method to update the value*/

        reverseNumber(); /*call method to display the array reversed*/
        compare(); /*call method to display array arranged from smalles to largest number*/
    }

    /*Create method to update a value in the array*/
    static void updateValue(int ind, int newNum){
        numbers[ind]= newNum;
        for (int num : numbers) {
            IO.println(num);
        }

    }
    /*create method to reverse numbers in the array using a loop*/
    static void reverseNumber(){
        for(int i= numbers.length - 1; i>=0 ; i--){
            IO.println(numbers[i]);
        }
    }

    static void compare(){
        int[] copyNumbers = numbers;
        int smallest = numbers[0];
        int largest = numbers[0];
        for (int i = 0; i <= copyNumbers.length-1; i++) {
            if (copyNumbers[i] < smallest) {
                smallest = copyNumbers[i];
            } else if (copyNumbers[i] > largest) {
                largest = copyNumbers[i];
            }
        }
        /*use sort function to sort array from smallest to largest number*/
        Arrays.sort(copyNumbers);


        IO.println("Largest number: " + largest);
        IO.println("Smallest number: " + smallest);
        IO.println("List sorted from smallest to largest number:");
        for (int i = 0; i < copyNumbers.length ; i++) {
            IO.println(copyNumbers[i]);
        }
    }

}
