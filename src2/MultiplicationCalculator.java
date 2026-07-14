public class MultiplicationCalculator {

    public static void main(String[] args){
        int start = 1;  /*define range for multiplication start and end */
        int end = 5;
        int multiplication = 1; /*set a variable to 1 that will be used to store result in loop*/

        for(int i=start; i<=end; i++) {
            multiplication = multiplication * i;
        }                                         /*use a loop to multiply each number by the previous number*/


        IO.println(multiplication);  /*print result*/

    }
}
