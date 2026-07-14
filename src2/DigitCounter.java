public class DigitCounter {


    public static void main(String[] args){
        int number = 123456; /*set variable called number with a number*/
        int numberUnchanged = 123456;/*set another variable with the same number that will remain unchanged*/
        int counter = 0;/*set counter to 0*/

        while(number != 0) {
            number = number/10;
            counter = counter + 1;   /*use while loop to divide by 10 to remove the last digit and add counter to 1 each time. Loop stops when number is 0*/
        }

        IO.println("The number " + numberUnchanged + " has " + counter + " digits");  /*print result*/
    }
}
