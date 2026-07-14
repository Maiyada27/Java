public class FibonacciSequence {

    public static void main(String[] args) {
        Integer first = 0;/*give value for first number */
        Integer second = 1;/*give value for second number*/
        Integer next = 1;/*will use this to store the next value in loop*/

        IO.print(first + " ");/*prints first number*/
        IO.print(second + " ");/*prints second number*/

        for(int i=1; i <= 13; i++){
            next = first + second;
            first = second;
            second = next;
            IO.print(next + " ");
        }

    }
}
