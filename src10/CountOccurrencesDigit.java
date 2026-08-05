public class CountOccurrencesDigit {

    public static void main(String[] args) {
    IO.println(countOccurance(131141, 1));

    }

    static int countOccurance(int n, int x) {
        if (n == 0) {  /*base case*/
            return 0;
        }
        int count = (n%10 == x) ? n%10 : 0;   /*get the last digit (%10) and if it is equal to x return the digit, if not return 0*/
        return count + countOccurance(n / 10, x);  /*add returned count from the line above and call a copy of the method each time deleting the last digit*/
    }
}
