public class PowerCheck {

    public static void main(String[] args) {
        int n = Integer.parseInt(IO.readln("Enter a number: "));  /*take number from user*/
        IO.println("is the number a power of 2? " + powerCheck(n));
    }

    static boolean powerCheck(int n){
        if(n==1) {
            return true;
        }
        if(n==0 || n%2 != 0){
            return false; }

        return powerCheck(n/2);
    }
}
