public class SumOfDigits {

    public static void main(String[] args) {
        int n = Integer.parseInt(IO.readln("Enter a number: "));  /*take number from user*/
        IO.println("Sum of digits: " + sum(n));
    }

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n%10 + sum(n/10);
    }

}