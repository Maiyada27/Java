public class SumOfEvenNumbers {

    public static void main(String[] args) {
     int number = Integer.parseInt(IO.readln("Enter a number: "));
     IO.println("Sum of even numbers= " + evenCount(number));

    }

    static int evenCount(int n){
        if (n==0) {
            return 0;
        }

        int count = (n%2==0)? n:0;     /*check if n is even if it is then return n if not then return 0*/
        return count + evenCount(n-1);  /*add what has been returned from the line above and call a copy of the method subtracting 1 from n*/
    }
}
