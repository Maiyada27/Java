public class RaiseNumberToPower {

    public static void main(String[] args) {

        IO.println(power(3,4));
    }

    static int power(int n, int e) {
        if (e == 0) {
            return 1;     /*base case*/
        }
        if (e % 2 == 0) {
            return power(n, e/2)* power(n, e/2);   /*if the exponent is even multiply it by itself*/
        } else {
            return n*power(n, e/2)*power(n, e/2);  /*if it is odd multiply extra base*/

        }
    }

}
