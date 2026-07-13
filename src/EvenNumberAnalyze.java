public class EvenNumberAnalyze {


    public static void main(String[] args) {
        Integer Limit = 20;
        Integer Count = 0;
        Integer Sum = 0;


        for (int i = 1;   i <= Limit; i++){
            if (i % 2 == 0) {
                Count = Count + 1;  /*If the number is even add 1 to the count*/
                Sum = Sum + i;  /*If the number is even add it to the sum of all even numbers*/
                System.out.println(i); /*Print only even numbers*/
            }

        }
        System.out.println("Count = " + Count);  /*Prints the count */
        System.out.println("Sum = " + Sum);  /*Prints the Sum*/
    }
}
