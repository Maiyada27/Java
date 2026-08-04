public class CheckIfNumberEven {

    public static void main(String[] args) {

        int n = Integer.parseInt(IO.readln("Enter a number: "));  /*take number from user*/
        IO.println("Is the number even?" + isEven(n));
    }

    static boolean isEven(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 0) {
            return true;
        }

        return isEven(n - 2);
    }
}
