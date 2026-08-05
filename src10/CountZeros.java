public class CountZeros {

    public static void main(String[] args) {
    IO.println(countZeros(9));

    }

    static int countZeros(int n) {
        if (n == 0) {
            return 1;
        }
        int counterz = (n%10 == 0)? 1:0;
       if (n < 10) {
            return counterz;
        }
        return counterz + countZeros(n/10);
    }
}
