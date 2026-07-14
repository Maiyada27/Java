public class ArmstrongNumberChecker {

    public static void main(String[] args){
        int number= 153;
        int originalNumber= 153;
        int numberCopy= 153;
        int digit= 0;
        double sum =0;  /*final value will be stored*/
        int count= 0;   /*to calculate number of digits*/

        while(number != 0) {
            number = number/10;
            count = count + 1;   /*use while loop to divide by 10 to remove the last digit and add counter to 1 each time. Loop stops when number is 0*/
        }
        while(originalNumber != 0) {
            digit = originalNumber % 10;
            sum = sum + Math.pow(digit, count);  /*calculates each digit to the power of number of digits and then adds them all together*/
            originalNumber = originalNumber/10; /*removes last number*/
        }
      IO.println("Number " + sum);
        if (numberCopy == sum){
            IO.println("The number is an Armstrong number.");  /*prints that it is an Armstrong number if the sum equals the original number*/
        }





    }
}
