public class CountDownandCountUp {
    public static void main(String[] args) {
        int n = Integer.parseInt(IO.readln("Enter number: "));  /*take number from user*/
        countDownUp(n);  /*call method*/
    }

        static void countDownUp(int n) {
            if (n == 1) {
                IO.println(1);
                return;
            }
            IO.println(n);
            countDownUp(n-1);
            IO.println(n);
        }
    }

