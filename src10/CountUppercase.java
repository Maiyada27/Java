public class CountUppercase {

    public static void main(String[] args) {
        String word = IO.readln("Enter a word: ");
        IO.println("Number of uppercase letters= " + countUppercase(word));
    }

    static int countUppercase(String s){
        /*base case*/
        if(s.isEmpty()) {
            return 0;
        }
        int count = (Character.isUpperCase(s.charAt(0)))? 1:0;   /*check each character if it is uppercase or not*/
        return count + countUppercase(s.substring(1));
    }
}
