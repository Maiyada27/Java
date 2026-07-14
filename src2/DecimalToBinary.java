public class DecimalToBinary {

    public static void main(String[] args){
        int number = 25; /*set a number as a variable*/
        int unchangedNumber = 25; /*this will remain unchanged*/
        int remainder; /*set remainder that will be used in loop*/
        String binary = ""; /*set binary as string because we dont want numbers adding up*/

        while (number!=0){
            remainder = number%2;
            binary = remainder + binary;
            number = number/2;      /*use while loop to get remainder and add remainder each time to binary then divide by 2 until number is 0*/

        }
        IO.println("Decimal number = " + unchangedNumber);
        IO.println("Binary number = " + binary); /*print result*/
    }
}
