public class PrintNumbers {

    public static void main(String[] args) {
        int n = Integer.parseInt(IO.readln("Enter number: "));  /*take number from user*/
        print(n);  /*call method*/
    }

    static void print(int n){
        if(n==1) {  /*set base case*/
            IO.println(1);
            return;
        }
        print(n-1);    /*call copy of method*/
        IO.println(n);
    }
}
