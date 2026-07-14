public class PalindromeChecker {

    public static void main(String[] args){
        int number = 1221;  /*set the number that will be reversed*/
        int numberUnchanged = 1221;/*set another variable for the number that will remain unchanged. Used for comparison*/
        int reversed = 0;/*set reversed where reversed number will be saved*/
        int digit;/*uses this in the loop to store a single digit*/

        while(number != 0) {
            digit = number % 10;/*the remainder will be the last digit*/
            reversed = digit  + reversed*10;/*builds the reversed number by adding the digit to it*/
            number = number / 10;/*remove the last digit by dividing by 10 to continue the process*/
        }
        IO.println("Number =" + numberUnchanged);
        IO.println("Reversed number =" + reversed);

        if (numberUnchanged == reversed){/*set if condition to check if the reversed is equal to the unchanged number and display message accordingly*/
            IO.println("Number is a Palindrome");
        }else{
            IO.println("Number is not a Palindrome");
        }
    }
}
