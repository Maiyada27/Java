public class MultiplyTwoNumbers {

    public static void main(String[] args) {
        int a = Integer.parseInt(IO.readln("Enter first number: "));  /*take number from user*/
        int b = Integer.parseInt(IO.readln("Enter second number: "));  /*take number from user*/
        IO.println(multiply(a,b));
    }

    static int multiply(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a + multiply(a, b - 1);
    }
}
