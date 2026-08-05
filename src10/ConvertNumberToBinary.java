public class ConvertNumberToBinary {

    public static void main(String[] args) {
        IO.println("Then number 5 converted to binary=  " + convert(5));

    }

    static String convert(int s){
        /*base case*/
        if(s==0) {
            return "0";
        }
        if(s==1) {
            return "1";
        }
        return convert(s/2) + s%2;  /*if remainder is 1 it will return 1, if 0 return 0. This will be returned as string*/

    }

}
