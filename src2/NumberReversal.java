public class NumberReversal {


    public static void main(String[] args){
        Integer number = 12345; /*set the number to string so it can be extracted at characters number*/
        Integer reversed=0; /*new reversed number will be stored in this variable */
        Integer digit;

        while(number != 0){
            digit = number % 10;
            reversed = reversed*10 + digit;
            number = number/10;


        }

        IO.println("Reversed number = " + reversed);/*print the reversed*/
    }
}

