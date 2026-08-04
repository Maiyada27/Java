public class CountDigits {

    public static void main(String[] args) {
        int n = Integer.parseInt(IO.readln("Enter number: "));  /*take number from user*/

        IO.println("Number of digits: " + countDigits(n));  /*call and print method*/
    }

    static int countDigits(int n) {
        if (n < 10) {
            return 1;
        }
        int counter = 0;
        return 1 + countDigits(n / 10);
    }
}
