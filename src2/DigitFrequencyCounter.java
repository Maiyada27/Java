public class DigitFrequencyCounter {


    public static void main(String[] args){
        int number = 1122333; /*set the number*/
        int numberUnchanged = 1122333; /*this will remain unchanged*/
        int targetNumber = 3; /*choose the target number*/
        int count = 0; /*set count and digit to 0, will be used in loop*/
        int digit = 0;

        while(number != 0){
            digit = number%10;   /*get remainder from dividing by 10 to get the last number and set digit to it*/
            if (digit == targetNumber){
                count = count +1;       /*if digit is equal to target number add it by 1*/
            }
            number = number/10;         /*divide by 10 to remove the last number*/
        }
        IO.println("Number = " + numberUnchanged);
        IO.println("Target = " + targetNumber);
        IO.println("Frequency = " + count);
    }
}
